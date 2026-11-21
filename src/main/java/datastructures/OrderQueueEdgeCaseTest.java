
package datastructures;

import java.util.ArrayList;
import model.Order;

public class OrderQueueEdgeCaseTest {

    public static void main(String[] args) {

        // Test invalid queue capacity
        boolean invalidSize = false;

        try {
            new OrderQueue(0);
        } catch (IllegalArgumentException e) {
            invalidSize = true;
        }

        check(invalidSize, "Zero capacity should be rejected");

        // Create a queue
        OrderQueue queue = new OrderQueue(2);

        Order order1 = new Order(new ArrayList<>());
        Order order2 = new Order(new ArrayList<>());

        // Test empty queue operations
        check(queue.peekNextOrder() == null,
                "Peek on empty queue should return null");

        check(queue.processNextOrder() == null,
                "Processing empty queue should return null");

        // Test null order
        check(!queue.addOrder(null),
                "Null order should be rejected");

        // Test full queue
        queue.addOrder(order1);
        queue.addOrder(order2);

        check(!queue.addOrder(new Order(new ArrayList<>())),
                "Full queue should reject another order");

        // Test clearing and reusing queue
        queue.clearQueue();

        check(queue.isEmpty(),
                "Queue should be empty after clearing");

        check(queue.addOrder(order1),
                "Queue should accept orders after clearing");

        check(queue.getSize() == 1,
                "Queue size should be one after adding an order");

        System.out.println("All queue edge case tests passed!");
    }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("Test failed: " + message);
        }
    }
}
