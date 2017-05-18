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
        return mValidator.validate(urls[0]);
    }

    @Override
    protected void onPostExecute(Boolean valid) {
        if (valid) {
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
