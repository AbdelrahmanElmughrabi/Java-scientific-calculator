package scicalculator.model;

import scicalculator.exception.InvalidExpressionException;

/**
 * Validates and parses mathematical expressions
 * Handles operator precedence and parentheses
 *
 * @author Abdelrahman
 */
public class ExpressionParser {

    /**
     * Validate a mathematical expression
     * @param expression The expression to validate
     * @return True if valid, false otherwise
     */
    public static boolean isValidExpression(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            return false;
        }

        // TODO: Implement expression validation
        // Check for balanced parentheses, valid operators, etc.
        return true;
    }

    /**
     * Validate a number string
     * @param number The number string to validate
     * @return True if valid number format
     */
    public static boolean isValidNumber(String number) {
        if (number == null || number.trim().isEmpty()) {
            return false;
        }

        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Parse a string to double with validation
     * @param value The string value to parse
     * @return The parsed double value
     * @throws InvalidExpressionException If parsing fails
     */
    public static double parseValue(String value) throws InvalidExpressionException {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new InvalidExpressionException("Invalid number format: " + value);
        }
    }

    /**
     * Check if parentheses are balanced in an expression
     * @param expression The expression to check
     * @return True if balanced
     */
    public static boolean areParenthesesBalanced(String expression) {
        int count = 0;
        for (char c : expression.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
