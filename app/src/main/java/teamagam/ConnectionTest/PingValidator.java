package teamagam.ConnectionTest;

import android.os.AsyncTask;

import java.io.IOException;

public class PingValidator extends AsyncTask<String, Void, String> implements Vaildator {

    private static final String[] STRINGS_TO_REMOVE_URL_STRING= {"http://","https://"};

    public boolean Validate(String urlString) {
        boolean reachable = false;
        urlString = FixUrlString(urlString);
        try {
            Process p1 = Runtime.getRuntime().exec("ping -c 1 " + urlString);
            int returnVal = p1.waitFor();
            reachable = (returnVal==0);
            return reachable;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return reachable;
    }

    private String FixUrlString(String urlString) {
        for (String strToRemove : STRINGS_TO_REMOVE_URL_STRING) {
            urlString = urlString.replace(strToRemove,"");
        }
        return urlString;
    }

    @Override
    protected String doInBackground(String... params) {
        if(Validate(params[0]))
        {
            return "Yes";
        }
        return "No";
    }

    @Override
    protected void onPostExecute(String message) {

    }
}
