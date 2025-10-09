package JAVA8;

public class StringMatch {
    public static void main(String[] args)
    {
        String str = "leetcode";
        String pattern = "leeto";
        System.out.println(strStr(str, pattern));
    }
    public static int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m > n) return -1;
        if (haystack.equals(needle)) return 0;
        String s = needle + "$" + haystack;
        int []z = new int[s.length()];
        for (int i = 1; i < s.length(); i++)
        {
            int l = i;
            int r = i;
            if (s.charAt(i) == s.charAt(0))
            {
                int j = 0;
                while (r < s.length() && s.charAt(r) == s.charAt(j))
                {
                    r++;
                    j++;
                }
                z[i] = r - l;
            }
        }
        for (int i = 0; i < z.length; i++)
        {
            System.out.print(z[i]+" ");
        }

        for (int i = 0; i < z.length; i++)
        {
            if (z[i] == needle.length()) return  i - (m+1);
        }
        return -1;
    }
}
