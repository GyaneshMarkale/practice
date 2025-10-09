import java.util.List;
/**
 * 1. to update the details of vechile - method()
 * 2. compare car details -- filter can be dynamic
 * 3. search  based on user preferences
 * 4. versioning of apis
 */

/**
 * 1. create LinkedList.
 * 2. find and delete middle node
 * 3. reverse Linked
 */

class ListNode {
    int val;
    ListNode next;
    ListNode (int val)
    {
        this.val = val;
    }
}
public class LinkedList1 {
    public static void main(String[] args)
    {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        node = findAndDeleteNode(node);
        node = reverseList(node);
        printList(node);
    }
    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    private static ListNode findAndDeleteNode(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // Delete middle node
        if (prev != null) {
            prev.next = slow.next;
        }

        return head;
    }

    private static ListNode reverseList (ListNode head)
    {
        ListNode newHead = null;
        while (head != null)
        {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
