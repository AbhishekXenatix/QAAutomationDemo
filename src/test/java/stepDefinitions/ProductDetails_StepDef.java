package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

public class ProductDetails_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @When("User Click On Specific Product {string}")
    public void UserClickOnSpecificProduct(String product) {
        homePage.clickOnSpecificProductTOseeDetails(product);
    }


    @Then("The product's Details Page Must Be Appeared {string}")
    public void theProductSDetailsPageMustBeAppeared(String product) {
        homePage.assertdirectedtoproductdeatailspage(product);

    }
}
