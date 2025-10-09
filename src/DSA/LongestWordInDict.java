package DSA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDict {
    public static void main(String[] args)
    {
        String[] dict = {"to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana"};
        System.out.println(longestWord("toe", dict));
        System.out.println(longestWord("oetdg", dict));
    }
    public static Set<String> longestWord(String s, String[] dictionary)
    {
        Set<String> set = new HashSet<>();
        int n = s.length();
        int[] hashOrg = new int[26];
        int longestStr = 0;
        for (int i = 0; i< n; i++)
        {
            hashOrg[s.charAt(i) - 'a']++;
        }
        for (int i = dictionary.length-1; i >= 0; i--)
        {
            int[] hashDup = hashOrg.clone();
            String str = dictionary[i];
            if (str.length() > s.length()) continue;
            if (longestStr <= str.length() && isCharacterExist(str, hashDup))
            {
                longestStr = str.length();
                set.add(str);
            }
        }
        return set;
    }

    public static boolean isCharacterExist(String s,  int[] hash)
    {
        for (int ch =0 ; ch < s.length(); ch++)
        {
            if (hash[s.charAt(ch) -'a'] == 0) return false;
            else
            {
                hash[s.charAt(ch) - 'a']--;
            }
        }
        return true;
    }
}
