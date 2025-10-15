package scicalculator.util;

import scicalculator.exception.*;

/**
 * Helper class for mathematical utility functions
 * Provides additional mathematical operations and validations
 *
 * @author Abdelrahman
 */
public class MathUtils {

    /**
     * Private constructor to prevent instantiation
     */
    private MathUtils() {
        throw new AssertionError("Utility class should not be instantiated");
    }

    /**
     * Calculate factorial of a number
     * @param n The number to calculate factorial for
     * @return The factorial result
     * @throws InvalidExpressionException If n is negative
     * @throws OverflowException If result exceeds maximum value
     */
    public static double factorial(int n) throws InvalidExpressionException, OverflowException {
        // TODO: Implement factorial calculation
        // Validate that n >= 0
        // Check for overflow conditions
        return 0;
    }

    /**
     * Safely perform division with zero checking
     * @param dividend The numerator
     * @param divisor The denominator
     * @return The division result
     * @throws DivisionByZeroException If divisor is zero
     */
    public static double safeDivide(double dividend, double divisor) throws DivisionByZeroException {
        // TODO: Implement safe division
        // Check if divisor is zero or very close to zero
        // Throw DivisionByZeroException if needed
        return 0;
    }

    /**
     * Check if a number is within valid range (not infinite or NaN)
     * @param value The value to check
     * @return True if valid, false otherwise
     */
    public static boolean isValidNumber(double value) {
        // TODO: Implement validation
        // Check for NaN, Infinity, -Infinity
        return true;
    }

    /**
     * Convert degrees to radians
     * @param degrees The angle in degrees
     * @return The angle in radians
     */
    public static double toRadians(double degrees) {
        // TODO: Implement conversion
        return Math.toRadians(degrees);
    }

    /**
     * Convert radians to degrees
     * @param radians The angle in radians
     * @return The angle in degrees
     */
    public static double toDegrees(double radians) {
        // TODO: Implement conversion
        return Math.toDegrees(radians);
    }

    /**
     * Check if result will cause overflow
     * @param value The value to check
     * @throws OverflowException If value is too large
     */
    public static void checkOverflow(double value) throws OverflowException {
        // TODO: Implement overflow checking
        // Define maximum acceptable value
        // Throw OverflowException if exceeded
    }

    /**
     * Round to specified number of decimal places
     * @param value The value to round
     * @param places The number of decimal places
     * @return The rounded value
     */
    public static double round(double value, int places) {
        // TODO: Implement precise rounding
        // Use BigDecimal for precision if needed
        return value;
    }

    /**
     * Calculate percentage
     * @param value The value
     * @param total The total (100%)
     * @return The percentage
     */
    public static double percentage(double value, double total) {
        // TODO: Implement percentage calculation
        return (value / total) * 100;
    }
}