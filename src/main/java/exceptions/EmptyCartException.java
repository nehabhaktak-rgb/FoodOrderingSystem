
package exceptions;

/*
 * Custom exception thrown when an order is placed
 * without adding any items to the cart.
 */
public class EmptyCartException extends Exception {

    private static final long serialVersionUID = 1L;

    // Constructor to display the exception message
    public EmptyCartException(String message) {
        super(message);
    }
}
