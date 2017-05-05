import org.junit.Test;

import teamagam.ConnectionTest.HttpValidator;
import teamagam.ConnectionTest.PingValidator;
import teamagam.ConnectionTest.Validator;

import static junit.framework.TestCase.assertEquals;

public class VaildatorTest {

    private static final String RELIABLE_SERVER_ADDRESS = "google.com";
    private static final String UNRELIABLE_SERVER_ADDRESS = "Mamas42Empire";

    @Test
    public void workingPingTest() {
        Validator pingValidator = new PingValidator();
        boolean validationCheckResult = pingValidator.validate(RELIABLE_SERVER_ADDRESS);
        assertEquals(true, validationCheckResult);
    }

    @Test
    public void workingHttpTest() {
        Validator httpValidator = new HttpValidator();
        boolean validationCheckResult = httpValidator.validate(RELIABLE_SERVER_ADDRESS);
        assertEquals(true, validationCheckResult);
    }

    @Test
    public void failedPingTest() {
        Validator pingValidator = new PingValidator();
        boolean validationCheckResult = pingValidator.validate(UNRELIABLE_SERVER_ADDRESS);
        assertEquals(false, validationCheckResult);
    }

    @Test
    public void failedHttpTest() {
        Validator httpValidator = new HttpValidator();
        boolean validationCheckResult = httpValidator.validate(UNRELIABLE_SERVER_ADDRESS);
        assertEquals(false, validationCheckResult);
    }
}
