package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Problem17 {
    public static void main(String[] agrs)
    {
        List<Product> list = new ArrayList<>();
        Product product1 = new Product("mac", 100000);
        Product product2 = new Product("iphone", 69000);
        Product product3 = new Product("ipad", 320000);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        Optional<Product> price = list.stream().reduce((p1, p2) -> p1.price > p2.price ? p1:p2);
        System.out.println(price.get().name);

    }
}
class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
