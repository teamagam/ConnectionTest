package teamagam.ConnectionTest;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConnectionTestActivity extends AppCompatActivity {

    private EditText mIpEditText;
    private TextView mHttpResultTextView;
    private TextView mPingResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);
        setupUiElements();
        testConnections();
    }

    public class UIDisplayer implements ValidatorAsyncTask.Displayer {
        private TextView mResultTextView;

        public UIDisplayer(TextView resultTextView) {
            mResultTextView = resultTextView;
            displayLoading();
        }

        private void displayLoading() {
            displayStatus(R.string.checking, ContextCompat.getColor(ConnectionTestActivity.this, R.color.blue));
        }

        @Override
        public void displayOK() {
            displayStatus(R.string.positive_result, ContextCompat.getColor(ConnectionTestActivity.this, R.color.green));
        }

        @Override
        public void displayFailure() {
            displayStatus(R.string.no_answer_result, ContextCompat.getColor(ConnectionTestActivity.this, R.color.red));
        }

        private void displayStatus(int text, int color) {
            mResultTextView.setText(text);
            mResultTextView.setTextColor(color);
        }
    }

    private void setupUiElements() {
        mIpEditText = (EditText) findViewById(R.id.address_editText);
        mHttpResultTextView = (TextView) findViewById(R.id.http_result_textView);
        mPingResultTextView = (TextView) findViewById(R.id.ping_result_textView);
    }

    public void onTestConnectionsClicked(View view) {
        testConnections();
    }

    private void testConnections() {
        String url = mIpEditText.getText().toString();
        pingCheck(url);
        httpCheck(url);
    }

    private void httpCheck(String url) {
        ValidatorAsyncTask httpTask = new ValidatorAsyncTask(new HttpValidator(), new UIDisplayer(mHttpResultTextView));
        httpTask.execute(url);
    }

    private void pingCheck(String url) {
        ValidatorAsyncTask pingTask = new ValidatorAsyncTask(new PingValidator(), new UIDisplayer(mPingResultTextView));
        pingTask.execute(url);
    }
}


