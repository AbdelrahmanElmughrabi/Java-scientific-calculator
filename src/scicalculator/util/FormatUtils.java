package scicalculator.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Utility class for number formatting and display
 * Handles conversion between numbers and display strings
 * Provides consistent formatting across the calculator
 *
 * @author Abdelrahman
 */
public class FormatUtils {

    private static final int MAX_DISPLAY_LENGTH = 15;
    private static final int MAX_DECIMAL_PLACES = 10;

    /**
     * Private constructor to prevent instantiation
     */
    private FormatUtils() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    /**
     * Format a number for display in the calculator
     * Handles scientific notation for very large/small numbers
     * @param value The number to format
     * @return The formatted display string
     */
    public static String formatNumber(double value) {
        // TODO: Implement number formatting
        // - Handle special cases (NaN, Infinity)
        // - Use scientific notation for large/small numbers
        // - Limit decimal places to prevent overflow
        // - Remove trailing zeros
        return String.valueOf(value);
    }

    /**
     * Format a number with specified decimal places
     * @param value The number to format
     * @param decimalPlaces The number of decimal places
     * @return The formatted string
     */
    public static String formatNumber(double value, int decimalPlaces) {
        // TODO: Implement formatting with specific decimal places
        // Use DecimalFormat for precision
        return String.valueOf(value);
    }

    /**
     * Parse a display string to a double value
     * @param displayText The text from the display
     * @return The parsed number
     * @throws NumberFormatException If the text cannot be parsed
     */
    public static double parseNumber(String displayText) throws NumberFormatException {
        // TODO: Implement parsing
        // Handle empty strings, special characters
        // Validate input before parsing
        if (displayText == null || displayText.isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(displayText);
    }

    /**
     * Check if a string represents a valid number
     * @param text The text to validate
     * @return True if valid number, false otherwise
     */
    public static boolean isValidNumber(String text) {
        // TODO: Implement validation
        // Check for valid number format
        // Allow decimals, negatives, etc.
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Remove trailing zeros from decimal number string
     * @param numberString The number string
     * @return The cleaned string
     */
    public static String removeTrailingZeros(String numberString) {
        // TODO: Implement trailing zero removal
        // Preserve at least one digit after decimal
        // Examples: "3.50" -> "3.5", "4.00" -> "4"
        return numberString;
    }

    /**
     * Truncate display text to maximum length
     * @param text The text to truncate
     * @return The truncated text
     */
    public static String truncateDisplay(String text) {
        // TODO: Implement truncation
        // Ensure display doesn't overflow
        if (text.length() > MAX_DISPLAY_LENGTH) {
            return text.substring(0, MAX_DISPLAY_LENGTH);
        }
        return text;
    }

    /**
     * Format an operation for history display
     * @param operand1 The first operand
     * @param operator The operator symbol
     * @param operand2 The second operand
     * @return The formatted history string (e.g., "5 + 3 =")
     */
    public static String formatHistory(double operand1, String operator, double operand2) {
        // TODO: Implement history formatting
        // Create readable history string
        return formatNumber(operand1) + " " + operator + " " + formatNumber(operand2) + " =";
    }

    /**
     * Format a scientific notation number
     * @param value The value to format
     * @return The scientific notation string
     */
    public static String formatScientific(double value) {
        // TODO: Implement scientific notation formatting
        // Use format like "1.23E+10"
        DecimalFormat scientificFormat = new DecimalFormat("0.##E0");
        return scientificFormat.format(value);
    }

    /**
     * Check if number should be displayed in scientific notation
     * @param value The value to check
     * @return True if scientific notation should be used
     */
    public static boolean shouldUseScientific(double value) {
        // TODO: Implement logic to determine when to use scientific notation
        // Typically for very large (>1E10) or very small (<1E-6) numbers
        double absValue = Math.abs(value);
        return (absValue != 0.0 && (absValue >= 1E10 || absValue < 1E-6));
    }

    /**
     * Get maximum display length
     * @return The maximum number of characters for display
     */
    public static int getMaxDisplayLength() {
        return MAX_DISPLAY_LENGTH;
    }
}
