package DSA;

import java.util.ArrayList;
import java.util.List;

public class DSU {
    List<Integer> parent = new ArrayList<>();
    List<Integer> unionBySize = new ArrayList<>();

    public DSU (int n)
    {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            unionBySize.add(1);
        }
    }

    public int findParent(int u)
    {
        if (u == parent.get(u)) return u;
        int ulp = findParent(parent.get(u));
          parent.set(u, ulp);
        return ulp;
    }

    public void unionBySize(int u , int v)
    {
        int ulp_u = parent.get(u);
        int ulp_v = parent.get(v);
        if (ulp_u == ulp_v) return;
        if (unionBySize.get(ulp_u) < unionBySize.get(ulp_v))
        {
            parent.set(ulp_u, ulp_v);
            unionBySize.set(ulp_v, unionBySize.get(ulp_u) + unionBySize.get(ulp_v));
        }
        else
        {
            parent.set(ulp_v, ulp_u);
            unionBySize.set(ulp_u, unionBySize.get(ulp_u) + unionBySize.get(ulp_v));
        }
    }

    public static void main(String[] args)
    {
        DSU dsu = new DSU(7);
        dsu.unionBySize(1, 2);
        dsu.unionBySize(2, 3);
        dsu.unionBySize(4, 5);
        dsu.unionBySize(6, 7);
        dsu.unionBySize(5, 6);

        if (dsu.findParent(3) == dsu.findParent(7))
        {
            System.out.println("same");
        }
        else
        {
            System.out.println("Not same");
        }

        dsu.unionBySize(3, 7);

        if (dsu.findParent(3) == dsu.findParent(7))
        {
            System.out.println("same");
        }
        else
        {
            System.out.println("Not same");
        }
        System.out.println(dsu.findParent(4));
    }

}
