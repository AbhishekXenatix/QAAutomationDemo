package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.*;

public class LoginPage {

    // locators
    private By usernameField = By.id("input-email");
    private By passwordField = By.id("input-password");
    private By loginButton = By.cssSelector("[value='Login']");
    private By warnningMsg = By.cssSelector(".alert");
    private By ForgottenPassword = By.xpath("(//div[@class='form-group'])[2]/a");
    private By newCustomerButton = By.xpath("//a[text()='Continue']");


    // constructor
    public LoginPage(WebDriver driver) {

    }

    // actions

    @Step("Navigate to the login page")
    public void navigateToLoginPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("LoginURL"));
    }

    @Step("Enter username: {0}")
    public void enterUserName(String username) {
        ElementActions.sendData(usernameField, username);
    }

    @Step("Enter password: {0}")
    public void enterPassword(String password) {
        ElementActions.sendData(passwordField, password);
    }

    @Step("Click login button")
    public void clickLoginButton() {
        ElementActions.clickElement(loginButton);
    }

    @Step("Get error message")
    public String getErrorMSG() {
        return ElementActions.getData(warnningMsg);
    }

    @Step("login credentials")
    public void login(String username, String password) {
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void clickForgetpassword() {
        ElementActions.clickElement(ForgottenPassword);
    }


    //validation

    @Step("Assert successful login")
    public void assertSuccessfulLogin() {
        Waits.sleepForCertainTime(1000);
        Validations.validatePageTitle(PropertiesUtils.getPropertyValue("loginSuccessPageTitle"));
        LogsUtils.info("Logged in Successfully");
    }

    @Step("Assert unsuccessful login")
    public void assertUnSuccessfulLogin() {
        Validations.validateContains(getErrorMSG(), PropertiesUtils.getPropertyValue("Login_ErrorMSg"));
    }


}
