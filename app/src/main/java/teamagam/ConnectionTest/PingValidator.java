package teamagam.ConnectionTest;

import java.io.IOException;

public class PingValidator implements ValidatorAsyncTask.Validator {

    private static final String[] URL_PREFIXES = {"http://", "https://"};
    private static final String PING_EXECUTION_CMD = "ping -c 1 ";
    private static final int PING_OK = 0;

    @Override
    public synchronized boolean validate(String url) {
        url = removePrefix(url);
        try {
            Process process = Runtime.getRuntime().exec(PING_EXECUTION_CMD + url);
            int returnVal = process.waitFor();
            return (returnVal == PING_OK);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String removePrefix(String url) {
        for (String prefix : URL_PREFIXES) {
            url = url.replace(prefix, "");
        }
        return url;
    }
}
