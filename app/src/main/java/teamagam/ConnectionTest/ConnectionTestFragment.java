package teamagam.ConnectionTest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ConnectionTestFragment extends Fragment {

    private EditText mIpEditText;
    private TextView mHttpResultTextView;
    private TextView mPingResultTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connection_test, container);
        setupUiElements(view);
        testConnections();
        return view;
    }

    private void setupUiElements(View view) {
        mIpEditText = (EditText) view.findViewById(R.id.address_editText);
        mHttpResultTextView = (TextView) view.findViewById(R.id.http_result_textView);
        mPingResultTextView = (TextView) view.findViewById(R.id.ping_result_textView);
        Button testConnectionsButton = (Button) view.findViewById(R.id.test_connections_btn);
        testConnectionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testConnections();
            }
        });
    }

    private void testConnections() {
        String url = getUrl();
        pingCheck(url);
        httpCheck(url);
    }

    private String getUrl() {
        return mIpEditText.getText().toString();
    }

    private void httpCheck(String url) {
        ValidatorAsyncTask httpTask = new ValidatorAsyncTask(
                new HttpValidator(),
                new UIDisplayer(mHttpResultTextView));
        httpTask.execute(url);
    }

    private void pingCheck(String url) {
        ValidatorAsyncTask pingTask = new ValidatorAsyncTask(
                new PingValidator(),
                new UIDisplayer(mPingResultTextView));
        pingTask.execute(url);
    }

    private class UIDisplayer implements ValidatorAsyncTask.Displayer {
        private TextView mResultTextView;

        UIDisplayer(TextView resultTextView) {
            mResultTextView = resultTextView;
            displayChecking();
        }

        @Override
        public void displayOK() {
            displayStatus(R.string.positive_result,
                    ContextCompat.getColor(getContext(), R.color.green));
        }

        @Override
        public void displayFailure() {
            displayStatus(R.string.negative_result,
                    ContextCompat.getColor(getContext(), R.color.red));
        }

        private void displayChecking() {
            displayStatus(R.string.checking,
                    ContextCompat.getColor(getContext(), R.color.blue));
        }

        private void displayStatus(int textResId, int color) {
            mResultTextView.setText(textResId);
            mResultTextView.setTextColor(color);
        }
    }
}
