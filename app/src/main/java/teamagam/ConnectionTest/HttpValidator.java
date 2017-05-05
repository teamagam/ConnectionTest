package teamagam.ConnectionTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpValidator implements Validator {

    private static final String sSTRING_TO_INSERT_IN_URL_STRING = "http://";
    private static final Integer sEXPECTED_RESPONSE_CODE = 200;

    private int mRespondCode;
    private URL mUrl;

    public HttpValidator() {
        mRespondCode = 0;
        mUrl = null;
    }

    public boolean validate(String urlString) {
        try {
            if (!urlString.contains("http://") && !urlString.contains("https://")) {
                mUrl = new URL(sSTRING_TO_INSERT_IN_URL_STRING + urlString);
            } else {
                mUrl = new URL(urlString);
            }

            HttpURLConnection connection = (HttpURLConnection) mUrl.openConnection();
            mRespondCode = connection.getResponseCode();
            if (mRespondCode == sEXPECTED_RESPONSE_CODE) {
                return true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
