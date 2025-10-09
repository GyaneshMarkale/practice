package JAVA8;

import java.util.Optional;

public class OptionalDemo {
    public static void main (String[] args)
    {
        Optional<String> name1 = getName();
        name1.ifPresent(n -> System.out.println(n));
    }

   private static Optional<String> getName()
    {
        return Optional.ofNullable(null);
    }
}
