package DSA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test1 {
    public static void main (String[] args)
    {
        /*
        Given below list of integers
        List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);

        Remove duplicates.
         */

        /*
        Let's assume we have a String as mentioned below,
        andAsComingToandinthemirrorofzoneoutwardsinwardskillingflukeanother

        Remove all the instance of character 'd' in the above string.
        */

        //System.out.println(removedInstances("andAsComingToandinthemirrorofzoneoutwardsinwardskillingflukeanother"));
        List<Integer> myList = Arrays.asList(1, 1, 85, 6, 2, 3, 65, 6, 45, 45, 5662, 2582, 2, 2, 266, 666, 656);
        removeDuplicates(myList);
    }

    public static void removeDuplicates(List<Integer> list)
    {
        int size = list.size();
        Set<Integer> set = new HashSet<>();
        for (Integer i: list)
        {
            if(set.contains(i)) continue;
            else {
                set.add(i);
                System.out.print(i+" ");
            }
        }
    }
    public static String removedInstances(String s)
    {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
//        int [] hash = new int[26];
//        Arrays.fill(hash, -1);
        for (int i = 0; i < n; i++)
        {
            if (s.charAt(i) == 'd') continue;
            else
            {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
