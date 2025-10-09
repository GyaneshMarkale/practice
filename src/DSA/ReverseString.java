package DSA;

public class ReverseString {
    public static void main(String[] args)
    {
        System.out.println(reverseString("/gH?yZx"));
        System.out.println(reverseString("abcdef"));
        System.out.println(reverseString("1234?!@#"));
    }

    public static String reverseString(String s)
    {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
        {
            if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        sb.reverse();
        String s2 = sb.toString();
        sb= new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < n)
        {
            if (!Character.isLetter(s.charAt(i)))
            {
                sb.append(s.charAt(i));
                i++;
            }
            else
            {
                sb.append(s2.charAt(j));
                i++;
                j++;
            }
        }
        return sb.toString();
    }

}
