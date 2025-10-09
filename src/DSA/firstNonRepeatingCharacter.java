package DSA;

import java.util.Arrays;

public class firstNonRepeatingCharacter {
    public static void main(String[] args)
    {

        findFirstNonRepeatingCharacter("abacbef");
        findFirstNonRepeatingCharacter("racecars");
        findFirstNonRepeatingCharacter("apple");
        findFirstNonRepeatingCharacter("ababdc");

    }
    public static void findFirstNonRepeatingCharacter(String s)
    {
        int n = s.length();
        int[] hash = new int[26];
        for (int i =0 ; i < n; i++)
        {
            hash[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++)
        {
            if (hash[s.charAt(i) - 'a'] == 1)
            {
                System.out.println(s.charAt(i));
                break;
            }
        }
    }
}
