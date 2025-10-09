package DSA;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    public static void main (String [] agrs)
    {
        String txt = "hello";
        String pat = "ll";
        System.out.println(kmp(txt, pat));
    }

    public static List<Integer> kmp(String t, String p)
    {
        List<Integer> res = new ArrayList<>();
        int np = p.length();
        int nt = t.length();
        int[] lsp = new int[np];
        int i = 0;
        int j = i+1;
        lsp[0] = 0;
        while (j < np)
        {
            if (p.charAt(j) == p.charAt(i))
            {
                lsp[j] = i + 1;
                i++;
                j++;
            }
            else
            {
                if (i != 0)
                {
                    i = lsp[i-1];
                    continue;
                }
                else
                {
                    lsp[j] = 0;
                    j++;
                }
            }
        }

        int iptr = 0;
        int jptr = 0;
        while (iptr < nt)
        {
            if (t.charAt(iptr) == p.charAt(jptr))
            {
                iptr++;
                jptr++;
                if (jptr == np)
                {
                    res.add(iptr - jptr);
                    jptr = lsp[jptr-1];
                }
            }
            else {
                if (jptr != 0) {
                    jptr = lsp[jptr - 1];
                } else {
                    iptr++;
                }
            }
        }
        return res;
    }
}
