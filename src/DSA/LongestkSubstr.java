package DSA;

import java.util.HashMap;
import java.util.Map;

public class LongestkSubstr {
    public static void main(String[] args)
    {
        String s = "aabacbebebe";
        int res = twoPointerUtil(s, 3);
        System.out.println("Answer: "+ res);
    }

    public static int twoPointerUtil(String s, int k)
    {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length())
        {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            if (map.size() > k)
            {
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if (map.get(s.charAt(l)) == 0)
                {
                    map.remove(s.charAt(l));
                }
                l++;
            }
            if (map.size() <= k) {
                maxLen = Math.max(maxLen, (r - l + 1));
            }
            r++;
        }
        return maxLen;
    }


}
