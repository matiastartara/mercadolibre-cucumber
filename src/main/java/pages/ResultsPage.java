package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

    String item = "//ol[contains(@class, 'ui-search-layout')]//li[position()=%s]";

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectsItem(String index) {

        int attempts = 0;
        while (attempts < 3) {
            try {
                String itemSelected = String.format(item, index);
                WebElement element = getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemSelected)));
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
                getWait().until(ExpectedConditions.elementToBeClickable(element)).click();

                break;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }

        waitForPageToLoad();
    }

}
