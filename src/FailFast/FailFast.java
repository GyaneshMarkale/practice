package FailFast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FailFast {
    public static void main(String[] args)
    {
       List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,5));
       System.out.println(list);
        list.removeIf(integer -> integer == 2);
        System.out.println(list);



    }
}
