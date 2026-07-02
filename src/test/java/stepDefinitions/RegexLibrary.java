package stepDefinitions;

import java.util.regex.Pattern;

public class RegexLibrary {

    // --- Company Names ---
    public static final Pattern JP_MORGAN =
            Pattern.compile("J\\s*\\.?\\s*P\\s*\\.?\\s*Morgan", Pattern.CASE_INSENSITIVE);

    public static final Pattern CHASE =
            Pattern.compile("Chase(\\s+Bank)?", Pattern.CASE_INSENSITIVE);

    // --- Account Numbers ---
    // Matches "Account Number 974-51910" with flexible spacing
    public static final Pattern ACCOUNT_NUMBER =
            Pattern.compile("Account\\s*Number\\s*974[-\\s]*51910", Pattern.CASE_INSENSITIVE);

    // --- Statement Periods ---
    // Matches "Statement Period February 27 - March 31, 2021"
    public static final Pattern STATEMENT_PERIOD =
            Pattern.compile("Statement\\s*Period\\s*February\\s*27\\s*-\\s*March\\s*31,\\s*2021",
                    Pattern.CASE_INSENSITIVE);

    // --- Monetary Values ---
    // Matches dollar amounts with commas and decimals
    public static final Pattern DOLLAR_AMOUNT =
            Pattern.compile("\\$?\\d{1,3}(,\\d{3})*(\\.\\d{2})?");

    // --- Dates ---
    // Matches formats like "Mar 2021", "February 27, 2021"
    public static final Pattern DATE_SHORT =
            Pattern.compile("(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s+\\d{4}",
                    Pattern.CASE_INSENSITIVE);

    public static final Pattern DATE_LONG =
            Pattern.compile("[A-Za-z]+\\s+\\d{1,2},\\s*\\d{4}", Pattern.CASE_INSENSITIVE);

    // --- Generic Helpers ---
    public static boolean matches(Pattern pattern, String text) {
        if (text == null) return false;
        return pattern.matcher(text).find();
    }
}

