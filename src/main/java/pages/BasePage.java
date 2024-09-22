package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    public void type(WebElement e, String text) {
        wait.until(ExpectedConditions.visibilityOf(e));
        e.clear();
        e.sendKeys(text);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            if (element.isDisplayed())
                return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    public static void selectByText(WebElement element, String text) {
        Select selectElement = new Select(element);
        selectElement.selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index) {
        Select selectElement = new Select(element);
        selectElement.selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }
}
