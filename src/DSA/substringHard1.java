package DSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class substringHard1 {
    public static void main(String[] args)
    {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> res = findSubstring(s, words);
        System.out.println(res);
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        Map<String, Integer> wordsMapFreq = new HashMap<>();
        for (String s1 : words)
        {
            wordsMapFreq.put(s1, wordsMapFreq.getOrDefault(s1, 0) + 1);
        }
        int wordLen = words[0].length();
        int maxWordLen = wordLen * words.length;
        List<Integer> res= new ArrayList<>();
        for (int i = 0; i < n - words.length * wordLen + 1; i ++)
        {
            int count = maxWordLen;
            Map<String, Integer> wordExists = new HashMap<>(wordsMapFreq);
            int ptr1 = i;
            int ptr2 = i + wordLen;
            while (count > 0)
            {
                String word = s.substring(ptr1, ptr2);
                if (wordExists.containsKey(word) && wordExists.get(word) > 0)
                {
                    wordExists.put(word, wordExists.get(word)-1);
                    count = count - wordLen;
                    ptr1 = ptr2;
                    ptr2 = ptr1 + wordLen;
                }
                else{
                    break;
                }
            }
            if (count == 0) res.add(i);
        }
        return res;
    }
}
