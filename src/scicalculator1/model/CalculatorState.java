package scicalculator1.model;

/**
 * Manages the state of the calculator Stores current values, operations, and
 * display state
 *
 * @author Abdelrahman
 */
public class CalculatorState {

    private double currentValue;
    private double storedValue;
    private Operation currentOperation;
    private String displayText;
    private boolean isNewInput;
    private boolean isError;
    private double memory;

    /**
     * Constructor initializes calculator to default state
     */
    public CalculatorState() {
        reset();
    }

    /**
     * Reset calculator to initial state
     */
    public void reset() {
        currentValue = 0.0;
        storedValue = 0.0;
        currentOperation = null;
        displayText = "0";
        isNewInput = true;
        isError = false;
        memory = 0.0;
    }

    // Getters
    public double getCurrentValue() {
        return currentValue;
    }

    public double getStoredValue() {
        return storedValue;
    }

    public Operation getCurrentOperation() {
        return currentOperation;
    }

    public String getDisplayText() {
        return displayText;
    }

    public boolean isNewInput() {
        return isNewInput;
    }

    public boolean isError() {
        return isError;
    }

    // Setters
    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public void setStoredValue(double storedValue) {
        this.storedValue = storedValue;
    }

    public void setCurrentOperation(Operation currentOperation) {
        this.currentOperation = currentOperation;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public void setNewInput(boolean newInput) {
        isNewInput = newInput;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void memoryAdd(double value) {
        this.memory += value;
    }

    public void memorySubtract(double value) {
        this.memory -= value;
    }

    public void memoryClear() {
        this.memory = 0.0;
    }
}
