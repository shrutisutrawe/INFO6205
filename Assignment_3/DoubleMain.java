package INFO6205.Assignment_3;

public class DoubleMain {
    public static void main(String[] args){
        DoubleLinkedList list = new DoubleLinkedList();
        //Node head = null;
        //list.addHead(2);
        //list.printDoubleList(list.head);
        //list.addHead(1);
        //list.printDoubleList(list.head);
        list.addTail(3);
        list.addTail(4);
        list.addTail(5);
        list.addTail(6);
        //list.printDoubleList(list.head);
        //list.insertAfter(list.head,10);
        list.printDoubleList(list.head);
        System.out.println("Size : "+list.sizeOfDoubleList());


    }
}
