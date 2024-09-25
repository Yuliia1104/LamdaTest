package LamdaTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
    @Test
    public void testCheckBox() {
        homePage.clickCheckBoxDemo()
                    .isTransferredToCheckBoxDemo()
                    .clickCheckBox();
        String actualMessage = checkBoxPage.getBoxSuccessMessage();
        Assert.assertTrue(actualMessage.contains("Checked"), "\n Message does not contain Checked");
    }
}
