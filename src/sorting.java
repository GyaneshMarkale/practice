import java.util.*;

public class sorting {
    public static void main(String args[])
    {
        String s1 = "abc";
        String s2 = "bac";
        String res = sortString(s1, s2);
        System.out.println(res);
    }

    private static String sortString(String inputString, String pattern) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++)
        {
            map.put(pattern.charAt(i), i);
        }
        Character[] charArray = inputString.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        Arrays.sort(charArray, (a, b) -> map.get(a) - map.get(b));

        StringBuilder s = new StringBuilder();
        for (Character ch : charArray) {
            s.append(ch);
        }
        return String.valueOf(s);
    }

}
