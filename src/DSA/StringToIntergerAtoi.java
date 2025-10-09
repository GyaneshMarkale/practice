package DSA;

public class StringToIntergerAtoi {
    public static void main (String[] args)
    {
        String s = "words to 122";
        myAtoi(s);
    }
    public static int myAtoi(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') continue;
            if (s.charAt(i) == '-') {
                sb.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == '0') continue;
            if (!Character.isDigit(s.charAt(i))) break;
            sb.append(s.charAt(i));
        }
        String s1 = sb.toString();
        if (s1.isEmpty()) return 0;
        return Integer.parseInt(s1);
    }

}
