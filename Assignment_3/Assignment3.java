package INFO6205.Assignment_3;

public class Assignment3 {

    //Merge In Between Linked Lists : https://leetcode.com/problems/merge-in-between-linked-lists/
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null || list1.next == null) {
            return list1;
        }
        if (list2 == null) {
            return list1;
        }
        if (a > b) {
            System.out.println("First integer should be less than second.");
            return list1;
        }
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        int count = 1;
        while (temp1 != null && count != a) {
            temp1 = temp1.next;
            count++;
        }
        ListNode secondHalf = temp1.next;
        ListNode temp3 = secondHalf;
        if (temp2 != null) {
            System.out.println("temp1.next:" + temp1.next.val);
            temp1.next = temp2;
        }
//        printList(head);
        while ((count >= a && count <= b) && temp3.next != null) {
            temp3 = temp3.next;
            count++;
        }
        ListNode temp4 = temp3;
//        printList(temp4);
        temp1 = list1;
        while (temp1.next != null) {
            temp1 = temp1.next;
        }
        temp1.next = temp4;
//        printList(head);
        return list1;
    }

    //Swap Nodes in link list https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp1 = head;
        ListNode back = head;
        ListNode front = head;
        int count = 1;
        while (count != k && front != null) {
            front = front.next;
            temp1 = temp1.next;
            count++;
        }
        while (front.next != null) {
            back = back.next;
            front = front.next;
        }
        int tempVal = back.val;
        back.val = temp1.val;
        temp1.val = tempVal;
        return head;

    }

    // Remove link list element https://leetcode.com/problems/remove-linked-list-elements/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val && head.next == null) {
            return null;
        }
        if (head.val != val && head.next == null) {
            return head;
        }

        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

    //Delete n nodes after m nodes https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while (temp != null && count != m) {
            temp = temp.next;
            count++;
        }
        count = 0;
        while (temp != null && temp.next != null && count != n) {
            temp.next = temp.next.next;
            count++;
        }
        // printList(head);
        //System.out.println(temp1.next.data);
        if (temp != null && temp.next != null) {
            temp.next = deleteNodes(temp.next, m, n);
        }
        return head;
    }
}
