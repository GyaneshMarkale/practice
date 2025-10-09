package DSA;

public class PalindromeInteger {
    public static void main(String[] args)
    {
        int num1 = 11;
        System.out.println(num1 == isPalindrome(num1));
        int num2 = 1;
        System.out.println(num2 == isPalindrome(num2));
        int num3 = 13;
        System.out.println(num3 == isPalindrome(num3));
        int num4 = 131;
        System.out.println(num4 == isPalindrome(num4));
    }

    public static int isPalindrome(int num)
    {
        if (num < 10) return num;
        int res = 0;
        while (num > 0)
        {
            int mod = num % 10;
            res = res*10+mod;
            num = num/10;
        }
        return res;
    }
}
