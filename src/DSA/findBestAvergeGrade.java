package DSA;

import java.util.*;

public class findBestAvergeGrade {
    public static void main (String[] agrs)
    {
        String[][] scores = {
//                {"Alice", "85"},
//                {"Bob", "70"},
//                {"Alice", "90"},
//                {"Bob", "80"},
//                {"Charlie", "95"},
//                {"Charlie", "85"}
                {"Bobby","87"},
                {"Charles","125"},
                {"Eric","64"},
                {"Charles","22"}
        };
        getBestAvgScore(scores);

        double avg = Integer.MIN_VALUE;
        double a = (double) -131 / (double) 2;
        System.out.println((Math.floor(Math.max(avg, a))));


    }

    public static void getBestAvgScore(String[][] scores) {
        int n = scores.length;
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++)
        {
            if (!map.containsKey(scores[i][0]))
            {
                map.put(scores[i][0], new int[]{Integer.parseInt(scores[i][1]), 1});
            }
            else
            {
                int[] temp = map.get(scores[i][0]);
                temp[1] = temp[1] + 1;
                temp[0] = (Integer.parseInt(scores[i][1]) + temp[0]) / temp[1];
                map.put(scores[i][0], temp);
            }
        }
        int maxAverage = 0;
        for (Map.Entry<String, int[]> m : map.entrySet())
        {
            maxAverage = Math.max(maxAverage, m.getValue()[0]);
        }
        System.out.println(maxAverage);
        System.out.println(Math.floor(maxAverage));
            //        System.out.println(map);
        Optional<int[]> res = map.entrySet().stream().map(Map.Entry::getValue).
                sorted((v1, v2) -> v2[0] - v1[0]).findFirst();
        System.out.println(res.get()[0]);
    }
}
