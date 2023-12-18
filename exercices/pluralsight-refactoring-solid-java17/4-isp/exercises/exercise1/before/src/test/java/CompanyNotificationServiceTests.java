import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CompanyNotificationServiceTests {
    @Test
    public void doesNotHaveUnneededMethods(){
        var hasSendEmailMethod = TestHelpers.getMethod("CompanyNotificationService", "sendTextMessage").isPresent();
        var hasSendSlackMessageMethod = TestHelpers.getMethod("CompanyNotificationService", "sendInInternalApplication").isPresent();

        assertFalse(hasSendEmailMethod);
        assertFalse(hasSendSlackMessageMethod);
    }
}
