package DSA;

public class validParenthesis1 {
    public static void main(String[] args)
    {
        String s = ")((c)d()(l";
        System.out.println(minRemoveToMakeValid(s));
    }
    public static String minRemoveToMakeValid(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (Character.isLetter(s.charAt(i)))
            {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) ==  '(')
            {
                count++;
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && count > 0)
            {
                count--;
                sb.append(s.charAt(i));
            }
        }
        String s2 = sb.toString();
        sb = new StringBuilder();
        for (int i = s2.length() - 1; i >=0 ; i--)
        {
            if (Character.isLetter(s2.charAt(i)))
            {
                sb.append(s2.charAt(i));
            }
            else if (s2.charAt(i) ==  '(')
            {
                continue;
            }
            else if (s2.charAt(i) == ')')
            {
                sb.append(s2.charAt(i));
            }
        }

        if (sb.isEmpty()) return "";


        return sb.toString();
    }
}
