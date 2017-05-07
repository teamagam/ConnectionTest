package teamagam.ConnectionTest;

import java.io.IOException;

public class PingValidator implements Validator {
    private static final String[] URL_PREFIX = {"http://", "https://"};

    @Override
    public boolean validate(String urlString) {
        urlString = removePrefix(urlString);
        try {
            Process p1 = Runtime.getRuntime().exec("ping -c 1 " + urlString);
            int returnVal = p1.waitFor();
            return (returnVal == 0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String removePrefix(String urlString) {
        for (String strToRemove : URL_PREFIX) {
            urlString = urlString.replace(strToRemove, "");
        }
        return urlString;
    }
}
