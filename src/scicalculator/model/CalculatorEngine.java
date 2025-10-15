package scicalculator.model;

import scicalculator.exception.*;

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

        // TODO: Implement binary operation logic
        // This will be implemented in phase 2
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

        // TODO: Implement unary operation logic
        // This will be implemented in phase 2
    }

    /**
     * Calculate the result of pending operations
     * @throws CalculatorException If calculation fails
     */
    public void calculateResult() throws CalculatorException {
        if (state.isError() || state.getCurrentOperation() == null) {
            return;
        }

        // TODO: Implement result calculation
        // This will be implemented in phase 2
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
}
