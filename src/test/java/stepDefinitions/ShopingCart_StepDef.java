package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ShoppingCartPage;

public class ShopingCart_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());

    @And("User Add Product to cart {string}")
    public void UserAddProductToCart(String product) throws InterruptedException {
        homePage.AddSpecificProductToCart(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Then("Confirmation Message Appears For Adding Product To Cart {string}")
    public void ConfirmationMessageAppearsForAddingProductToCart(String product) throws InterruptedException {
        homePage.assertProductAddedToCart(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Given("User Click on Cart Icon")
    public void UserClickonCartIcon() throws InterruptedException {
        homePage.clickOnCartIcon();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @When("User Removes Specific Product From Cart {string}")
    public void UserRemovesSpecificProductFromCart(String product) throws InterruptedException {
        homePage.RemoveSpecificProductFromCart(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Then("Assert Product Removed From Cart Icon {string}")
    public void AssertProductRemovedFromCartIcon(String product) throws InterruptedException {
        homePage.assertProductRemovedFromCarticon(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @When("User Removes Specific Product From Shopping Cart Page {string}")
    public void userRemovesSpecificProductFromShoppingCartPage(String product) throws InterruptedException {
        shoppingCartPage.removeSpecificProductFromCart(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Then("Assert Product Removed From Shopping Cart Page {string}")
    public void assertProductRemovedFromShoppingCartPage(String product) throws InterruptedException {
        shoppingCartPage.assertProductRemovedfromCart(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @When("User Click On Continue Shopping Button")
    public void userClickOnContinueShoppingButton() throws InterruptedException {
        shoppingCartPage.clickContinueShoppingButton();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Then("Assert Directed To Home Page")
    public void assertDirectedToHomePage() throws InterruptedException {
        homePage.assertDirectedToHomePage();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);

    }
}
