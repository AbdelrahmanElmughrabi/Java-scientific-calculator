package scicalculator1.exception;

/**
 * Exception thrown when an invalid mathematical expression is encountered
 * This includes malformed expressions, invalid operators, unbalanced parentheses, etc.
 *
 * @author Abdelrahman
 */
public class InvalidExpressionException extends CalculatorException {

    /**
     * Constructs a new InvalidExpressionException with no detail message
     */
    public InvalidExpressionException() {
        super();
    }

    /**
     * Constructs a new InvalidExpressionException with the specified detail message
     * @param message The detail message explaining why the expression is invalid
     */
    public InvalidExpressionException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidExpressionException with the specified detail message and cause
     * @param message The detail message
     * @param cause The cause of the exception
     */
    public InvalidExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new InvalidExpressionException with the specified cause
     * @param cause The cause of the exception
     */
    public InvalidExpressionException(Throwable cause) {
        super(cause);
    }
}
