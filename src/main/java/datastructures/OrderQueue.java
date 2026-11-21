
package datastructures;

import model.Order;

/*
 * Array-based circular queue.
 * Orders are processed in FIFO (First In, First Out) order.
 */
public class OrderQueue {

    private Order[] orders;
    private int front, rear, count;

    // Constructor initializes the circular queue
    public OrderQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue size must be greater than zero.");
        }

        orders = new Order[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Checks whether the queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Checks whether the queue is full
    public boolean isFull() {
        return count == orders.length;
    }

    // Returns the number of orders currently in the queue
    public int getSize() {
        return count;
    }

    // Returns the maximum capacity of the queue
    public int getCapacity() {
        return orders.length;
    }

    // Returns the next order without removing it
    public Order peekNextOrder() {
        if (isEmpty()) return null;

        return orders[front];
    }

    // Adds an order at the rear of the queue
    public boolean addOrder(Order order) {
        if (order == null) {
            return false;
        }

        if (isFull()) return false;

        // Modulo allows rear to return to index 0 when the array ends
        rear = (rear + 1) % orders.length;
        orders[rear] = order;
        count++;

        return true;
    }

    // Removes and returns the order at the front
    public Order processNextOrder() {
        if (isEmpty()) return null;

        Order order = orders[front];
        orders[front] = null;

        // Modulo allows front to move circularly through the array
        front = (front + 1) % orders.length;
        count--;

        return order;
    }

    // Removes all orders from the queue
    public void clearQueue() {
        while (!isEmpty()) {
            processNextOrder();
        }
    }
}
