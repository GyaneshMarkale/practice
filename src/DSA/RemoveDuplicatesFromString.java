package DSA;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromString {
    public static void main (String[] args) {
        String s = "AAaab@bdb@cd2cdd33";
        System.out.println(removeDups(s));  // Aab@dc23

        //using stream
        s.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().map(Map.Entry::getKey).forEach(System.out::print);
    }

    public static String removeDups(String s)
    {
        int n = s.length();
        int[] hash = new int[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (hash[s.charAt(i)] != 0)
            {
                continue;
            }
            hash[s.charAt(i)]++;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
