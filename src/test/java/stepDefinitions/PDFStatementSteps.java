package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure; // <-- Import the programmatic API
import org.apache.tika.exception.TikaException;
import org.assertj.core.api.Assertions;

import java.io.IOException;

public class PDFStatementSteps {

    private String pdfText;
    private static final String PDF_PATH = "src/test/resources/pdfs/Brokerage_March2021.pdf";

    @Given("I have downloaded the daily statement PDF")
    public void iHaveDownloadedTheDailyStatementPDF() {
        // no-op
    }

    @Given("the PDF file is named {string}")
    public void thePDFFileIsNamed(String fileName) throws IOException, TikaException {
        pdfText = PDFReader.extractTextFromPDF(PDF_PATH);
    }

    @When("I open the PDF file")
    public void iOpenThePDFFile() {
        Assertions.assertThat(pdfText)
                .as("PDF text should not be empty")
                .isNotEmpty();
    }

    @Then("the PDF should contain the text {string}")
    public void thePDFShouldContainTheText(String expectedText) {
        String normalized = PDFUtils.normalizeText(pdfText);

        boolean match;
        if (expectedText.equalsIgnoreCase("Account Number 974-51910")) {
            match = RegexLibrary.matches(RegexLibrary.ACCOUNT_NUMBER, normalized);
        } else if (expectedText.equalsIgnoreCase("J.P.Morgan")) {
            match = RegexLibrary.matches(RegexLibrary.JP_MORGAN, normalized);
        } else {
            match = normalized.contains(expectedText);
        }

        // ---------- Direct Allure API Attachments ----------
        Allure.addAttachment("Expected Text", "text/plain", expectedText);
        Allure.addAttachment("Actual PDF Snippet", "text/plain", PDFUtils.snippet(normalized));
        Allure.addAttachment("Diff (Expected vs Actual)", "text/plain", PDFUtils.generateDiff(expectedText, normalized));

        Assertions.assertThat(match)
                .as("Checking PDF contains expected text: " + expectedText)
                .isTrue();
    }


    // Utility: return first 200 chars
    private String snippet(String text) {
        return text.substring(0, Math.min(200, text.length()));
    }

    // Diff generator
    private String generateDiff(String expected, String actual) {
        if (!actual.contains(expected)) {
            return "❌ Expected: " + expected + "\n\n"
                    + "But Actual did not contain it.\n\n"
                    + "Snippet of Actual:\n" + snippet(actual);
        }
        return "✅ Expected text was found successfully.";
    }

}
