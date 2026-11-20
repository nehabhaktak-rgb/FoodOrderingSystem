package exceptions;
/* Raised when an order is placed without any cart items. */
public class EmptyCartException extends Exception {
    public EmptyCartException(String message) { super(message); }
}
