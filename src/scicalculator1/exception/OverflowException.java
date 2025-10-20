package scicalculator1.exception;

/**
 * Exception thrown when a calculation result exceeds the maximum representable value
 * This handles numeric overflow situations gracefully
 *
 * @author Abdelrahman
 */
public class OverflowException extends CalculatorException {

    /**
     * Constructs a new OverflowException with a default message
     */
    public OverflowException() {
        super("Numeric overflow: result too large");
    }

    /**
     * Constructs a new OverflowException with the specified detail message
     * @param message The detail message
     */
    public OverflowException(String message) {
        super(message);
    }

    /**
     * Constructs a new OverflowException with the specified detail message and cause
     * @param message The detail message
     * @param cause The cause of the exception
     */
    public OverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new OverflowException with the specified cause
     * @param cause The cause of the exception
     */
    public OverflowException(Throwable cause) {
        super(cause);
    }
}
