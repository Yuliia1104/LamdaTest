package LamdaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By bootstrapProgressBar = By.linkText("Bootstrap Progress bar");
    private By checkboxDemo = By.linkText("Checkbox Demo");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BootstrapProgressBarPage clickBootstrapProgressBar(){
        click(bootstrapProgressBar);
        return new BootstrapProgressBarPage(driver);
    }
    public CheckBoxPage clickCheckBoxDemo(){
        click(checkboxDemo);
        return new CheckBoxPage(driver);
    }

}
