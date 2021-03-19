package INFO6205.Assignment_6;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode createList(int array[]) {
        ListNode head = new ListNode(array[0]);
        ListNode tempNode = head;
        for (int i = 1; i < array.length; i++) {

            ListNode node = new ListNode(array[i]);
            tempNode.next = node;
            tempNode = tempNode.next;
        }
        return head;
    }

    public void printList(ListNode head) {
        ListNode tempNode = new ListNode();
        tempNode = head;
        while (tempNode != null) {
//        while(tempNode.next != tempNode){
            System.out.print(tempNode.val + "->");
            tempNode = tempNode.next;
        }
        System.out.println("NULL");
    }
}

