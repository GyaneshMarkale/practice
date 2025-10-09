package DSA;

import java.util.Map;
import java.util.Stack;

class Pair {
    char character;
    int freq;
    Pair(char ch, int freq)
    {
        this.character = ch;
        this.freq = freq;
    }
}
public class reduceString {
    public static void main (String[] args)
    {
        System.out.println(reduce("geeksforgeeks", 2));
        System.out.println(reduce("geeksforgeeks", 1));
    }

    public static String reduce(String s, int k)
    {
        int n = s.length();
        Stack<Pair> st = new Stack<>();
       for (int i = 0; i < n; i++)
       {
           if (st.isEmpty() || st.peek().character != s.charAt(i))
           {
               st.add(new Pair(s.charAt(i), 1));
           }
           else
           {
               if (st.peek().character == s.charAt(i))
               {
                   Pair p = st.peek();
                   st.pop();
                   st.add(new Pair(p.character, p.freq+1));
                   if (st.peek().freq == k) st.pop();
               }
//               else
//               {
//                   st.add(new Pair(s.charAt(i), 1));
//               }
           }
       }
       StringBuilder sb = new StringBuilder();
       while (!st.isEmpty())
       {
           Pair p = st.peek();
           st.pop();
           int i = p.freq;
           while (i != 0) {
               sb.append(p.character);
               i--;
           }
       }
       sb.reverse();
       return sb.toString();
    }
}
