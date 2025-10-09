/**
 * implement a singly linked list and a method to find middle node
 */
 // 1 -> 2 -> 3 -> 4 -> 5

class Node{
    int val;
    Node next;
    Node(int val)
    {
        this.val = val;
    }
}
public class GSTest {
    public static void main(String[] args)
    {
        Node node = null;
        node = insert(node, 1);
        node = insert(node, 2);
        node = insert(node, 3);
        node = insert(node, 4);
        node = insert(node, 5);

        // Linked list iteration
        Node currNode = node;
        while (currNode != null)
        {
            System.out.print(currNode.val+" ");
            currNode = currNode.next;
        }
        System.out.println("");
        // middle node logic
        Node middleNode = findMiddleEle(node);
        System.out.println("middleNode: "+middleNode.val);
    }

    private static Node findMiddleEle(Node head)
    {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node insert(Node head, int val)
    {
        if (head == null) return new Node(val);
        Node node = new Node(val);
        Node curr = head;
        while (curr.next != null)
        {
            curr = curr.next;
        }
        curr.next = node;
        return head;
    }
}



// 1 - 2
// 2 -> null



