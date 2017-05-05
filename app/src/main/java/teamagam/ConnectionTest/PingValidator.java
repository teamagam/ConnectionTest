package teamagam.ConnectionTest;

import java.io.IOException;

public class PingValidator implements Validator {
    private static final String[] sSTRINGS_TO_REMOVE_URL_STRING = {"http://", "https://"};

    public boolean validate(String urlString) {
        boolean reachable = false;
        urlString = fixUrlString(urlString);
        try {
            Process p1 = Runtime.getRuntime().exec("ping -c 1 " + urlString);
            int returnVal = p1.waitFor();
            reachable = (returnVal == 0);
            return reachable;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return reachable;
    }

    private String fixUrlString(String urlString) {
        for (String strToRemove : sSTRINGS_TO_REMOVE_URL_STRING) {
            urlString = urlString.replace(strToRemove, "");
        }
        return urlString;
    }
}
