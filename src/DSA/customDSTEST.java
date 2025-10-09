package DSA;

import java.util.LinkedHashMap;
import java.util.Map;

public class customDSTEST {

    public static void main(String[] args)
    {
        CustomDs ds = new CustomDs();
        ds.push(1);
        ds.push(2);
        System.out.println(ds.pop());
        System.out.println(ds.pop());
        ds.push(3);
        System.out.println(ds.seek(0));
        ds.push(1);
        System.out.println(ds.seek(1));



    }
}

class ListNode1 {
    int data;
    ListNode1 next;
    public ListNode1(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class CustomDs {
    ListNode1 node;
    Map<Integer, ListNode1> map;
    int start = 0;
    int i = 0;
    public CustomDs ()
    {
        map = new LinkedHashMap<>();
    }

    public void push(int data)
    {
        if (node == null)
        {
            node = new ListNode1(data);
            map.put(i++, node);
            return;
        }
        ListNode1 curr = node;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = new ListNode1(data);
        curr = curr.next;
        map.put(i++, curr);
    }

    public int pop()
    {
        //ListNode1 temp = node;
        int popped = node.data;
        node = node.next;
        map.remove(start);
        start++;
        return popped;
    }

    public int seek(int index)
    {
        if (index < 0) {
            System.out.println("Index cannot be negative");
            return -1;
        }

        int actualIndex = start + index;
        if (actualIndex >= i) {
            System.out.println("Index out of bounds");
            return -1;
        }

        ListNode1 n = map.get(actualIndex);
        if (n == null) {
            System.out.println("Node not found");
            return -1;
        }

        return n.data;
    }


}
