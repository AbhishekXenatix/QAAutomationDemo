package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserActions;
import utils.ElementActions;
import utils.PropertiesUtils;
import utils.Validations;

public class EditAccountInfoPage {
    // locators
    private By FirstNameField = By.id("input-firstname");
    private By LastNameField = By.id("input-lastname");
    private By EmailField = By.id("input-email");
    private By TelephoneField = By.id("input-telephone");
    private By ContinueButton = By.cssSelector("[value='Continue']");
    private By pageMSG = By.cssSelector(".alert");

    // constructors
    public EditAccountInfoPage(WebDriver driver) {

    }

    //actions

    public void navigateToEditAccountInfoPage() {
        BrowserActions.navigateToURL(PropertiesUtils.getPropertyValue("EditAccount"));
    }

    @Step("Enter FirstName: {FirstName}")
    public void enterFirstName(String FirstName) {
        ElementActions.sendData(FirstNameField, FirstName);
    }

    @Step("Enter LastName: {0}")
    public void enterLastName(String LastName) {
        ElementActions.sendData(LastNameField, LastName);
    }

    @Step("Enter Email: {Email}")
    public void enterEmail(String Email) {
        ElementActions.sendData(EmailField, Email);
    }

    @Step("Enter Telephone: {Telephone}")
    public void enterTelephone(String Telephone) {
        ElementActions.sendData(TelephoneField, Telephone);
    }

    @Step("click Continue Button")
    public void clickContinueButton() {
        ElementActions.clickElement(ContinueButton);
    }

    public String getpageMsg() {
        return ElementActions.getData(pageMSG);
    }


    public void editAccountInformation(String firstname, String lastname, String telephone) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterTelephone(telephone);
        clickContinueButton();
    }

    // validations

    public void assertUnsuccessfulEditAcountInfoWithALreadyRegisteredEmail() {
        Validations.validateEquals(getpageMsg(), PropertiesUtils.getPropertyValue("already_registered_MSG2"));
    }

    public void assertsuccessfulEditForAcountInfo() {
        Validations.validateEquals(getpageMsg(), PropertiesUtils.getPropertyValue("edit_Account_info_MSG"));
    }


}
