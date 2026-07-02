package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.HomePage;

public class Search_StepDef {

    HomePage homePage = new HomePage(DriverManager.getDriver());

    @And("User Enter Product in search {string}")
    public void userEnterProductInSearch(String product) throws InterruptedException {
        homePage.searchFeature(product);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }


    @Then("Assert Search Page Appearance of {string}")
    public void assertSearchPageAppearanceOf(String text) throws InterruptedException {
        homePage.assertsuccessfullSearchForSpecificWord(text);
        ScreenshotUtils.attachScreenshot(DriverManager.getDriver(), "");
        Thread.sleep(2000);
    }


}
