package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(how = How.CSS, using = "input.nav-search-input")
    private WebElement searchInput;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String element) {
        getWait().until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.sendKeys(element + Keys.ENTER);
    }

}
