package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.ShoppingCartPage;

public class Checkout_StepDefs {


    ShoppingCartPage shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
    CheckOutPage checkOutPage = new CheckOutPage(DriverManager.getDriver());

    @When("User Click on Checkout Button To Navigate To Checkout Page")
    public void userClickOnCheckoutButtonToNavigateToCheckoutPage() throws InterruptedException {
        shoppingCartPage.clickCheckoutButton();
        checkOutPage.assertDirectedToCheckOutPage();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @And("User Enters Valid Credentials in Billing Details {string},{string},{string},{string},{string},{string},{string}")
    public void userEntersValidCredentialsInBillingDetails(String fname, String lname, String address, String city, String postcode, String country, String state) throws InterruptedException {
        checkOutPage.billingDetails(fname, lname, address, city, postcode, country, state);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);

    }

    @And("User Confirm Billing Details")
    public void userConfirmBillingDetails() throws InterruptedException {
        checkOutPage.clickContinueButtonPaymentAddress();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);

    }


    @And("User Confirm Delivery Details")
    public void userConfirmDeliveryDetails() throws InterruptedException {
        checkOutPage.clickContinueButtonShippingAddress();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);

    }

    @And("User Select Delivery Method")
    public void userSelectDeliveryMethod() throws InterruptedException {
        checkOutPage.clickContinueButtonShippingMethod();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @And("User Select Payment Method")
    public void userSelectPaymentMethod() throws InterruptedException {
        checkOutPage.clickAgreeToTerms_Conditions();
        checkOutPage.clickContinueButtonPaymentMethod();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);

    }

    @When("Assert order details {string} {string} {string}")
    public void assertOredredProductDetails(String productname, String productPrice, String productQuantity) throws InterruptedException {
        checkOutPage.assertProductDetails(productname, productPrice, productQuantity);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @And("User Confirm Order Details")
    public void userConfirmOrderDetails() throws InterruptedException {
        checkOutPage.clickConfirmOrderButton();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Then("Order Confirmation message appear")
    public void orderConfirmationMessageAppear() throws InterruptedException {
        checkOutPage.assertOrderHasBeenPlaced();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);

    }


}
