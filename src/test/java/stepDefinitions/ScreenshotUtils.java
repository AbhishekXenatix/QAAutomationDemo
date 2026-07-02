package stepDefinitions;

import io.qameta.allure.Allure;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {

    // Existing method – works for Allure only
    public static void attachScreenshot(WebDriver driver, String attachmentName) {
        if (driver == null) {
            System.out.println("!!! ERROR: WebDriver is null. Cannot take screenshot.");
            return;
        }
        if (!(driver instanceof TakesScreenshot)) {
            System.out.println("!!! ERROR: Driver does not support screenshot capture.");
            return;
        }
        try {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(screenshotBytes), "png");
            System.out.println(">>> Screenshot attached successfully (Allure): " + attachmentName);
        } catch (Exception e) {
            System.out.println("!!! Could not attach screenshot: " + e.getMessage());
        }
    }

    // NEW method – attaches to both Allure AND Cucumber
    public static void attachScreenshot(WebDriver driver, String attachmentName, Scenario scenario) {
        if (driver == null) {
            System.out.println("!!! ERROR: WebDriver is null. Cannot take screenshot.");
            return;
        }
        if (!(driver instanceof TakesScreenshot)) {
            System.out.println("!!! ERROR: Driver does not support screenshot capture.");
            return;
        }
        try {
            // Capture once
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            // 1. Attach to Allure
            Allure.addAttachment(attachmentName, "image/png", new ByteArrayInputStream(screenshotBytes), "png");
            System.out.println(">>> Screenshot attached successfully (Allure): " + attachmentName);

            // 2. Attach to Cucumber
            if (scenario != null) {
                scenario.attach(screenshotBytes, "image/png", attachmentName);
                System.out.println(">>> Screenshot attached successfully (Cucumber): " + attachmentName);
            }
        } catch (Exception e) {
            System.out.println("!!! Could not attach screenshot: " + e.getMessage());
        }
    }

    public static byte[] takeScreenshot(WebDriver driver) {
        if (driver == null || !(driver instanceof TakesScreenshot)) {
            return new byte[0];
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}