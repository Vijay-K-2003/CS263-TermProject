import java.util.ArrayList;

class contact{
    String name;
    String mobile_number;
    String work_number;
    ArrayList store;
    contact(String name, String mobile_number, String work_number, ArrayList<String> store){
        this.name = name;
        this.mobile_number = mobile_number;
        this.work_number = work_number;
        this.store = store;
    }
}

class Node {
    public contact data;
    public Node next;
    public Node prev;

    public void displayNodeData() {
        System.out.println("{\n\tName : " + data.name +
                "\n\tWork Number: " + data.work_number +
                "\n\tMobile Number: " + data.mobile_number +
                "\n\tStore: " + data.store + "\n}");
    }
}

public class DoublyLinkedList<T> {

    private Node head;
    private Node tail;
    int size;

    public boolean isEmpty() {
        return (head == null);
    }

    public void insertFirst(contact data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        newNode.prev=null;
        if(head!=null)
            head.prev=newNode;
        head = newNode;
        if(tail==null)
            tail=newNode;
        size++;
    }

    public void insertLast(contact data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        newNode.prev=tail;
        if(tail!=null)
            tail.next=newNode;
        tail = newNode;
        if(head==null)
            head=newNode;
        size++;
    }

    void search(contact x)
    {
        Node temp = head;
        int pos = 0;
        ArrayList<String> money = new ArrayList<>();
        money.add("NULL");
        contact a = new contact("NULL","NOT SAVED","NOT SAVED",money);
        while (temp.data != x && temp.next != null)
        {
            pos++;
            temp = temp.next;
        }
        if (temp.data != x)
            System.out.println("Not Found!");
        temp.displayNodeData();
    }

    public Node deleteFirst() {
        if (size == 0)
            throw new RuntimeException("Doubly linked list is already empty");
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }
    public Node deleteLast() {
        Node temp = tail;
        tail = tail.prev;
        tail.next=null;
        size--;
        return temp;
    }
    public void deleteAfter(Node after) {
        Node temp = head;
        while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }
        if (temp.next != null)
            temp.next.next.prev=temp;
        assert temp.next != null;
        temp.next = temp.next.next;
    }
    public void update() {

    }
    public void printLinkedListForward() {
        System.out.println("Printing Doubly LinkedList (head --> tail) ");
        Node current = head;
        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }
        System.out.println();
    }
    public void printLinkedListBackward() {
        System.out.println("Printing Doubly LinkedList (tail --> head) ");
        Node current = tail;
        while (current != null) {
            current.displayNodeData();
            current = current.prev;
        }
        System.out.println();
    }
}