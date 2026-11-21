
package exceptions;

public class ExceptionHandlingTest {

    public static void main(String[] args) {

        // Test InvalidQuantityException
        try {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero"
            );
        } catch (InvalidQuantityException e) {
            check(
                e.getMessage().equals("Quantity must be greater than zero"),
                "Invalid quantity exception test failed"
            );
        }

        // Test EmptyCartException
        try {
            throw new EmptyCartException(
                "Cannot place an order with an empty cart"
            );
        } catch (EmptyCartException e) {
            check(
                e.getMessage().equals("Cannot place an order with an empty cart"),
                "Empty cart exception test failed"
            );
        }

        System.out.println("All exception handling tests passed!");
    }

    // Checks whether a test condition is true
    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
