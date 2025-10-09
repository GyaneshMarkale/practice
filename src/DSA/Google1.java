package DSA;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static java.util.Comparator.comparing;

/**
 * 10:00 <alice> Hi! What's up?
 * 10:01 <bob> Hey
 * 10:03 <alice> Dinner?
 * 10:04 <john> I'm down! But only if it isn't vegan.
 */
class Pair1 {
    int userCount;
    int chatLength;
    Pair1 (int _userCount, int chatCount)
    {
        this.userCount = _userCount;
        this.chatLength = chatCount;
    }
}
public class Google1 {
    private static Map<String, Pair1> dataStream = new HashMap<>();
    private static PriorityQueue<String> chatyUser = new PriorityQueue<>(
            (key1, key2) -> {
                Pair1 val1 = dataStream.get(key1);
                Pair1 val2 = dataStream.get(key2);
                if (val2.userCount == val1.userCount) return val1.chatLength - val2.chatLength;
                return val1.userCount - val2.userCount;
            });
    public static void main(String[] args)
    {
        populateData("Alice", "Hi! What's up");
        populateData("bob", "hey");
        populateData("Alice", "Dinner");
        populateData("john", "Hi! What's up");
        populateData("john", "I'm down! But only if it isn't vegan.");
        populateData("Alice", "Ahh!! okay");
        while (!chatyUser.isEmpty())
        {
            String mostChaty = chatyUser.peek();
            chatyUser.poll();
            {
                System.out.println(mostChaty);
            }
        }
    }

    private static void populateData (String user, String chat)
    {
        if (dataStream.containsKey(user))
        {
            Pair1 userData = dataStream.get(user);
            int userCount = userData.userCount + 1;
            int chatCount = userData.chatLength + chat.length();
            dataStream.put(user, new Pair1(userCount, chatCount));
        }
        else
        {
            dataStream.put(user, new Pair1(1, chat.length()));
        }
        chatyUser.add(user);
        if (chatyUser.size() > 1) chatyUser.poll();
    }
}
