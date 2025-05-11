package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaginationPage extends BasePage {

    String pageNumber = "//a[@class='andes-pagination__link' and text()='%s']";

    public PaginationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPageNumber(String page) {
        String xpathPageNumber = String.format(pageNumber, page);
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));

        int attempts = 0;
        while (attempts < 3) {
            try {
                WebElement pageLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathPageNumber)));
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", pageLink);
                pageLink.click();
                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        waitForPageToLoad();
    }

}
