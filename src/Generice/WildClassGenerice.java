package Generice;

import java.util.Arrays;
import java.util.List;

public class WildClassGenerice {
    public static void main(String[] args)
    {
       List<? extends Number> list = Arrays.asList(1,2,3);
//       list.add(2); // cannot modify the upperbound
        System.out.println(addNumbers(list));
        List<? super Integer> list1 = Arrays.asList(1,2,3);
        list1.add(12);  // can be modified in lower bound, because it has been generalised

    }
    // Upper bound
    public static double addNumbers(List<? extends Number> numbers) {
        double sum = 0;
        for (Number n : numbers) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // lower bound
    public static void print(List<? super Integer> numbers) {
        double sum = 0;
        for (Object n : numbers) {
            System.out.println(n);
        }
    }
}
