package stepDefinitions;

import LamdaTest.Pages.CheckBoxPage;
import LamdaTest.Pages.HomePage;
import Libs.DriverHelper;
import Libs.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CheckBoxSteps {
    HomePage homePage = new HomePage(DriverHelper.getDriver());
    CheckBoxPage checkBoxPage = new CheckBoxPage(DriverHelper.getDriver());
    @Given("I am on the CheckBox page")
    public void i_am_on_the_check_box_page() {
        homePage.clickCheckBoxDemo().isTransferredToCheckBoxDemo();
    }
    @When("I click on checkbox")
    public void i_click_on_checkbox() {
        checkBoxPage.clickCheckBox();
    }
    @Then("I should see a message Checked")
    public void i_should_see_a_message_checked() {
        String actualMessage = checkBoxPage.getBoxSuccessMessage();
        Assert.assertEquals(actualMessage, TestData.expectedMessageChecked);
    }

}
