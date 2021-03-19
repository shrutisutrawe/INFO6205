package INFO6205.Assignment_6;

public class ReverseKNodes {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempNode1 = head;
        int N = 0;
        while (tempNode1 != null) {
            tempNode1 = tempNode1.next;
            N++;
        }
        tempNode1 = head;
        head = reverseKNodes(tempNode1, k, N);
        return head;
    }

    private static ListNode reverseKNodes(ListNode head, int k, int N) {
        ListNode tempNode = head;
        ListNode front = new ListNode();
        if (head.next != null) {
            front = head.next;
        } else {
            return null;
        }

        ListNode back = null;
        int count = 1;
        while (count != k && front != null) {
            tempNode.next = back;
            back = tempNode;
            tempNode = front;
            front = front.next;
            count++;
        }
        if (front == null) {
            tempNode.next = back;
            head = tempNode;
            return head;
        }
        tempNode.next = back;
        ListNode tempNode1 = null;
        if (N - k >= k) {
            N = N - count;
            tempNode1 = reverseKNodes(front, k, N);
        }
        ListNode tail = tempNode;
        while (tail.next != null) {
            tail = tail.next;
        }
        if (tempNode1 != null) {
            front = tempNode1;
        }

        tail.next = front;
        head = tempNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode();
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = list.createList(array);
        list.printList(head);
        ListNode node = reverseKGroup(head, 3);
        list.printList(node);
    }
}
