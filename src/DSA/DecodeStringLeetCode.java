package DSA;

import java.util.Stack;

// LeetCode - 394
public class DecodeString {
    public static void main(String[] args)
    {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));

    }
    public static String decodeString(String s) {
        int n = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for (int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);
            if (Character.isDigit(ch))
            {
                num = (10 * num) + (ch - '0'); // handle 2 digit if any
            }
            else if (ch == '[')
            {
                numStack.push(num);
                num = 0;
                stringStack.push(curr);
                curr = new StringBuilder();
            }
            else if (ch == ']')
            {
                int repeat = numStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int j = 0; j < repeat; j++)
                {
                    decoded.append(curr);
                }
                curr = decoded;
            }
            else
            {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
