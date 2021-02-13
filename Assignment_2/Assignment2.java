package INFO6205.Assignment_2;

public class Assignment2 {
    //Swap Nodes in Pairs https://leetcode.com/problems/swap-nodes-in-pairs/
    public ListNode swapNodeInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempNode1 = head;
        ListNode tempNode2 = head.next;
        head = head.next;
        tempNode1.next = tempNode2.next;
        tempNode2.next = tempNode1;
        tempNode1.next = swapNodeInPairs(tempNode1.next);
        return head;
    }

    //Delete a node in link list https://leetcode.com/problems/delete-node-in-a-linked-list/
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //3. Even Odd Link List https://leetcode.com/problems/odd-even-linked-list/
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode oddList = odd;
        ListNode oddHead = odd;
        ListNode even = head.next;
        ListNode evenList = even;
        ListNode evenHead = even;
        while (even.next != null || odd.next != null) {
            oddList.next = null;
            if (even.next == null) {
                oddList.next = evenHead;
                break;
            }
            odd = even.next;
            oddList.next = odd;
            oddList = odd;

            evenList.next = null;
            if (odd.next == null) {
                oddList.next = evenHead;
                break;
            }
            even = odd.next;
            evenList.next = even;
            evenList = even;
        }
        return oddHead;
    }

    //4. Split Link list in parts https://leetcode.com/problems/split-linked-list-in-parts/
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] finalList = new ListNode[k];
        if (root == null) {
            return finalList;
        }
        int count = 0;
        ListNode back = root;
        ListNode tempNode = back;

        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        tempNode = back;
        int N = count;
        count = 1;
        int quot = N / k;
        int rem = N % k;
        int sc = 0;

//        System.out.println("Total Nodes : " + N);
        for (int i = 0; i < finalList.length; i++) {
            ListNode backhead = tempNode;
            back = tempNode;
            count = 1;
            if (N < k && sc + 1 <= k) {
                if (back.next != null) {
                    tempNode = back.next;
                    back.next = null;
                    finalList[i] = backhead;
                } else if (i + 1 == N) {
                    finalList[i] = backhead;
                }
                sc++;
            }
            if (N >= k && N % k != 0 && sc < rem) {
                while (((count % (quot + 1) > 0) && back.next != null)) {
                    back = back.next;
                    count++;
                }
                tempNode = back.next;
                back.next = null;
                sc++;
                finalList[i] = backhead;
            } else if (N >= k && sc <= k) {
                while (count % quot > 0 && back.next != null) {
                    back = back.next;
                    count++;
                }
                tempNode = back.next;
                back.next = null;
                sc++;
                finalList[i] = backhead;
            }
        }
        return finalList;
    }

    //5. Insert in Circular link list https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
    public ListNode insertNode(ListNode head, int insertVal) {
        if (head == null) {
            ListNode tempNode = new ListNode(insertVal);
            tempNode.next = tempNode;
            return tempNode;
        }
        ListNode node = new ListNode(insertVal);
        if (head.next == head) {
            node.next = head;
            head.next = node;
            head = node;
            return head;
        }
        ListNode back = null;
        while (back != head) {
            if (back == null) {
                back = head;
            }
            if (back.val <= insertVal && insertVal <= back.next.val) {
                node.next = back.next;
                back.next = node;
                return head;
            } else if (back.val <= insertVal && back.next.val <= insertVal && back.val > back.next.val) {
                node.next = back.next;
                back.next = node;
                return head;
            } else if (back.val > back.next.val && back.val >= insertVal && back.next.val >= insertVal) {
                node.next = back.next;
                back.next = node;
                return head;
            } else {
                if (back.next == head) {
                    back.next = node;
                    node.next = head;
                    return head;
                }
                back = back.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        return;
    }

}
