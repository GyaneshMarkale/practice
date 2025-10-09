package Streams;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class reverseString {
    public static void main(String[] args)
    {
        String s = "gyanesh";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(sb.toString());
       String revString = IntStream.range(0, s.length()).mapToObj(i -> s.charAt(s.length() - i -1))
               .map(String::valueOf).collect(Collectors.joining());
       System.out.println(revString);
    }
}
