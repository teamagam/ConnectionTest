package teamagam.ConnectionTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpValidator implements ValidatorAsyncTask.Validator {

    private static final String URL_PREFIX = "http://";

    @Override
    public boolean validate(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) parseUrl(url).openConnection();
            connection.connect();
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private URL parseUrl(String url) throws MalformedURLException {
        if (isUrlPrefixed(url)) {
            return new URL(URL_PREFIX + url);
        } else {
            return new URL(url);
        }
    }

    private boolean isUrlPrefixed(String urlString) {
        return urlString.contains("http://") || urlString.contains("https://");
    }

}
