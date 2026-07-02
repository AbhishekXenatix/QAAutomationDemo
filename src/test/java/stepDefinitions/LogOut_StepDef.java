package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.MyAccountPage;

public class LogOut_StepDef {

    MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());

    @And("User Clicks on Logout")
    public void userClicksOnLogout() throws InterruptedException {
        myAccountPage.clickMyLogoutIcon();
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }

    @Then("Account Logout Page Appears")
    public void accountLogoutPageAppears() {

    }
}
