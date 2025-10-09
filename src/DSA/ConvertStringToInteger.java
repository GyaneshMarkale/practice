package DSA;

public class ConvertStringToInteger {
    public static void main(String[] args)
    {
        String s = "123";
        String s2 = "-123";
        //int ans = convert(s);
        System.out.println(s);
        System.out.println(s2);


    }

    private static int convert(String s)
    {
        int sign = 1;
        int num = 0;
        for (Character c : s.toCharArray())
        {
            // check space and if not digit
            if (c == '-') sign = -1;
            num = num * 10 + (c - '0');
        }
        return sign * num;
    }
}
