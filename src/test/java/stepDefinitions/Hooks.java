package stepDefinitions;


import drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserActions;
import utils.FilesUtils;
import utils.LogsUtils;
import utils.PropertiesUtils;


import io.cucumber.java.*;
import utils.*;
import java.io.File;

import java.io.File;

public class Hooks {

    static File allure_results = new File("test-outputs/allure-results");
    static File LOGS_PATH = new File("test-outputs/Logs");


    //configuration
    @BeforeAll
    public static void setup() {
        PropertiesUtils.loadProperties();
        DriverManager.initializeDriver();
        LogsUtils.info(" Test Execution Start :");
        FilesUtils.cleanFiles(allure_results);
        FilesUtils.cleanFiles(LOGS_PATH);
    }

    @After
    public static void report(Scenario scenario) {

        final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");

        //AllureUtils.attachLogsToAllure();
    }

    @AfterAll
    public static void tearDown() {
        LogsUtils.info("Test Execution Finished");
        BrowserActions.closeBrowser();
    }


}
