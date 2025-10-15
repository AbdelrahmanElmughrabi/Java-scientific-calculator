package scicalculator.controller;

import scicalculator.model.CalculatorEngine;
import scicalculator.model.Operation;

/**
 * Event handling strategy for calculator button presses
 * Processes digit inputs, operator inputs, and special actions
 * Implements the Strategy pattern for different operation handling
 *
 * @author Abdelrahman
 */
public class ButtonEventHandler {

    private CalculatorEngine engine;
    private StringBuilder currentInput;

    /**
     * Constructs the button event handler
     * @param engine The calculator engine
     */
    public ButtonEventHandler(CalculatorEngine engine) {
        this.engine = engine;
        this.currentInput = new StringBuilder();
    }

    /**
     * Process a digit input
     * @param digit The digit pressed (0-9)
     */
    public void processDigit(String digit) {
        // TODO: Append digit to current input
        // Handle leading zeros and decimal points appropriately
    }

    /**
     * Process an operator input
     * @param operator The operator symbol
     */
    public void processOperator(String operator) {
        // TODO: Convert operator string to Operation enum
        // Send current input and operator to engine
        // Prepare for next input
    }

    /**
     * Process the equals action
     * @return The calculation result
     */
    public String processEquals() {
        // TODO: Finalize current input
        // Request calculation from engine
        // Return formatted result
        return "0";
    }

    /**
     * Process the clear action
     */
    public void processClear() {
        // TODO: Clear current input
        // Reset engine state
    }

    /**
     * Process the delete action
     */
    public void processDelete() {
        // TODO: Remove last character from current input
        // Handle empty input case
    }

    /**
     * Process a decimal point input
     */
    public void processDecimal() {
        // TODO: Add decimal point if not already present
        // Handle edge cases (empty input, etc.)
    }

    /**
     * Process a scientific function input
     * @param function The function name (sin, cos, tan, etc.)
     */
    public void processScientificFunction(String function) {
        // TODO: Convert function string to Operation enum
        // Apply function to current input or last result
    }

    /**
     * Process a parenthesis input
     * @param parenthesis The parenthesis character
     */
    public void processParenthesis(String parenthesis) {
        // TODO: Add parenthesis to expression
        // Validate parenthesis matching
    }

    /**
     * Get the current input display text
     * @return The current input as a string
     */
    public String getCurrentInput() {
        return currentInput.toString();
    }
}