package DSA;

public class LongestUniformSubstring {
    public static void main(String[] args)
    {
//        String s = "aabbbbbbbcccccda";
        String s = "aabaaaa";
        int[] result = startAndEndIndexes(s);
        System.out.println("["+result[0] + " "+result[1] +"]");
    }

    public static int[] startAndEndIndexes(String s)
    {
        int n = s.length();
        int l = 0;
        int r = 0;
        int startIndex = -1;
        int maxLen = 0;
        while (r < n)
        {
            if (s.charAt(l) == s.charAt(r))
            {
                int len = r - l + 1;
                if (maxLen < len)
                {
                    maxLen = len;
                    startIndex = l;
                }
            }
            else {
                l = r;
            }
            r++;
        }
        int[] indexes = new int[]{startIndex, maxLen};
        return indexes;
    }
}
