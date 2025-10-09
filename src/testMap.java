import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class testMap {
    public static Map<String, Map<String, String>> map = new HashMap<>();
    public static Map<String, String> fieldValueMap = new HashMap<>();
    public static void main (String[] args)
    {
        set("A", "B", "C");
        set("A", "E", "F");
        System.out.println(map);

        System.out.println("get answer: "+get("A", "B"));
        System.out.println("Deletion: "+delete("A", "F"));
        System.out.println("Deletion: "+delete("A", "B"));
        System.out.println(map);

    }
    public static void set(String key, String field, String value)
    {
        if (map.containsKey(key))
        {
            fieldValueMap = map.get(key);
            fieldValueMap.put(field, value);
            map.put(key, fieldValueMap);
        }
        else {
            fieldValueMap.put(field, value);
            map.put(key, fieldValueMap);
        }
    }

    public static Optional<String> get(String key, String field)
    {
        Optional<String> res = Optional.empty();
        if (map.containsKey(key))
        {
            if (map.get(key).containsKey(field))
            {
                res = Optional.of(map.get(key).get(field));
            }
        }
        return res;
    }

    public static boolean delete (String key, String field)
    {
        if (map.containsKey(key)) {
            if (map.get(key).containsKey(field)) {
                map.get(key).remove(field);
                return true;
            }
        }
        return false;
    }
}
