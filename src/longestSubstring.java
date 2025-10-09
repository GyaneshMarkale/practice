import java.util.Arrays;

/**
 * Input: "abcabcdbb"
 *
 * Output: length = 3, substring = "abc"
 *
 * Input: "bbbbb"
 *
 * Output: length = 1, substring = "b"
 *
 */
public class longestSubstring {
    public static void main(String[] args)
    {
        String str = "abcabcdbb";
        System.out.println(longestSubStrWithoutRepeat(str));
    }

    private static String longestSubStrWithoutRepeat(String s)
    {
        int n = s.length();
        int left = 0;
        int right = 0;
        int[] hash = new int[26];
        Arrays.fill(hash, -1);
        int maxLen = 0;
        int startIndex = -1;
        while (right < n)
        {
            if (hash[s.charAt(right) - 'a'] != -1)
            {
                if (hash[s.charAt(right) - 'a'] >= left)
                {
                    left = hash[s.charAt(right) - 'a'] + 1;
                }
            }
            if (maxLen < right-left + 1)
            {
                maxLen = right - left + 1;
                startIndex = left;
            }
            //maxLen = Math.max(maxLen, right - left + 1);
            hash[s.charAt(right) - 'a'] = right;
            right++;
        }
        return s.substring(startIndex, startIndex + maxLen);
    }
}
