package datastructures;
import model.Order;
/* Array-based queue. Orders are handled in FIFO order. */
public OrderQueue(int size) {
    if (size <= 0) {
        throw new IllegalArgumentException("Queue size must be greater than zero.");
    }

    orders = new Order[size];
    front = 0;
    rear = -1;
    count = 0;
}
    public boolean isEmpty() { return count == 0; }
    public boolean addOrder(Order order) {
        if (count == orders.length) return false;
        rear = (rear + 1) % orders.length;
        orders[rear] = order; count++;
        return true;
    }
    public Order processNextOrder() {
        if (isEmpty()) return null;
        Order order = orders[front];
        orders[front] = null;
        front = (front + 1) % orders.length;
        count--;
        return order;
    }
}
