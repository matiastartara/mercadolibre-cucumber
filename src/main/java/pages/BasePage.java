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

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }

    protected void type(WebElement e, String text) {
        wait.until(ExpectedConditions.visibilityOf(e));
        e.clear();
        e.sendKeys(text);
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            if (element.isDisplayed())
                return element.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
        return false;
    }

    protected static void selectByText(WebElement element, String text) {
        Select selectElement = new Select(element);
        selectElement.selectByVisibleText(text);
    }

    protected static void selectByIndex(WebElement element, int index) {
        Select selectElement = new Select(element);
        selectElement.selectByIndex(index);
    }

    protected static void selectByValue(WebElement element, String value) {
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);
    }

    protected void waitForPageToLoad() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(driver -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete"));
    }
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
