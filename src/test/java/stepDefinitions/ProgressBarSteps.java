package stepDefinitions;

import LamdaTest.Pages.BootstrapProgressBarPage;
import LamdaTest.Pages.HomePage;
import Libs.DriverHelper;
import Libs.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProgressBarSteps {
HomePage homePage = new HomePage(DriverHelper.getDriver());
BootstrapProgressBarPage bootstrapProgressBarPage = new BootstrapProgressBarPage(DriverHelper.getDriver());

    @Given("I am on the Progress Bar page")
    public void i_am_on_the_progress_bar_page() {
        homePage.clickBootstrapProgressBar().isTransferredToBootstrapPage();
    }
    @When("I start the progress bar")
    public void i_start_the_progress_bar() {
        bootstrapProgressBarPage.clickStartDownloadButton();
    }
    @Then("I should see the progress bar reach 100%")
    public void i_should_see_the_progress_bar_reach() throws InterruptedException {
     String  actualPercentage = bootstrapProgressBarPage.getProgressBarPercentages();
        Assert.assertEquals(actualPercentage, TestData.expectedPercentages, "Percentage is not 100%");
    }
    @Then("I should see the Download completed! message")
    public void i_should_see_the_download_completed_message() {
       String actualMessage = bootstrapProgressBarPage.getDownloadCompletionMessage();
       Assert.assertEquals(actualMessage, TestData.expectedMessage, "Download is not completed!");
    }
}
