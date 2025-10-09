package DSA;

public class FractionAddition {
    public static void main(String[] args) {
        int[] fraction1 = {2, 3};
        int[] fraction2 = {1, 2};
        int[] res = fractionAddition(fraction1, fraction2);
        System.out.println(res[0] +" "+res[1]);
    }

    public static int[] fractionAddition(int[] fraction1, int[] fraction2) {
        int numerator1 = fraction1[0];
        int numerator2 = fraction2[0];
        int dino1 = fraction1[1];
        int dino2 = fraction2[1];
        int numerator = numerator1 * dino2 + numerator2 * dino1;
        int dino =  dino1 * dino2;
        int gcd = findGcd(numerator, dino);
        numerator = numerator/gcd;
        dino = dino/gcd;
        return new int[] {numerator, dino};
    }

    private static int findGcd(int a, int b)
    {
        if (b == 0) return Math.abs(a);
        return findGcd(b, a % b);
    }
}
