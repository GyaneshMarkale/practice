package Streams;

import java.util.Arrays;

public class problem3 {
    // the average of squares of an int array

    public static void main(String[] args)
    {
        int[] arr = {2, 4, 8,6,10};
        double avg =Arrays.stream(arr).map(x -> x * x).average().getAsDouble();
        System.out.println(avg);

    }
}
