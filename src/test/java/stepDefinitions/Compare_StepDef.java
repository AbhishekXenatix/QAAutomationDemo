package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class Compare_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @And("User Add Product to Compare List {string}")
    public void UserAddProducttoCompareList(String productName) {
        homePage.AddSpecificProductToComparison(productName);
    }

    @Then("Confirmation Message Appears for adding product to compare list {string}")
    public void confirmationMessageAppears(String productName) {
        homePage.assertProductAddedToComparison(productName);
    }
}
