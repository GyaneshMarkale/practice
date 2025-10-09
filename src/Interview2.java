public class Interview2 {
    /**
     * String s = "abcdef";
     * output : "badcfe"
     *
     * abcde
     * badce
     */

    public static void main(String[] args)
    {
        String s = "abcdef";
        System.out.println(reverseAltStrings(s));
    }
    public static String reverseAltStrings(String s)
    {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        if (n == 1) return s;
        String result = "";
        if (n % 2 == 0)
        {
            result =  reverseAltStringsUtil(charArray, n);
        }
        else {
            result =  reverseAltStringsUtil(charArray, n-1);

        }
        return result;
    }

    private static String reverseAltStringsUtil(char[] charArray, int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < size; i = i+2)
        {
            sb.append(charArray[i]);
            sb.append(charArray[i-1]);
        }

        if (charArray.length > size)
        {
            sb.append(charArray[charArray.length - 1]);
        }
        return sb.toString();
    }
}
