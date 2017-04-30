package teamagam.ConnectionTest;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;

public class Connection_Test_Activity extends AppCompatActivity {

    private EditText ipEditText;
    private TextView httpResultTextView;
    private TextView pingResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_test);

        setupUiElements();
        refreshStatus(null);

    }

       private void setupUiElements() {
        ipEditText = (EditText) findViewById(R.id.ip_editText);
        httpResultTextView = (TextView) findViewById(R.id.http_result_textView);
        pingResultTextView = (TextView) findViewById(R.id.ping_result_textView);
    }

    public void refreshStatus(View view) {
        pingServer();
        httpRequestServer();
    }

    public void pingServer()  {
        String str = "";
        PingValidator job = new PingValidator();
        try {
            str =  job.execute(ipEditText.getText().toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ;
        if( str == "Yes")
        {
            pingResultTextView.setText(R.string.positive_result);
            pingResultTextView.setTextColor(ContextCompat.getColor(this,R.color.green));

        }
        else
        {
            pingResultTextView.setText(R.string.no_answer_result);
            pingResultTextView.setTextColor(ContextCompat.getColor(this,R.color.red));
        }
    }

    public void httpRequestServer()  {
        String str = "";
        HttpValidator job = new HttpValidator();
        try {
            str =  job.execute(ipEditText.getText().toString()).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ;
        if( str == "Yes")
        {
            httpResultTextView.setText(R.string.positive_result);
            httpResultTextView.setTextColor(ContextCompat.getColor(this,R.color.green));

        }
        else
        {
            httpResultTextView.setText(R.string.no_answer_result);
            httpResultTextView.setTextColor(ContextCompat.getColor(this,R.color.red));
        }
    }
}




