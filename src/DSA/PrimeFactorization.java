package DSA;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorization {
    public static void main(String[] args)
    {
        System.out.println(primeFactor(10));
        System.out.println(primeFactor(6));

    }

    public static ArrayList<Integer> primeFactor(int num)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == 0 || num == 1 || num == 2)
        {
            res.add(num);
            return res;
        }

        for (int i = 2 ; i * i <= num; i=i+2)
        {
            while (num % i == 0)
            {
                res.add(i);
                num /= i;
            }
        }

        if (num > 2)
        {
            res.add(num);
        }
        return res;
    }
}
