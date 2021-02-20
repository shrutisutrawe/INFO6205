package INFO6205.Assignment_3;

public class DoubleLinkedList {
    public Node head;
    public DoubleLinkedList(){

    }
    public void addHead(int value) {

        if (head == null) {
            head = new Node(value);
            return;
        }
        Node node = new Node(value);
        node.prev = null;
        head.prev = node;
        node.next = head;
        head = node;
    }

    public void printDoubleList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public void addTail(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            head.prev = null;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        node.prev = temp;
        System.out.println("node.orev:"+node.prev.data);
        temp.next = node;
        node.next = null;
    }

//    public void insertAfter(Node prevNode, int value){
//        if(prevNode == null){
//            System.out.println("Previous node is provided.");
//            return;
//        }
//        Node node = new Node(value);
//        node.next = prevNode.next;
//        node.prev = prevNode;
//        prevNode.next = node;
//        if(node.next != null){
//            node.next.prev = node;
//        }
//    }

    public int sizeOfDoubleList(){
        if(head == null){
            return 0;
        }
        Node temp = head;
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
}
