package Streams.OrderTestPackage;

import java.util.Arrays;

public class problem8 {
    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int sum = Arrays.stream(arr).reduce(Integer::sum).getAsInt();
        System.out.println(sum);
    }
}
