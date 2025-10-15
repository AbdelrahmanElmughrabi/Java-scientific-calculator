package scicalculator.exception;

/**
 * Exception thrown when attempting to divide by zero
 * This is a common mathematical error that must be handled gracefully
 *
 * @author Abdelrahman
 */
public class DivisionByZeroException extends CalculatorException {

    /**
     * Constructs a new DivisionByZeroException with a default message
     */
    public DivisionByZeroException() {
        super("Cannot divide by zero");
    }

    /**
     * Constructs a new DivisionByZeroException with the specified detail message
     * @param message The detail message
     */
    public DivisionByZeroException(String message) {
        super(message);
    }

    /**
     * Constructs a new DivisionByZeroException with the specified detail message and cause
     * @param message The detail message
     * @param cause The cause of the exception
     */
    public DivisionByZeroException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new DivisionByZeroException with the specified cause
     * @param cause The cause of the exception
     */
    public DivisionByZeroException(Throwable cause) {
        super(cause);
    }
}
