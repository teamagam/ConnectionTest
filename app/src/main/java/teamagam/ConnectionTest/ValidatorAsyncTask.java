package teamagam.ConnectionTest;

import android.os.AsyncTask;

public class ValidatorAsyncTask extends AsyncTask<String, Void, Boolean> {

    private Validator mValidator;
    private Displayer mDisplayer;

    public ValidatorAsyncTask(Validator validator, Displayer displayer) {
        mValidator = validator;
        mDisplayer = displayer;
    }

    @Override
    protected Boolean doInBackground(String... urls) {
        if (mValidator.validate(urls[0])) {
            return true;
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        if (result) {
            mDisplayer.displayOK();
        } else {
            mDisplayer.displayFailure();
        }
    }


    public interface Displayer {
        void displayOK();

        void displayFailure();
    }

    public interface Validator {
        boolean validate(String url);
    }
}
