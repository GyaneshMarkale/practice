import Generice.Pair;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        list.add(new Pair(1, 1));
        list.add(new Pair(2, 2));
        for (Pair p : list)
        {
            System.out.println(p.getKey() +" "+p.getValue());
        }

        List<Integer> parent = new ArrayList<>();
        for (int i = 0; i <= 3; i++)
        {
            parent.add(i);
        }
        System.out.println(parent);
    }
}