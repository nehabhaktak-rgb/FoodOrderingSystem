package service;
import java.util.ArrayList;
import model.CartItem;
import model.Order;
import exceptions.EmptyCartException;
import datastructures.OrderQueue;
/* Places orders and stores completed orders for later viewing. */
public class OrderService {
    private OrderQueue queue = new OrderQueue(50);
    private ArrayList<Order> history = new ArrayList<>();
    public Order placeOrder(ArrayList<CartItem> cartItems) throws EmptyCartException {
        if (cartItems == null || cartItems.isEmpty())
            throw new EmptyCartException("Your cart is empty.");
        Order order = new Order(cartItems);
        if (!queue.addOrder(order)) {
            System.out.println("Order queue is full.");
            return null;
        }
        // Process the next order in FIFO order.
        Order completedOrder = queue.processNextOrder();
        if (completedOrder != null) history.add(completedOrder);
        return completedOrder;
    }
    public void showOrderHistory() {
        if (history.isEmpty()) { System.out.println("No previous orders."); return; }
        System.out.println("\n--------- ORDER HISTORY ---------");
        for (Order order : history)
            System.out.printf("Order ID: %d  Total: Rs. %.2f%n",
                    order.getOrderId(), order.getTotal());
    }
}
