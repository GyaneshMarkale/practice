package DSA;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class NMeeetingInOneRoom {
    public static void main(String[] args)
    {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end));
    }

    private static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int count = 0;
        Data[] data = new Data[n];
        for (int i = 0; i < n; i++)
        {

            data[i] = new Data(start[i], end[i], i);
        }
//        Arrays.sort(data, (d1,d2) -> d1.end - d2.end);
//        for (int i = 0; i < n; i++)
//        {
//            if (data[i].end >)
//        }
        return count;
    }
}

class Data{
    int start;
    int end;
    int pos; // if asked in interview

    public Data(int s, int e, int p)
    {
        this.start = s;
        this.end = e;
        this.pos = p;
    }
}
