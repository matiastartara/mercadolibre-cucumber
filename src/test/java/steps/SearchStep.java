package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.PaginationPage;
import pages.ProductPage;
import pages.ResultsPage;
import utils.Driver;

import java.net.MalformedURLException;

public class SearchStep {

    private HomePage homePage;
    private PaginationPage page;
    private ResultsPage resultsPage;
    private ProductPage productPage;

    @Given("the user is on the home page")
    public void user_is_on_the_home_page() throws MalformedURLException {
        homePage = new HomePage(Driver.get());
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String element) {
        homePage.search(element);
    }
    @When("navigates to page {string}")
    public void navigates_to_page(String pageNumber) throws MalformedURLException {
         page = new PaginationPage(Driver.get());
         page.clickOnPageNumber(pageNumber);

    }
    @When("selects the {string} item")
    public void selects_the_item(String itemNumber) throws MalformedURLException {
        resultsPage = new ResultsPage(Driver.get());
        resultsPage.selectsItem(itemNumber);
    }
    @Then("the user should be able to add the item to the cart")
    public void the_user_should_be_able_to_add_the_item_to_the_cart() throws MalformedURLException {
        productPage = new ProductPage(Driver.get());
        Assert.assertTrue(productPage.getAddToCartButton().isDisplayed());
        Assert.assertTrue(productPage.getAddToCartButton().isEnabled());
    }

}
