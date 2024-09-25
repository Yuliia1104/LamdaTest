package LamdaTest.tests;

import LamdaTest.Pages.BasePage;
import LamdaTest.Pages.BootstrapProgressBarPage;
import LamdaTest.Pages.CheckBoxPage;
import LamdaTest.Pages.HomePage;
import Libs.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;


public class BaseTest {
    protected
    WebDriver driver;
    protected BasePage basePage;
    protected HomePage homePage;
    protected BootstrapProgressBarPage bootstrapProgressBarPage;
    protected TestData testData = new TestData();
    protected CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

        driver.get(testData.AUT_URL);

        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        bootstrapProgressBarPage = new BootstrapProgressBarPage(driver);
        checkBoxPage = new CheckBoxPage(driver);
    }
    @AfterMethod
    public void tearDownAndTakeScreenshot(ITestResult testResult) {
        try {
            if (ITestResult.FAILURE == testResult.getStatus()) {
                takeScreenshot(testResult.getName());
            }
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    protected void takeScreenshot(String testName) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/resources/screenshots/" + testName + ".png");

        try {
            FileHandler.copy(source, destination);
            System.out.println("Screenshot saved for test: " + testName);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}










