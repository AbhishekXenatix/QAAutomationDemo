package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.OrderReturnPage;

public class OrderReturn_StepDef {

    OrderReturnPage orderReturnPage = new OrderReturnPage(DriverManager.getDriver());
    HomePage homePage = new HomePage(DriverManager.getDriver());

    @When("User click on order history")
    public void clickonOrderHistory() throws InterruptedException {
        orderReturnPage.clickOrderHistory();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }


    @And("User click on View Order Button")
    public void userClickOnViewOrderButton() throws InterruptedException {
        orderReturnPage.clickViewOrder();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @And("User click on Return button for Specific Product {string}")
    public void userclickonReturnbuttonforSpecificProduct(String product) throws InterruptedException {
        orderReturnPage.clickReturnSpecificProductButton(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }


    @And("User Fill Information For Return Request and submit {string}")
    public void userFillInformationForReturnRequest(String comment) throws InterruptedException {
        orderReturnPage.clickOnFaulty();
        orderReturnPage.clickOnopened();
        orderReturnPage.enterComment(comment);
        orderReturnPage.clickSubmitButton();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }


    @Then("assert submitting your return request")
    public void assertSubmittingYourReturnRequest() {
        orderReturnPage.assertSubmittingyourReturnRequest();
    }

    @And("User Click On Continue Button to navigate To Home Page")
    public void userClickOnContinueButtonToNavigateToHomePage() throws InterruptedException {
        orderReturnPage.clickcontinueButton();
        homePage.assertDirectedToHomePage();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);



    }
}


