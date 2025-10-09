package DSA;

/**
 * StringToInteger - ATOI
 */
public class StringToInteger {
    public static void main(String[] args)
    {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("  -42"));

    }
    public static int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1;

        while (i < n && (s.charAt(i) == ' ')) i++;
        if (i < n && s.charAt(i) == '-')
        {
            sign = -1 ;
            i++;
        }
        int num  =  0;
        while (i < n && Character.isDigit(s.charAt(i)))
        {
            num = (num * 10) + (s.charAt(i) - '0');
            if (num > (Integer.MAX_VALUE - num) / 10)
            {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return sign * num;
    }
}
