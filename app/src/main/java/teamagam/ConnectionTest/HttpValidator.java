package teamagam.ConnectionTest;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpValidator extends AsyncTask<String, Void, String> implements Vaildator {

    private static final String STRING_TO_INSERT_IN_URL_STRING= "http://";

    private int mRespondCode;
    private URL mUrl;

    public HttpValidator() {
        mRespondCode = 0;
        mUrl = null;
    }

    @Override
    protected String doInBackground(String... params) {
        if(Validate(params[0])) {
            return "Yes";
        }
        return "No";
    }

    @Override
    protected void onPostExecute(String message) {

    }

    public boolean Validate(String urlString) {
        try {
                if(!urlString.contains("http://") || !urlString.contains("https://")) {
                    mUrl = new URL(STRING_TO_INSERT_IN_URL_STRING + urlString);
                }
                else {
                    mUrl = new URL(urlString);
                }

                HttpURLConnection connection = (HttpURLConnection) mUrl.openConnection();
                mRespondCode = connection.getResponseCode();
                if (mRespondCode == 200) {
                return true;
            }
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
