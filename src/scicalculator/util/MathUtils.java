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

    /**
     * Calculate sine of an angle in degrees
     * @param degrees The angle in degrees
     * @return The sine value
     */
    public static double sin(double degrees) {
        return Math.sin(toRadians(degrees));
    }

    /**
     * Calculate cosine of an angle in degrees
     * @param degrees The angle in degrees
     * @return The cosine value
     */
    public static double cos(double degrees) {
        return Math.cos(toRadians(degrees));
    }

    /**
     * Calculate tangent of an angle in degrees
     * @param degrees The angle in degrees
     * @return The tangent value
     * @throws InvalidExpressionException If tangent is undefined (at 90°, 270°, etc.)
     */
    public static double tan(double degrees) throws InvalidExpressionException {
        double radians = toRadians(degrees);
        if (Math.abs(Math.cos(radians)) < 1e-10) {
            throw new InvalidExpressionException("Tangent undefined at this angle");
        }
        return Math.tan(radians);
    }

    /**
     * Calculate arc sine (inverse sine) and return result in degrees
     * @param value The value (must be between -1 and 1)
     * @return The angle in degrees
     * @throws InvalidExpressionException If value is outside [-1, 1]
     */
    public static double asin(double value) throws InvalidExpressionException {
        if (value < -1.0 || value > 1.0) {
            throw new InvalidExpressionException("Arc sine domain error: value must be between -1 and 1");
        }
        return toDegrees(Math.asin(value));
    }

    /**
     * Calculate arc cosine (inverse cosine) and return result in degrees
     * @param value The value (must be between -1 and 1)
     * @return The angle in degrees
     * @throws InvalidExpressionException If value is outside [-1, 1]
     */
    public static double acos(double value) throws InvalidExpressionException {
        if (value < -1.0 || value > 1.0) {
            throw new InvalidExpressionException("Arc cosine domain error: value must be between -1 and 1");
        }
        return toDegrees(Math.acos(value));
    }

    /**
     * Calculate arc tangent (inverse tangent) and return result in degrees
     * @param value The value
     * @return The angle in degrees
     */
    public static double atan(double value) {
        return toDegrees(Math.atan(value));
    }

    /**
     * Calculate base-10 logarithm
     * @param value The value (must be positive)
     * @return The logarithm base 10
     * @throws InvalidExpressionException If value is not positive
     */
    public static double log10(double value) throws InvalidExpressionException {
        if (value <= 0) {
            throw new InvalidExpressionException("Logarithm of non-positive number");
        }
        return Math.log10(value);
    }

    /**
     * Calculate natural logarithm (base e)
     * @param value The value (must be positive)
     * @return The natural logarithm
     * @throws InvalidExpressionException If value is not positive
     */
    public static double ln(double value) throws InvalidExpressionException {
        if (value <= 0) {
            throw new InvalidExpressionException("Natural log of non-positive number");
        }
        return Math.log(value);
    }

    /**
     * Calculate square root
     * @param value The value (must be non-negative)
     * @return The square root
     * @throws InvalidExpressionException If value is negative
     */
    public static double sqrt(double value) throws InvalidExpressionException {
        if (value < 0) {
            throw new InvalidExpressionException("Square root of negative number");
        }
        return Math.sqrt(value);
    }

    /**
     * Calculate power (base raised to exponent)
     * @param base The base value
     * @param exponent The exponent
     * @return The result of base^exponent
     * @throws OverflowException If result is too large
     */
    public static double power(double base, double exponent) throws OverflowException {
        double result = Math.pow(base, exponent);
        checkOverflow(result);
        return result;
    }

    /**
     * Calculate reciprocal (1/x)
     * @param value The value
     * @return The reciprocal
     * @throws DivisionByZeroException If value is zero
     */
    public static double reciprocal(double value) throws DivisionByZeroException {
        return safeDivide(1.0, value);
    }

    /**
     * Negate a value (change sign)
     * @param value The value to negate
     * @return The negated value
     */
    public static double negate(double value) {
        return -value;
    }
}