package scicalculator1.exception;

/**
 * Base exception class for calculator-related errors
 * All custom calculator exceptions extend this class
 *
 * @author Abdelrahman
 */
public class CalculatorException extends Exception {

    /**
     * Constructs a new CalculatorException with no detail message
     */
    public CalculatorException() {
        super();
    }

    /**
     * Constructs a new CalculatorException with the specified detail message
     * @param message The detail message
     */
    public CalculatorException(String message) {
        super(message);
    }

    /**
     * Constructs a new CalculatorException with the specified detail message and cause
     * @param message The detail message
     * @param cause The cause of the exception
     */
    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new CalculatorException with the specified cause
     * @param cause The cause of the exception
     */
    public CalculatorException(Throwable cause) {
        super(cause);
    }
}
