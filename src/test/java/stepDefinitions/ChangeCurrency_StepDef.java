package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;



public class ChangeCurrency_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @When("User click on currency icon")
    public void UserClickonCurrencyIcon() {
        homePage.clickOnCurrency();
    }

    @And("User Change Currency to {string}")
    public void userChangeCurrency(String currency) {
        homePage.clickonDesiredCurrency(currency);
    }

    @Then("assert currency Changed Successfully to desired currency {string}")
    public void assertCurrencyChangedSuccessfullyToDesiredCurrency(String currency) {
        homePage.assertCurrencyChangedToNewCurrency(currency);
        homePage.assertcurrencyChangedInproductPrice(currency);
    }
}
