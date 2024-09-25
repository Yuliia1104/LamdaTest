package LamdaTest.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Supplier;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected <T> T performAction(Supplier<T> action, By locator, String actionDescription) {
        try {
            WebElement element = driver.findElement(locator);
            String elementName = element.getAccessibleName();
            if (elementName == null || elementName.isEmpty()) {
                elementName = "Unnamed Element";
            }
            T result = action.get();
            System.out.println(actionDescription + " is performed on " + elementName + " using " + locator.toString());
            return result;
        } catch (NoSuchElementException e) {
            throw new AssertionError(actionDescription + " failed. Element not found: " + locator.toString() + ". Error: " + e.getMessage());
        } catch (ElementNotInteractableException e) {
            throw new AssertionError(actionDescription + " failed. Element not interactable: " + locator.toString() + ". Error: " + e.getMessage());
        } catch (Exception e) {
            throw new AssertionError(actionDescription + " failed due to error: " + e.getMessage());
        }
    }

    protected void click(By locator) {
        performAction(() -> {
            driver.findElement(locator).click();
            return null;
        }, locator,  "Click Action");
    }

    protected String getMessage(By locator) {
        return performAction(() -> driver.findElement(locator).getText(), locator, "Get Message");
    }

    protected String getElementName(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    protected boolean isElementDisplayed(By locator) {
        return performAction(() -> {
            WebElement element = driver.findElement(locator);
            boolean isDisplayed = element.isDisplayed();

            String message = getElementName(locator) + (isDisplayed ? " element is displayed" : " element is not displayed");
            System.out.println(message);

            return isDisplayed;
        }, locator, "Check if element is displayed");
    }



    protected void waitABit(Integer second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void webDriverWait(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
