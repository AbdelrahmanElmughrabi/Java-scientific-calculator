package scicalculator1.model;

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
    MODULO("mod", false),

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
    EXP("exp", true),
    TENPOWX("10^", true),

    // Scientific operations - Power and roots
    POWER("^", false),
    SQRT("√", true),
    SQUARE("x²", true),

    // Other scientific operations
    FACTORIAL("!", true),
    PERCENT("%", true),
    RECIPROCAL("1/x", true),
    ABS("|x|", true),
    NEGATE("±", true);

    private final String symbol;
    private final boolean isUnary;

    /**
     * Constructor for Operation enum
     * @param symbol The display symbol for the operation
     * @param isUnary True if operation takes one operand, false for two
     * @author Muahmmadjibril
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
