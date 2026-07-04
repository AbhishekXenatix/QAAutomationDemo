package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ShoppingCartPage;

public class UpdateQuantity_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());

    @When("User Click On View Cart To Navigate To Shopping Cart Page")
    public void UserClickOnViewCartToNavigateToShoppingCartPage() throws InterruptedException {
        homePage.clickOnViewCartIcon();
        homePage.assertDirectedToViewCartPage();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);
    }

    @And("User Change The Quantity of the product {string} {string}")
    public void userChangeTheQuantityOfTheProduct(String product, String quantity) throws InterruptedException {
        shoppingCartPage.addQuantityToSpecificProduct(product, quantity);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);
    }

    @And("User Click on Update Icon for product {string}")
    public void userClickOnUpdateIcon(String product) throws InterruptedException {
        shoppingCartPage.clickUpdateButtonToSpecificProduct(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);
    }

    @Then("The Quantity of the product Must Be Changed")
    public void theQuantityOfTheProductMustBeChanged() throws InterruptedException {
        shoppingCartPage.assertQuantityUpdatedSuccessfully();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);

    }


}
