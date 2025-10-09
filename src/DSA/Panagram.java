package DSA;

import java.awt.*;
import java.util.Arrays;

public class Panagram {
    public static void main(String[] agrs)
    {
        String s1 = "The slow purple oryx meanders past the quiescent canine";
        String s2 = "The quick brown fox jumps over the lazy dog";
        System.out.println(findMissingLetters(s1));
        System.out.println(findMissingLetters(s2));
    }

    public static String findMissingLetters(String sentence)
    {
        int n = sentence.length();
        String s = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = s.toCharArray();
        for (int i =0; i < n; i++)
        {
            if (Character.isLetter(sentence.charAt(i)))
            {
                char ch = Character.toLowerCase(sentence.charAt(i));
                chars[ch - 97] = '1';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++)
        {
            if (chars[i] != '1')
            {
                sb.append(chars[i]);
            }
        }
        if (sb.isEmpty()) return "No missing character in sentence";
        return sb.toString();
    }


}
