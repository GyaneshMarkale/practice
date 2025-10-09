package DSA;

import java.util.*;

public class GoogleQues1 {
    public static Map<Long, Long> INDEX_MAP = new HashMap<>();
    public static Map<Long, TreeSet<Long>> VALUE_SMALLEST_INDEX_MAP = new HashMap();
    public static void main(String[] args)
    {
        for (int i = 1; i <= 3; i++)
        {
            insertOrReplace(1, 100);
            insertOrReplace(2, 100);
            insertOrReplace(2, 200);
            insertOrReplace(3, 200);
        }
        System.out.println(getSmallestIndex(200));
    }
    public static void insertOrReplace(long index, long value)
    {
        if (INDEX_MAP.containsKey(index)) {
            long v1 = INDEX_MAP.get(index);
            if (VALUE_SMALLEST_INDEX_MAP.containsKey(v1)) {
                VALUE_SMALLEST_INDEX_MAP.get(v1).remove(index);
                if (VALUE_SMALLEST_INDEX_MAP.get(v1).isEmpty()) {
                    VALUE_SMALLEST_INDEX_MAP.remove(v1);
                }
            }
        }
        if (VALUE_SMALLEST_INDEX_MAP.containsKey(value)) {
            VALUE_SMALLEST_INDEX_MAP.get(value).add(index);
        } else {
            TreeSet<Long> set = new TreeSet<>();
            set.add(index);
            VALUE_SMALLEST_INDEX_MAP.put(value, set);
        }
        INDEX_MAP.put(index, value);
    }

    public static Long getSmallestIndex (long number)
    {
        if (VALUE_SMALLEST_INDEX_MAP.containsKey(number))
        {
            return VALUE_SMALLEST_INDEX_MAP.get(number).first();
        }
        return (long)-1;
    }
}
