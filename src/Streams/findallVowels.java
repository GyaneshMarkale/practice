package Streams;

import java.util.Arrays;
import java.util.List;

public class findallVowels {
    public static void main(String[] agrs)
    {
        String sentence = "The quick brown fox jumps over the lazy dog";
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

       sentence.chars().mapToObj(c -> (char)c).filter(vowels::contains).forEach(System.out::print);

//        sentence.chars().mapToObj(c -> (char)c)
//                .filter(vowels::contains)
//                .forEach(System.out::print);
//        System.out.println("");
//        sentence.chars().mapToObj(c -> (char) c).filter(c -> "aeiouAEIOU".indexOf(c) != -1).forEach(System.out::print);
    }
}
