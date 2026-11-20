package model;
import java.util.ArrayList;
/* Stores a copy of the items in a placed order. */
public class Order {
    private static int nextId = 1001;
    private int orderId;
    private ArrayList<CartItem> items;
    public Order(ArrayList<CartItem> cartItems) {
        orderId = nextId++;
        items = new ArrayList<>();
        // Copy items so later cart changes do not affect this order.
        for (CartItem item : cartItems)
            items.add(new CartItem(item.getItem(), item.getQuantity()));
    }
    public int getOrderId() { return orderId; }
    public double getTotal() {
        double total = 0;
        for (CartItem item : items) total += item.getAmount();
        return total;
    }
    public void printBill() {
        System.out.println("\n----------- BILL -----------");
        System.out.println("Order ID: " + orderId);
        for (CartItem item : items)
            System.out.printf("%-20s x %-3d Rs. %.2f%n", item.getItem().getName(),
                    item.getQuantity(), item.getAmount());
        System.out.println("----------------------------");
        System.out.printf("Total: Rs. %.2f%n", getTotal());
        System.out.println("Thank you for ordering!");
    }
}
