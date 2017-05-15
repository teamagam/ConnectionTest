import org.junit.Before;
import org.junit.Test;

import teamagam.ConnectionTest.HttpValidator;
import teamagam.ConnectionTest.PingValidator;
import teamagam.ConnectionTest.ValidatorAsyncTask;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidatorTest {

    private static final String RELIABLE_SERVER_ADDRESS = "google.com";
    private static final String UNRELIABLE_SERVER_ADDRESS = "Mamas42Empire";

    private ValidatorAsyncTask.Validator mPingValidator;
    private ValidatorAsyncTask.Validator mHttpValidator;

    @Before
    public void setup() {
        mPingValidator = new PingValidator();
        mHttpValidator = new HttpValidator();
    }

    @Test
    public void workingPingTest() {
        boolean validationCheckResult = mPingValidator.validate(RELIABLE_SERVER_ADDRESS);
        assertTrue(validationCheckResult);
    }

    @Test
    public void workingHttpTest() {
        boolean validationCheckResult = mHttpValidator.validate(RELIABLE_SERVER_ADDRESS);
        assertTrue(validationCheckResult);
    }

    @Test
    public void failedPingTest() {
        boolean validationCheckResult = mPingValidator.validate(UNRELIABLE_SERVER_ADDRESS);
        assertFalse(validationCheckResult);
    }

    @Test
    public void failedHttpTest() {
        boolean validationCheckResult = mHttpValidator.validate(UNRELIABLE_SERVER_ADDRESS);
        assertFalse(validationCheckResult);
    }
}
