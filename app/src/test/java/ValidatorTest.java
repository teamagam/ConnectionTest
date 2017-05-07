import org.junit.Test;

import teamagam.ConnectionTest.HttpValidator;
import teamagam.ConnectionTest.PingValidator;
import teamagam.ConnectionTest.Validator;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;


public class ValidatorTest {

    private static final String RELIABLE_SERVER_ADDRESS = "google.com";
    private static final String UNRELIABLE_SERVER_ADDRESS = "Mamas42Empire";

    @Test
    public void workingPingTest() {
        Validator pingValidator = new PingValidator();
        boolean validationCheckResult = pingValidator.validate(RELIABLE_SERVER_ADDRESS);
        assertTrue(validationCheckResult);
    }

    @Test
    public void workingHttpTest() {
        Validator httpValidator = new HttpValidator();
        boolean validationCheckResult = httpValidator.validate(RELIABLE_SERVER_ADDRESS);
        assertTrue(validationCheckResult);
    }

    @Test
    public void failedPingTest() {
        Validator pingValidator = new PingValidator();
        boolean validationCheckResult = pingValidator.validate(UNRELIABLE_SERVER_ADDRESS);
        assertFalse(validationCheckResult);
    }

    @Test
    public void failedHttpTest() {
        Validator httpValidator = new HttpValidator();
        boolean validationCheckResult = httpValidator.validate(UNRELIABLE_SERVER_ADDRESS);
        assertFalse(validationCheckResult);
    }
}
