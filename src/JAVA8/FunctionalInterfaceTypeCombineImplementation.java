package JAVA8;

import java.security.PublicKey;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTypeCombineImplementation {
    public static void main(String[] args)
    {
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x / 2;
        Supplier<Integer> supplier = () -> 10;
        Consumer<Integer> consumer = x -> System.out.println(x);

        if (predicate.test(supplier.get()))
        {
            consumer.accept(function.apply(supplier.get()));
        }
    }
}
