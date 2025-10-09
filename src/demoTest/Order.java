package demoTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Order {
    private int orderId;
    private int amount;
    private int customerId;
    private String date;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order(int orderId, int amount, int customer, String date) {
        this.orderId = orderId;
        this.amount = amount;
        this.customerId = customer;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", customer=" + customerId +
                ", date=" + date +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public static void main(String[] args)
    {
        Order order1 = new Order(1, 300, 101, "10/11/2024");
        Order order2 = new Order(2, 660, 104, "10/11/2024");
        Order order3 = new Order(3, 700, 103, "10/11/2024");
        Order order4 = new Order(4, 800, 102, "10/11/2024");
        List<Order> orderList = new ArrayList<>(Arrays.asList(order1, order2, order3, order4));

        List<Integer> listOfCustomerId = orderList.stream().
                filter(ele -> ele.amount > 500).
                sorted().
                map(Order::getCustomerId).
                distinct().toList();

        System.out.println(listOfCustomerId);



    }
}
