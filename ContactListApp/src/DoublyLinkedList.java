import java.util.ArrayList;
import java.util.Objects;
import java.util.HashSet;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        contact contact = (contact) o;
        return mobile_number.equals(contact.mobile_number) && work_number.equals(contact.work_number);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mobile_number, work_number);
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
        while (temp.data != x && temp.next != null)
        {
            pos++;
            temp = temp.next;
        }
        if (temp.data != x)
            System.out.println("Not Found!");
        temp.displayNodeData();
    }

    public Node search(String name)
    {
        Node temp = head;
        int pos = 0;
        while (!Objects.equals(temp.data.name, name) && temp.next != null)
        {
            pos++;
            temp = temp.next;
        }
        if (!Objects.equals(temp.data.name, name))
            System.out.println("Not Found!");
        return temp;
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
    public void update(String name, String newName,String workNumber, String mobileNumber) {
        if(workNumber.length() != 10 || mobileNumber.length() != 10)
        {
            System.out.println("Invalid Reenter Phone Number data");
        }
        Node req = search(name);
        req.data.name = newName;
        req.data.work_number = workNumber;
        req.data.mobile_number = mobileNumber;
    }

    public Node deleteNode(Node del)
    {
        Node temp=del;
//        del.prev.next=del.next;
        if (head == null || del == null) {
            return head;
        }

        if (head == del)
        {
            head = del.next;
        }
        if (del.next != null)
            del.next.prev = del.prev;

        if (del.prev != null)
            del.prev.next = del.next;

        return head;
    }

    public Node removeDuplicates()
    {
        if ((head) == null)
            return null;

        HashSet<String> us = new HashSet<>();
        Node current = head, next;

        while (current != null)
        {
            if (us.contains(current.data.name))
            {
                System.out.println("HashSet contains " + current.data.name);
                next = current.next;
                head = deleteNode(current);
                current = next;
            }
            else
            {
                us.add(current.data.name);
                current = current.next;
            }
        }
        System.out.println("Deleted Duplicates");
        return head;
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
        Node headCopy = head;

        while(headCopy.next != null)
        {
            headCopy = headCopy.next;
        }

        while (headCopy != null) {
            headCopy.displayNodeData();
            headCopy = headCopy.prev;
        }
        System.out.println();
    }
}