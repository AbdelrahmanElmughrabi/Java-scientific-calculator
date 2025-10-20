package scicalculator1.model;

import scicalculator1.exception.*;
import scicalculator1.util.FormatUtils;
import scicalculator1.util.MathUtils;

/**
 * Core calculation engine for the scientific calculator
 * Handles all mathematical operations and state management
 *
 * @author Abdelrahman
 */
public class CalculatorEngine {
    private CalculatorState state;

    /**
     * Constructor initializes the calculator engine
     */
    public CalculatorEngine() {
        this.state = new CalculatorState();
    }

    /**
     * Process a digit input
     * @param digit The digit to append (0-9)
     */
    public void inputDigit(int digit) {
        if (state.isError()) {
            state.reset();
        }

        if (state.isNewInput()) {
            state.setDisplayText(String.valueOf(digit));
            state.setNewInput(false);
        } else {
            String current = state.getDisplayText();
            if (!current.equals("0") || digit != 0) {
                state.setDisplayText(current + digit);
            }
        }
    }

    /**
     * Process a decimal point input
     */
    public void inputDecimal() {
        if (state.isError()) {
            state.reset();
        }

        if (state.isNewInput()) {
            state.setDisplayText("0.");
            state.setNewInput(false);
        } else if (!state.getDisplayText().contains(".")) {
            state.setDisplayText(state.getDisplayText() + ".");
        }
    }

    /**
     * Process a binary operation (operations that require two operands)
     * @param operation The operation to perform
     * @throws CalculatorException If the operation fails
     */
    public void performBinaryOperation(Operation operation) throws CalculatorException {
        if (state.isError()) {
            return;
        }

        try {
            // Parse current display value
            double currentValue = FormatUtils.parseNumber(state.getDisplayText());

            // If there's a pending operation, calculate it first (chaining)
            if (state.getCurrentOperation() != null && !state.isNewInput()) {
                double storedValue = state.getStoredValue();
                double result = executeBinaryOperation(storedValue, currentValue, state.getCurrentOperation());

                // Validate result
                if (!MathUtils.isValidNumber(result)) {
                    state.setError(true);
                    state.setDisplayText("Error");
                    return;
                }

                // Check for overflow
                MathUtils.checkOverflow(result);

                // Update display and current value
                state.setDisplayText(FormatUtils.formatNumber(result));
                state.setCurrentValue(result);
                currentValue = result;
            }

            // Store the current value for the next operation
            state.setStoredValue(currentValue);
            state.setCurrentOperation(operation);
            state.setNewInput(true);

        } catch (CalculatorException e) {
            state.setError(true);
            state.setDisplayText("Error");
            state.setCurrentOperation(null);
        } catch (NumberFormatException e) {
            state.setError(true);
            state.setDisplayText("Error");
            state.setCurrentOperation(null);
        }
    }

    /**
     * Process a unary operation (operations that require one operand)
     * @param operation The operation to perform
     * @throws CalculatorException If the operation fails
     */
    public void performUnaryOperation(Operation operation) throws CalculatorException {
        if (state.isError()) {
            return;
        }

        try {
            // Parse current display value
            double currentValue = FormatUtils.parseNumber(state.getDisplayText());

            // Execute the unary operation
            double result = executeUnaryOperation(currentValue, operation);

            // Validate result
            if (!MathUtils.isValidNumber(result)) {
                state.setError(true);
                state.setDisplayText("Error");
                return;
            }

            // Check for overflow
            MathUtils.checkOverflow(result);

            // Format and display result
            state.setDisplayText(FormatUtils.formatNumber(result));
            state.setCurrentValue(result);
            state.setNewInput(true);

        } catch (CalculatorException e) {
            state.setError(true);
            state.setDisplayText("Error");
        } catch (NumberFormatException e) {
            state.setError(true);
            state.setDisplayText("Error");
        }
    }

    /**
     * Calculate the result of pending operations
     * @throws CalculatorException If calculation fails
     */
    public void calculateResult() throws CalculatorException {
        if (state.isError() || state.getCurrentOperation() == null) {
            return;
        }

        try {
            // Parse current display value (second operand)
            double currentValue = FormatUtils.parseNumber(state.getDisplayText());

            // Get stored value (first operand)
            double storedValue = state.getStoredValue();

            // Execute the pending operation
            double result = executeBinaryOperation(storedValue, currentValue, state.getCurrentOperation());

            // Validate result
            if (!MathUtils.isValidNumber(result)) {
                state.setError(true);
                state.setDisplayText("Error");
                state.setCurrentOperation(null);
                return;
            }

            // Check for overflow
            MathUtils.checkOverflow(result);

            // Format and display result
            state.setDisplayText(FormatUtils.formatNumber(result));
            state.setCurrentValue(result);
            state.setStoredValue(0);
            state.setCurrentOperation(null);
            state.setNewInput(true);

        } catch (CalculatorException e) {
            state.setError(true);
            state.setDisplayText("Error");
            state.setCurrentOperation(null);
        } catch (NumberFormatException e) {
            state.setError(true);
            state.setDisplayText("Error");
            state.setCurrentOperation(null);
        }
    }

