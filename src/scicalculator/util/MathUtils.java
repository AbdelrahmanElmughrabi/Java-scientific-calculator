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
        if (n < 0) {
            throw new InvalidExpressionException("Factorial is not defined for negative numbers");
        }

        if (n > 170) {
            throw new OverflowException("Factorial result is too large");
        }

        double result = 1.0;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }

        checkOverflow(result);
        return result;
    }

    /**
     * Safely perform division with zero checking
     * @param dividend The numerator
     * @param divisor The denominator
     * @return The division result
     * @throws DivisionByZeroException If divisor is zero
     */
    public static double safeDivide(double dividend, double divisor) throws DivisionByZeroException {
        if (divisor == 0.0 || Math.abs(divisor) < 1e-10) {
            throw new DivisionByZeroException("Cannot divide by zero");
        }
        return dividend / divisor;
    }

    /**
     * Safely perform modulo operation with zero checking
     * @param dividend The numerator
     * @param divisor The denominator
     * @return The modulo result
     * @throws DivisionByZeroException If divisor is zero
     */
    public static double safeModulo(double dividend, double divisor) throws DivisionByZeroException {
        if (divisor == 0.0 || Math.abs(divisor) < 1e-10) {
            throw new DivisionByZeroException("Cannot perform modulo with zero");
        }
        return dividend % divisor;
    }

    /**
     * Check if a number is within valid range (not infinite or NaN)
     * @param value The value to check
     * @return True if valid, false otherwise
     */
    public static boolean isValidNumber(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    /**
     * Convert degrees to radians
     * @param degrees The angle in degrees
     * @return The angle in radians
     */
    public static double toRadians(double degrees) {
        return Math.toRadians(degrees);
    }

    /**
     * Convert radians to degrees
     * @param radians The angle in radians
     * @return The angle in degrees
     */
    public static double toDegrees(double radians) {
        return Math.toDegrees(radians);
    }

    /**
     * Check if result will cause overflow
     * @param value The value to check
     * @throws OverflowException If value is too large
     */
    public static void checkOverflow(double value) throws OverflowException {
        if (Double.isInfinite(value)) {
            throw new OverflowException("Value is too large");
        }
    }

    /**
     * Round to specified number of decimal places
     * @param value The value to round
     * @param places The number of decimal places
     * @return The rounded value
     */
    public static double round(double value, int places) {
        if (places < 0) {
            return value;
        }
        double multiplier = Math.pow(10, places);
        return Math.round(value * multiplier) / multiplier;
    }

    /**
     * Calculate percentage
     * @param value The value
     * @param total The total (100%)
     * @return The percentage
     */
    public static double percentage(double value, double total) throws DivisionByZeroException {
        return safeDivide(value, total) * 100;
    }

    
}