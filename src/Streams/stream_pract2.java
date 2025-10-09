package Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class stream_pract2 {
    public static void main(String args[]) {
        // odd even
//        List<Integer> listOfNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        List<Integer> evenNum = listOfNum.stream().filter(x -> x % 2 == 0).toList();
//        List<Integer> oddNum = listOfNum.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
//        System.out.println("even Odd");
//        evenNum.forEach(x -> System.out.print(" " +x));
//        oddNum.forEach(z -> System.out.print(" " +z));
//        System.out.println("");
//
//        // remove duplicates
//        List<Integer> dupEleList = Arrays.asList(1, 2, 1, 4, 5, 2, 7, 8, 10, 10);
//        List<Integer> uniqueElements = dupEleList.stream().distinct().collect(Collectors.toList());
//        List<Integer> dupEle = dupEleList.stream().filter(x-> Collections.frequency(dupEleList,x) > 1).distinct().toList();
//        System.out.println("unique number from list");
//        uniqueElements.forEach(x -> System.out.print(" "+x));
//        System.out.println("duplicate elemnents from list");
//        dupEle.forEach(x -> System.out.println(" "+x));
//        System.out.println("");
//        System.out.println("*****************************************************");
//        System.out.println("frequency of each character");
//
//         map<key, value> by groupingBy
       String s1 = "javastreams";
       Map<Character, Long> charFreq = s1.chars().
               mapToObj(c -> (char) c)
               .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
               .entrySet().stream()
               .sorted(Map.Entry.comparingByValue())
               .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                       (a, b) -> a, LinkedHashMap::new));

       System.out.println("Map values in ascending order: "+charFreq);

        String s2 = "javastreams";
        Map<Character, Long> charFreq1 = s1.chars().
                mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, TreeMap::new, Collectors.counting()));

        System.out.println("output in sorted order: "+charFreq1);
//
//        System.out.println("*****************************************************");
//        System.out.println("frequency of each eelemnt in list");
//
//        List<Integer> l1 = Arrays.asList(1, 2, 1, 4, 5, 2, 7, 8, 10, 10);
//        Map<Integer, Long> m1 = l1.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));
//
//        System.out.println(m1);
//
//        System.out.println("*****************************************************");
//        System.out.println("print the integers multiple of 5");
//
//        List<Integer> l2 = Stream.iterate(0, x-> x+1).limit(40)
//                .filter(x-> x/5 == 0).collect(Collectors.toList());
//
//        System.out.println(l2);

        // Min, Max
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        List<String> names = Arrays.asList(
//                "Putin",
//                "Biden",
//                "Modi",
//                "Ali",
//                "Jack"
//        );
//        int mini = numbers.stream().min(Comparator.comparing(Integer::valueOf)).get();
//        int maxi = numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
//        String mini = names.stream().min(Comparator.comparing(String::valueOf)).get();
//        String maxi = names.stream().max(Comparator.comparing(String::valueOf)).get();
//        System.out.println("minimum value: "+mini);
//        System.out.println("Maximum value: "+maxi);

//        List<List<String>> evenOddList = Arrays.asList(
//          Arrays.asList("2", "3,", "4", "6"),
//          Arrays.asList("1,", "7,", "10", "2"),
//          Arrays.asList("8", "9", "21", "6", "4")
//        );
//        List<Integer> evenDistinctNumbers = evenOddList.stream().flatMap(List::stream)
//                .map(s -> s.replace(",", ""))
//                .map(Integer::parseInt)
//                .distinct().sorted()
//                        .filter(x -> x % 2 == 0).toList();
//        int sum = evenDistinctNumbers.stream().reduce(0, (l1, l2)->l1+l2);
//        System.out.println(evenDistinctNumbers);
//        System.out.println("Sum: "+sum);
//
//
//        List<String> s = evenOddList.stream().flatMap(List::stream).toList();
//        System.out.println(s);

//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        int secondHighest = numbers.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
//        System.out.println(secondHighest);


//        List<String> strings = Arrays.asList("java", "stream", "api");
//        List<String> upperStringList = strings.stream().map(String::toUpperCase).toList();
//        List<String> sortedList = strings.stream().sorted(Comparator.comparing(s -> s.length())).toList();
//        List<String> sortedList1 = strings.stream().sorted(Comparator.comparing(String::length)).toList();
//
//        System.out.println(sortedList);
//        System.out.println(sortedList1);
//        System.out.println(upperStringList);
//
//        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 1);
//        boolean isAllEven = numbers.stream().allMatch(e -> e % 2 ==0);
//        System.out.println(isAllEven);
//
//        List<Integer> dupEleList = Arrays.asList(1, 2, 1, 4, 5, 2, 7, 8, 10, 10);
//        List<Integer> dupEle = dupEleList.stream().filter(x -> Collections.frequency(dupEleList,x ) > 1).distinct().toList();
//        System.out.println(dupEle);

        //reverse a string
        String orgString = "reverse";
        String outString =
                IntStream.range(0, orgString.length()).mapToObj(i -> orgString.charAt(orgString.length() - i - 1))
                                .map(String::valueOf).collect(Collectors.joining());
        System.out.println(outString);

        String revString = "reverse this string";
        String[] charString = revString.split(" ");
        String outrevString = Arrays.stream(revString.split(" ")).reduce((a, b) -> b + " " +a).orElse(" ");
        System.out.println(outrevString);
        String res = IntStream.range(0, charString.length).mapToObj(i -> charString[charString.length - i - 1])
                .collect(StringBuilder::new, (sb, word) -> {
                    if (sb.length() > 0) sb.append(" ");
                    sb.append(word);
                }, StringBuilder::append).toString();
        System.out.println(res);


        // get sum of last 3 integers
        List<Integer> listOfNum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> sum = listOfNum.stream().skip(listOfNum.size() - 3).reduce(Integer::sum);
        System.out.println("sum: "+sum.get());

//         Finding longest string in each group
//         given list of strings group them by their first character and then find the
//         longest string in each group
         List<String> list = List.of("anubhav", "abhishek", "sehaj", "gyanesh", "sam");
         Map<Character, List<String>> m = new HashMap<>();
         list.stream().map(s -> {
             if (!m.containsKey(s.charAt(0)))
             {
                 List<String> l = new ArrayList<>();
                 l.add(s);
                 m.put(s.charAt(0), l);
             }
             else {
                 List<String> exstingList = m.get(s.charAt(0));
                 exstingList.add(s);
                 m.put(s.charAt(0), exstingList);
             }
             return m;
         });
         Map<Character, String> outMap = list.stream().collect(Collectors.groupingBy(s -> s.charAt(0),
                 Collectors.reducing("",(str1, str2) -> str1.length() > str2.length() ? str1:str2)));
         System.out.println(outMap);



        String ss1 = "John";
        String ss2 = new String ("John");
        HashMap<String, Integer> map = new HashMap<>();
        map.put(ss1,20);
        map.put(ss2,30);
        System.out.println("mapSize: "+map.size());





    }
}
