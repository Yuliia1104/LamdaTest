package LamdaTest.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.ref.SoftReference;

public class ProgressBarTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testProgressBarPercentages() throws InterruptedException {
        homePage.clickBootstrapProgressBar()
                    .isTransferredToBootstrapPage()
                    .clickStartDownloadButton();
        String actualPercentage = bootstrapProgressBarPage.getProgressBarPercentages();
        String actualMessage = bootstrapProgressBarPage.getDownloadCompletionMessage();
        softAssert.assertEquals(actualMessage, testData.expectedMessage, "\n The message is incorrect! \n");
        softAssert.assertEquals(actualPercentage, testData.expectedPercentages, "\n The percentage is not 100% \n");
        softAssert.assertAll();

    }
}
