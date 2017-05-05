package teamagam.ConnectionTest;

import android.os.AsyncTask;

public class ValidatorAsyncTask extends AsyncTask<String, Void, String> {

    private Validator mValidator;
    private Displayer mDisplayer;

    public ValidatorAsyncTask(Validator validator, Displayer displayer) {
        mValidator = validator;
        mDisplayer = displayer;
    }

    @Override
    protected String doInBackground(String... params) {
        if(mValidator.validate(params[0])) {
           return "Yes";
        }
        return "No";
    }

    @Override
    protected void onPostExecute(String message) {
        if(message.equals("Yes")) {
            mDisplayer.displayOK();
        }
        else {
            mDisplayer.displayFaild();
        }
    }


    public interface Displayer {

        void displayOK();

        void displayFaild();
    }


}
