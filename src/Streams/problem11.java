package Streams;

import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class problem11 {
    public static void main(String[] agrs)
    {
//        List<List<String>> evenOddList = Arrays.asList(
//          Arrays.asList("2", "3,", "4", "6"),
//          Arrays.asList("1,", "7,", "10", "2"),
//          Arrays.asList("8", "9", "21", "6", "4")
//        );
//
//        List<Integer> strList = evenOddList.stream().flatMap(List::stream)
//                .map(s -> s.replace(",", " "))
//                .map(Integer::parseInt)
//                .distinct().sorted()
//                        .filter(x -> x % 2 == 0).toList();
//        System.out.println(strList);
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6)
        );
        List<Integer> l = list.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(l);


    }
}
