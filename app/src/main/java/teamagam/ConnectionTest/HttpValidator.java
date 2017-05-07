package teamagam.ConnectionTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpValidator implements Validator {

    private static final String URL_PREFIX = "http://";
    private static final Integer HTTP_OK_RESPOND_CODE = 200;

    @Override
    public boolean validate(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) setupUrl(url).openConnection();
            connection.connect();
            int mRespondCode = connection.getResponseCode();
            if (mRespondCode == HTTP_OK_RESPOND_CODE) {
                return true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private URL setupUrl(String urlString) throws MalformedURLException {
        if (doesUrlContainsPrefix(urlString)) {
            return new URL(URL_PREFIX + urlString);
        } else {
            return new URL(urlString);
        }
    }

    private boolean doesUrlContainsPrefix(String urlString) {
        return !urlString.contains("http://") && !urlString.contains("https://");
    }

}
