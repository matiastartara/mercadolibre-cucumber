package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    @FindBy(how = How.XPATH,using = "//span[normalize-space(text())='Agregar al carrito']")
    private WebElement addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAddToCartButton(){
        return getWait().until(ExpectedConditions.visibilityOf(addToCartButton));
    }

}
