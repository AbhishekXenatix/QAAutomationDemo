package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ChangePasswordPage;
import pages.MyAccountPage;

public class ChangePassword_StepDef {
    MyAccountPage myAccountPage = new MyAccountPage(DriverManager.getDriver());
    ChangePasswordPage changePasswordPage = new ChangePasswordPage(DriverManager.getDriver());


    @And("User Navigate to Change your password page")
    public void UserNavigatetoChangeyourpasswordpage() {
        myAccountPage.clickChangePassword();
    }

    @And("User Enters New Password {string} and press continue")
    public void userEntersNewPasswordAndPressContinue(String password) {
        changePasswordPage.changePassword(password, password);
    }

    @Then("Updating Password successfully message appears")
    public void updatingPasswordSuccessfullyMessageAppears() {
        changePasswordPage.assertPasswordChangedSuccessfullyMSG();
    }

}

