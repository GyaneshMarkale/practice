package DSA;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencingProblem {
    public static void main(String[] args)
    {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        System.out.println(jobSequencing(deadline, profit));
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            arr[i][0] = profit[i];
            arr[i][1] = deadline[i];
        }
        Arrays.sort(arr, (d1, d2) -> d2[0] - d1[0]);
        int maxDeadline = Arrays.stream(deadline).max().getAsInt();
        int count = 0;
        int maxProfit = 0;
        int[] deadlines = new int[maxDeadline+1];
        for (int i = 0; i <= maxDeadline; i++)
        {
            deadlines[i] = i;
        }
        for (int i = 0; i < n; i++)
        {
            int index = arr[i][1];
            int availableSlot = find(deadline, deadline[index]);
            if (availableSlot > 0)
            {
                maxProfit += arr[i][0];
                count += 1;
                deadline[availableSlot] = find(deadline, availableSlot - 1);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(maxProfit);
        return res;
    }

    private static int find(int[] parent, int x)
    {
        if (x <= 0) return 0;
        if (parent[x] == x) return x;
        return find(parent, parent[x]);
    }
}