    /**
     * Clear the current input (CE - Clear Entry)
     */
    public void clearEntry() {
        state.setDisplayText("0");
        state.setCurrentValue(0);
        state.setNewInput(true);
        state.setError(false);
    }

    /**
     * Clear all values and reset calculator (C - Clear)
     */
    public void clearAll() {
        state.reset();
    }

    /**
     * Delete the last character from current input
     */
    public void backspace() {
        if (state.isError() || state.isNewInput()) {
            return;
        }

        String current = state.getDisplayText();
        if (current.length() > 1) {
            state.setDisplayText(current.substring(0, current.length() - 1));
        } else {
            state.setDisplayText("0");
            state.setNewInput(true);
        }
    }

    /**
     * Get the current calculator state
     * @return The current state
     */
    public CalculatorState getState() {
        return state;
    }

    /**
     * Get the current display value
     * @return The display text
     */
    public String getDisplay() {
        return state.getDisplayText();
    }

    /**
     * Store current display value to memory
     */
    public void memoryStore() {
        try {
            double value = FormatUtils.parseNumber(state.getDisplayText());
            state.setMemory(value);
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }
    }

    /**
     * Recall memory value to display
     */
    public void memoryRecall() {
        state.setDisplayText(FormatUtils.formatNumber(state.getMemory()));
        state.setNewInput(true);
    }

    /**
     * Add current display value to memory
     */
    public void memoryAdd() {
        try {
            double value = FormatUtils.parseNumber(state.getDisplayText());
            state.memoryAdd(value);
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }
    }

    /**
     * Subtract current display value from memory
     */
    public void memorySubtract() {
        try {
            double value = FormatUtils.parseNumber(state.getDisplayText());
            state.memorySubtract(value);
        } catch (NumberFormatException e) {
            // Ignore invalid input
        }
    }

    /**
     * Clear memory
     */
    public void memoryClear() {
        state.memoryClear();
    }

    /**
     * Execute a binary operation (two operands)
     * @param left The first operand
     * @param right The second operand
     * @param operation The operation to perform
     * @return The result of the operation
     * @throws CalculatorException If the operation fails
     */
    private double executeBinaryOperation(double left, double right, Operation operation)
            throws CalculatorException {
        switch (operation) {
            case ADD:
                return left + right;
            case SUBTRACT:
                return left - right;
            case MULTIPLY:
                return left * right;
            case DIVIDE:
                return MathUtils.safeDivide(left, right);
            case MODULO:
                return MathUtils.safeModulo(left, right);
            case POWER:
                return MathUtils.power(left, right);
            default:
                throw new InvalidExpressionException("Unknown binary operation: " + operation);
        }
    }

    /**
     * Execute a unary operation (one operand)
     * @param value The operand
     * @param operation The operation to perform
     * @return The result of the operation
     * @throws CalculatorException If the operation fails
     */
    private double executeUnaryOperation(double value, Operation operation)
            throws CalculatorException {
        switch (operation) {
            case SIN:
                return MathUtils.sin(value);
            case COS:
                return MathUtils.cos(value);
            case TAN:
                return MathUtils.tan(value);
            case ASIN:
                return MathUtils.asin(value);
            case ACOS:
                return MathUtils.acos(value);
            case ATAN:
                return MathUtils.atan(value);
            case LOG:
                return MathUtils.log10(value);
            case LN:
                return MathUtils.ln(value);
            case EXP:
                return Math.exp(value);
            case TENPOWX:
                return MathUtils.power(10.0, value);
            case SQRT:
                return MathUtils.sqrt(value);
            case SQUARE:
                return value * value;
            case FACTORIAL:
                return MathUtils.factorial((int) value);
            case PERCENT:
                return value / 100.0;
            case RECIPROCAL:
                return MathUtils.reciprocal(value);
            case ABS:
                return Math.abs(value);
            case NEGATE:
                return MathUtils.negate(value);
            default:
                throw new InvalidExpressionException("Unknown unary operation: " + operation);
        }
    }
}
