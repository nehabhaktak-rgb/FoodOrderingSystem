
package exceptions;

public class ExceptionTest {

    public static void main(String[] args) throws Exception {

        // Test InvalidQuantityException
        InvalidQuantityException quantityException =
                new InvalidQuantityException("Invalid quantity");

        check(
            quantityException.getMessage().equals("Invalid quantity"),
            "InvalidQuantityException message test failed"
        );

        // Test EmptyCartException
        EmptyCartException cartException =
                new EmptyCartException("Cart is empty");

        check(
            cartException.getMessage().equals("Cart is empty"),
            "EmptyCartException message test failed"
        );

        System.out.println("All exception tests passed!");
    }

    // Checks whether a test condition is true
    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
