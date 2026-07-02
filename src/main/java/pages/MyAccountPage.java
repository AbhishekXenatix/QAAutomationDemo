package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ElementActions;
import utils.PropertiesUtils;
import utils.Validations;
import utils.Waits;

public class MyAccountPage {
    //locators
    private By editAccountInfo = By.linkText("Edit your account information");
    private By changePassword = By.linkText("Change your password");
    private By MyAccountIcon = By.cssSelector("[title='My Account']");
    private By MyAccountInfo = By.linkText("My Account");
    private By Logout = By.linkText("Logout");

    // constructor

    public MyAccountPage(WebDriver driver) {
    }

    // actions
    public void clickChangePassword() {
        ElementActions.clickElement(changePassword);
    }

    public void clickEditAccountInfo() {
        ElementActions.clickElement(editAccountInfo);
    }

    public void clickMyAccountIcon() {
        ElementActions.clickElement(MyAccountIcon);
    }

    public void clickMyLogoutIcon() {
        ElementActions.clickElement(Logout);
    }


    //validations

    public void assertDirectedToMyAccountURL() {
        Waits.sleepForCertainTime(2000);
        Validations.validatePageUrl(PropertiesUtils.getPropertyValue("MyAccount"));
    }

    public void assertDirectedToChangePasswordPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("changePasswordPageTitle"));
    }

    public void assertDirectedToEditAccountInformationPage() {
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("EditAccountInfoPageTitle"));

    }

    public void clickMyAccountinfo() {
        ElementActions.clickElement(MyAccountInfo);
    }
}
