package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultsPage extends BasePage {

    String item = "//ol[contains(@class, 'ui-search-layout')]//li[position()=%s]//h2//a";

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public void selectsItem(String index) {
        String itemSelected = String.format(item, index);
        WebElement element = getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(itemSelected)));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
