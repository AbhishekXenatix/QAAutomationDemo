package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUs_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());
    ContactUsPage contactUsPage = new ContactUsPage(DriverManager.getDriver());

    @When("User Click on Telephone Icon")
    public void UserClickOnTelephoneIcon() {
        homePage.clickOnTelephoneIcon();
    }

    @Then("You must be in Contact Us page")
    public void youMustBeInContactUsPage() {
        contactUsPage.assertDirectedToContactUsPage();
    }

    @When("User fill the required information {string} , {string} , {string} and click submit")
    public void userFillTheRequiredInformation(String FirstName, String EMailAdd, String Enquiry) {
        contactUsPage.fillContactUsForm(FirstName, EMailAdd, Enquiry);
    }

    @Then("The enquiry must be successfully sent to the store owner")
    public void theEnquiryMustBeSuccessfullySentToTheStoreOwner() {
        contactUsPage.assertCofimatiomMessage();
    }
}
