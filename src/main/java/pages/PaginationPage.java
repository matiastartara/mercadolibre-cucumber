package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginationPage extends BasePage {

   String pageNumber = "//a[@class='andes-pagination__link' and text()='%s']";

    public PaginationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnPageNumber(String page) {
        String xpathPageNumber = String.format(pageNumber, page);
        WebElement pageLink = getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathPageNumber)));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", pageLink);
        getWait().until(ExpectedConditions.elementToBeClickable(pageLink));
        pageLink.click();
    }

}
