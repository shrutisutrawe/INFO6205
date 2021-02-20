package INFO6205.Assignment_3;

public class Node {
    public int data;
    public Node prev;
    public Node next;

    Node(){

    }
    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}
