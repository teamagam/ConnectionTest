package teamagam.ConnectionTest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class connectionTestActivity extends AppCompatActivity {

    private EditText mIpEditText;
    private TextView mHttpResultTextView;
    private TextView mPingResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);

        setupUiElements();
        refreshStatus(null);

    }

    public class DisplayResultToTextView implements ValidatorAsyncTask.Displayer {

        private TextView mResultTextView;

        public DisplayResultToTextView(TextView resultTextView) {
            mResultTextView = resultTextView;
            mResultTextView.setText(R.string.checking);
            mResultTextView.setTextColor(ContextCompat.getColor(connectionTestActivity.this, R.color.blue));
    }

    @Override
    public void displayOK() {
        mResultTextView.setText(R.string.positive_result);
        mResultTextView.setTextColor(ContextCompat.getColor(connectionTestActivity.this, R.color.green));
    }

    @Override
    public void displayFaild() {
        mResultTextView.setText(R.string.no_answer_result);
        mResultTextView.setTextColor(ContextCompat.getColor(connectionTestActivity.this, R.color.red));
    }
    }

    private void setupUiElements() {
        mIpEditText = (EditText) findViewById(R.id.ip_editText);
        mHttpResultTextView = (TextView) findViewById(R.id.http_result_textView);
        mPingResultTextView = (TextView) findViewById(R.id.ping_result_textView);
    }

    public void refreshStatus(View view) {
        pingCheck();
        httpCheck();
    }

    private void httpCheck() {
        Validator httpValidator = new HttpValidator();
        ValidatorAsyncTask.Displayer httpDisplayer = new DisplayResultToTextView(mHttpResultTextView);
        ValidatorAsyncTask httpTask = new ValidatorAsyncTask(httpValidator, httpDisplayer);
        httpTask.execute(mIpEditText.getText().toString());
    }

    private void pingCheck() {
        Validator pingValidator = new PingValidator();
        ValidatorAsyncTask.Displayer pingDisplayer = new DisplayResultToTextView(mPingResultTextView);
        ValidatorAsyncTask pingTask = new ValidatorAsyncTask(pingValidator, pingDisplayer);
        pingTask.execute(mIpEditText.getText().toString());
    }
}


