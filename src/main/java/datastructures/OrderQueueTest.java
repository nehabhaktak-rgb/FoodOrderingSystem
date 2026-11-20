
package datastructures;

import java.util.ArrayList;
import model.Order;

public class OrderQueueTest {

    public static void main(String[] args) {

        OrderQueue queue = new OrderQueue(2);

        Order order1 = new Order(new ArrayList<>());
        Order order2 = new Order(new ArrayList<>());
        Order order3 = new Order(new ArrayList<>());

        // Test initial queue
        check(queue.isEmpty(), "Queue should be empty");
        check(queue.getSize() == 0, "Initial size should be zero");
        check(queue.getCapacity() == 2, "Capacity should be two");

        // Test adding orders
        check(queue.addOrder(order1), "First order should be added");
        check(queue.addOrder(order2), "Second order should be added");
        check(!queue.addOrder(order3), "Full queue should reject an order");
        check(!queue.addOrder(null), "Null order should be rejected");

        // Test peek operation
        check(queue.peekNextOrder() == order1, "Peek should return first order");
        check(queue.getSize() == 2, "Peek should not remove an order");

        // Test FIFO processing
        check(queue.processNextOrder() == order1, "First order should be processed first");

        // Test circular queue reuse
        check(queue.addOrder(order3), "Queue should accept order after processing");
        check(queue.processNextOrder() == order2, "Second order should be processed next");
        check(queue.processNextOrder() == order3, "Third order should be processed last");

        // Test empty queue
        check(queue.isEmpty(), "Queue should be empty");
        check(queue.processNextOrder() == null, "Empty queue should return null");

        // Test clear operation
        queue.addOrder(order1);
        queue.addOrder(order2);
        queue.clearQueue();

        check(queue.isEmpty(), "Clear should empty the queue");
        check(queue.getSize() == 0, "Size should be zero after clearing");

        System.out.println("All OrderQueue tests passed!");
    }

    // Checks whether a test condition is true
    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError("Test failed: " + message);
        }
    }
}
