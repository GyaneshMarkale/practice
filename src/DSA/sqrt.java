package DSA;

public class sqrt {
    public static void main(String[] args)
    {
        System.out.println(mySqrt(4));
        String s1 = "Sachin";
        String s2 = "Sachin";
        String s3 = new String("Sachin");
        String s4 = "Saurav";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1==s3);
        System.out.println(s1.equals(s4));
    }

    public static double mySqrt(double x) {
        if (x == 0) return 0;
        double low = 0;
        double high = x;
        double ans = 1;
        double epsilon = 1e-6;
        while ((high - low) > epsilon)
        {
            double mid = (low + high) / 2.0;
            if (mid * mid <= x)
            {
                ans = mid;
                low = mid;
            }
            else
            {
                high = mid;
            }
        }
        return ans;
    }
}
