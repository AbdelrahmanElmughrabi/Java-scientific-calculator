package scicalculator.model;

/**
 * Enumeration of all calculator operations
 * Includes both basic and scientific operations
 *
 * @author Abdelrahman
 */
public enum Operation {
    // Basic operations
    ADD("+", false),
    SUBTRACT("-", false),
    MULTIPLY("×", false),
    DIVIDE("÷", false),

    // Scientific operations - Trigonometric
    SIN("sin", true),
    COS("cos", true),
    TAN("tan", true),
    ASIN("asin", true),
    ACOS("acos", true),
    ATAN("atan", true),

    // Scientific operations - Logarithmic
    LOG("log", true),
    LN("ln", true),

    // Scientific operations - Power and roots
    POWER("^", false),
    SQRT("√", true),

    // Other scientific operations
    FACTORIAL("!", true),
    PERCENT("%", true),

    // Special operations
    EQUALS("=", false),
    NEGATE("±", true);

    private final String symbol;
    private final boolean isUnary;

    /**
     * Constructor for Operation enum
     * @param symbol The display symbol for the operation
     * @param isUnary True if operation takes one operand, false for two
     */
    Operation(String symbol, boolean isUnary) {
        this.symbol = symbol;
        this.isUnary = isUnary;
    }

    /**
     * Get the display symbol for this operation
     * @return The symbol string
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Check if this operation is unary (single operand)
     * @return True if unary, false if binary
     */
    public boolean isUnary() {
        return isUnary;
    }
}
