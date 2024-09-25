package LamdaTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BootstrapProgressBarPage extends BasePage {
    private By startDownloadButton = By.id("dwnBtn");
    private By progressBarPercentage = By.cssSelector(".counter");
    private By downloadCompleteMessage = By.xpath("//p[contains(@class, 'success')]");
    private By bootstrapProgressBarHeader = By.xpath("//h1[contains(text(),'Bootstrap Download Progress Demo')]");

    public BootstrapProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public BootstrapProgressBarPage isTransferredToBootstrapPage(){
        isElementDisplayed(bootstrapProgressBarHeader);
        return this;
    }
    public BootstrapProgressBarPage clickStartDownloadButton() {
        click(startDownloadButton);
        return this;
    }

    public String getProgressBarPercentages() throws InterruptedException {
        waitABit(2);
        return getMessage(progressBarPercentage);
    }


    public String getDownloadCompletionMessage() {
        return getMessage(downloadCompleteMessage);
    }
}
