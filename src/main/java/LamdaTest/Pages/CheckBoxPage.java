package LamdaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckBoxPage extends BasePage{
    private By checkBoxHeader = By.xpath("//h1[contains(text(),'Checkbox Demo')]");
    private By checkBox = By.id("isAgeSelected");
    private By checkBoxMesssage = By.id("txtAge");

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxPage isTransferredToCheckBoxDemo(){
        Assert.assertTrue(isElementDisplayed(checkBoxHeader), "Element is not found");
        return this;
    }

    public CheckBoxPage clickCheckBox(){
        click(checkBox);
        return this;
    }

    public String getBoxSuccessMessage(){
       String message =  getMessage(checkBoxMesssage);
        return message;
    }
}
