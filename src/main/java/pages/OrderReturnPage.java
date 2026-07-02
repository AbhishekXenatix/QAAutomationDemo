package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import utils.ElementActions;
import utils.Validations;

public class OrderReturnPage {

    //locators

    private By orderHistorty = By.linkText("history");
    private By viewOrder = By.cssSelector("[data-original-title='View']");
    private By faulty = By.cssSelector("[value='4']");
    private By opened = By.cssSelector("[value='1']");
    private By commentField = By.id("input-comment");
    private By submitButton = By.cssSelector("[value='Submit']");
    private By returnMSG = By.xpath("//*[@id='content']//p[1]");
    private By continueButton = By.linkText("Continue");

    // constructor

    public OrderReturnPage(WebDriver driver) {
    }

    // actions

    public void clickOrderHistory() {
        ElementActions.clickElement(orderHistorty);
    }

    public void clickViewOrder() {
        ElementActions.clickElement(viewOrder);
    }

    public void clickReturnSpecificProductButton(String product) {
        By ReturnBtn = RelativeLocator.with(By.cssSelector("[data-original-title='Return']")).straightRightOf(By.xpath("//td[contains(.,'" + product + "')]"));
        ElementActions.clickElement(ReturnBtn);
    }

    public void clickOnopened() {
        ElementActions.clickElement(opened);
    }

    public void clickOnFaulty() {
        ElementActions.clickElement(faulty);
    }

    public void enterComment(String comment) {
        ElementActions.sendData(commentField, comment);
    }

    public void clickSubmitButton() {
        ElementActions.clickElement(submitButton);
    }

    public void clickcontinueButton() {
        ElementActions.clickElement(continueButton);
    }

    public String getMsg() {
        return ElementActions.getData(returnMSG);
    }

    public void assertSubmittingyourReturnRequest() {
        Validations.validateContains(getMsg(), "Thank you for submitting your return request");
    }


}
