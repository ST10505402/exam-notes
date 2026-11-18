package templates.exceptions;

/**
 * TEMPLATE: custom (checked) exception - extends Exception.
 * Extend RuntimeException instead if you want it unchecked.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
