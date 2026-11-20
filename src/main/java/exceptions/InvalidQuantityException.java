
package exceptions;

/*
 * Custom exception thrown when an invalid quantity
 * is entered while ordering food items.
 */
public class InvalidQuantityException extends Exception {

    private static final long serialVersionUID = 1L;

    // Constructor to display the exception message
    public InvalidQuantityException(String message) {
        super(message);
    }
}
