package DSA;

import java.util.Arrays;
import java.util.List;

public class DSA1 {
    public static void main(String args[]) {
        String s = "abcacde";
        List<Integer> res = longestSubsttringWithoutRepeating(s);
        System.out.println(res.get(0));
       String outString = new String();
        outString = s.substring(res.get(1), res.get(2));
        System.out.println(outString);
    }

    private static List<Integer> longestSubsttringWithoutRepeating(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        while (r < n)
        {
            if (hash[s.charAt(r)] != -1)
            {
                if (hash[s.charAt(r)] >= l) {
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxLen = Math.max(maxLen, (r - l + 1));
            hash[s.charAt(r)] = r;
            r++;
        }
        List<Integer> list = Arrays.asList(maxLen, l, r);
        return list;
    }
}
