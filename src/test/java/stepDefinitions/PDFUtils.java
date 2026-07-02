package stepDefinitions;

public class PDFUtils {

    // Normalize PDF text: collapse whitespace, trim edges
    public static String normalizeText(String text) {
        if (text == null) return "";
        return text.replaceAll("\\s+", " ").trim();
    }

    // Return a snippet (first 200 chars) for Allure attachments
    public static String snippet(String text) {
        if (text == null) return "";
        return text.substring(0, Math.min(300, text.length()));
    }

    // Flexible match: exact contains or regex
    public static boolean matchText(String actual, String expected) {
        if (actual == null || expected == null) return false;

        String normalized = normalizeText(actual);

        // Special regex case for account number
        if (expected.equalsIgnoreCase("Account Number 974-51910")) {
            return normalized.matches(".*Account.*974-51910.*");
        }
        return normalized.contains(expected);
    }

    // Generate diff for Allure attachment
    public static String generateDiff(String expected, String actual) {
        String normalized = normalizeText(actual);
        if (!normalized.contains(expected)) {
            return "❌ Expected: " + expected + "\n\n"
                    + "But Actual did not contain it.\n\n"
                    + "Snippet of Actual:\n" + snippet(normalized);
        }
        return "✅ Expected text was found successfully.";
    }
}

