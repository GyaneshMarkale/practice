package DSA;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Phaser;

public class division {
    public static void main(String[] args)
    {
        System.out.println(divide(1l, 2l));
        System.out.println(divide(1l, 3l));
        System.out.println(divide(1l, 30l));
        System.out.println(divide(1l, 75l));
        System.out.println(divide(4l, 7l));
    }

    public static String divide(Long a, Long b)
    {
        if (b == 0) return "-1";
        StringBuilder sb = new StringBuilder();
        {
            // negative handling
            if ((a < 0) ^ (b < 0)) sb.append("-");
            a = Math.abs(a);
            b = Math.abs(b);

            sb.append(a / b);

            long rem = a % b;
            if (rem == 0) return sb.toString();

            sb.append(".");
            Map<Long, Integer> map = new HashMap<>();
            while (rem != 0) {
                if (map.containsKey(rem)) {
                    int index = map.get(rem);
                    sb.insert(index, "(");
                    sb.append(")");
                    break;
                }
                map.put(rem, sb.length());
                rem = rem * 10;
                sb.append(rem / b);
                rem = rem % b;
            }
        }
        return sb.toString();
    }
}
