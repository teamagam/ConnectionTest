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
    protected Boolean doInBackground(String... params) {
        if (mValidator.validate(params[0])) {
            return true;
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean validatorResult) {
        if (validatorResult) {
            mDisplayer.displayOK();
        } else {
            mDisplayer.displayFaild();
        }
    }


    public interface Displayer {
        void displayOK();

        void displayFaild();
    }


}
