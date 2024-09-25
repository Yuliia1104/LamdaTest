package hooks;

import Libs.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Hooks {
    DriverHelper driverHelper = new DriverHelper();

    @Before
    public void setUpBrowser() {
        driverHelper.createWebdriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverHelper.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot on failure");
            File sourcePath = ((TakesScreenshot) DriverHelper.getDriver()).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(System.getProperty("user.dir") + "/resources/screenshots/" + scenario.getName() + ".png");
            try {
                FileHandler.copy(sourcePath, destinationPath);
                System.out.println("Screenshot saved to: " + destinationPath.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (DriverHelper.getDriver() != null) {
            DriverHelper.getDriver().quit();
        }
    }
}


