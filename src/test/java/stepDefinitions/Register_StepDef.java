package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.datafaker.Faker;
import pages.HomePage;
import pages.MyAccountPage;
import pages.RegisterPage;

public class Register_StepDef {

    RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
    HomePage homePage = new HomePage(DriverManager.getDriver());
    MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());

    @And("User Click on Register")
    public void userClickOnRegister() throws InterruptedException {
        homePage.clickOnRegister();
        homePage.assertDirectedToRegisterPage();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);

    }

    @And("User Enters Credentials {string} , {string} ,{string} , {string} ,{string}")
    public void userEntersValidCredentials(String Fname, String Lname, String email, String phone, String password) throws InterruptedException {
        registerPage.registerNewAcount(Fname, Lname, email, phone, password, password);

    }

    @When("User Enters Credentials with random email {string} , {string} , {string} , {string}")
    public void userEntersCredentialsWithRandomEmail(String Fname, String Lname, String phone, String password) throws InterruptedException {
        String name = new Faker().name().firstName();
        String randomEmail = name + "a@a.com";
        registerPage.registerNewAcount(Fname, Lname, randomEmail, phone, password, password);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);
    }



    @Then("Unsuccessfull Registry Message appears")
    public void unsuccessfullRegistryMessageAppears() throws InterruptedException {
        registerPage.validateUnsuccessfulRegistry();

    }



    @Then("Successfully Creation should be displayed")
    public void successfullyCreationShouldBeDisplayed() throws InterruptedException {
        registerPage.assertSuccessfullnewAccountRegistered();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);

    }



    @And("User Click On Continue Button to navigate To My Account Page")
    public void userClickOnContinueButtonToNavigateToMyAccountPage() throws InterruptedException {
        registerPage.clickContinueBtn();
        myAccountPage.assertDirectedToMyAccountURL();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(1000);

    }


}
