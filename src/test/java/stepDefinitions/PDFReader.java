package stepDefinitions;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

import java.io.File;
import java.io.IOException;

public class PDFReader {

    public static String extractTextFromPDF(String filePath) throws IOException, TikaException {
        File file = new File(filePath);
        String text = "";

        // Try PDFBox first
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            text = stripper.getText(document);
        } catch (Exception e) {
            System.out.println("PDFBox failed, falling back to Tika: " + e.getMessage());
        }

        // If PDFBox returned empty, use Tika
        if (text == null || text.trim().isEmpty()) {
            Tika tika = new Tika();
            text = tika.parseToString(file);
        }

        // Normalize whitespace
        return text.replaceAll("\\s+", " ").trim();
    }
}
