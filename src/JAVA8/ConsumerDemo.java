package JAVA8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerDemo {
    public static void main(String[] args)
    {
        Supplier<String> stringSupplier = () -> "hello world!!";
       Consumer<String> consumer = x -> System.out.println(x);
       consumer.accept(stringSupplier.get());

       Map<Character, Integer> map = new HashMap<>();
       map.put('s', map.getOrDefault('s', 0) + 1);
       System.out.println(map);
    }
}
