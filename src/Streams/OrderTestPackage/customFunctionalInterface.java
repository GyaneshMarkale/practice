package Streams.OrderTestPackage;

import java.util.Arrays;
import java.util.stream.Stream;

public class customFunctionalInterface {
    @FunctionalInterface
    interface ArrayMerger {
        int [] mergeAndSort(int[] arr1, int[] arr2);
    }

    public static void main(String[] args)
    {
        int[] Array1 = {13, 12, 11, 6, 9, 3 };
        int[] Array2  = {78, 34, 56, 67, 2, 11, 7 };

        ArrayMerger arrayMerger = ((arr1, arr2) -> Stream.of(arr1, arr2)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray());

        int[] arr = arrayMerger.mergeAndSort(Array1, Array2);
        System.out.println(Arrays.toString(arr));
    }
}
