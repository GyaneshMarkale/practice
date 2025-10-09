package DSA;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val)
    {
        this.val = val;
        this.next = null;
    }
}

public class reverseLinkedList {
    public static void main(String[] args)
    {
        ListNode node = null;
        node = insert(node, 50);
        node = insert(node, 60);
        node = insert(node, 70);

        ListNode curr = node;

        while (curr != null)
        {
            System.out.println(curr.val);
            curr = curr.next;
        }

        ListNode head = reverseList(node);
        ListNode curr1 = head;

        while (curr1 != null)
        {
            System.out.println(curr1.val);
            curr1 = curr1.next;
        }
    }

    public static ListNode reverseList(ListNode head)
    {
        ListNode newHead = null;
        while (head != null)
        {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static ListNode insert(ListNode node, int val)
    {
        if (node == null) return new ListNode(val);

        if (node != null)
        {
            ListNode curr = node;
            while (curr.next != null) {
                curr = curr.next;
            }
            ListNode newNode = new ListNode(val);
            curr.next = newNode;
        }

        return node;
    }
}



