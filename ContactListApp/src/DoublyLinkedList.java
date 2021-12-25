import java.util.*;

class contact{
    String name;
    String mobile_number;

    contact(String name, String mobile_number){
        this.name = name;
        this.mobile_number = mobile_number;

    }
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        contact contact = (contact) o;
        return mobile_number.equals(contact.mobile_number);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(mobile_number);
    }
}

class Node {
    public contact data;
    public Node next;
    public Node prev;

    public void displayNodeData() {
        if(!(data.name.compareTo(data.mobile_number)==0))
            System.out.println("Name : " + data.name + "              Mobile Number: " + data.mobile_number );
        else
            System.out.println("Mobile Number: " + data.mobile_number);
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
        while (!Objects.equals(temp.data.name, name))
        {
            pos++;
            temp = temp.next;
        }
        if (!Objects.equals(temp.data.name, name))
            return null;
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
    public void update(String name, String newName, String mobileNumber) {
        if(mobileNumber.length() != 10)
        {
            System.out.println("Invalid Reenter Phone Number data");
        }
        Node req = search(name);
        req.data.name = newName;
        req.data.mobile_number = mobileNumber;
    }

    public Node deleteNode(Node del)
    {
        Node temp=del;

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
            if (us.contains(current.data.name) && current.data.name != null)
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

    public void sortName()
    {
        ArrayList<Node> arrayList = new ArrayList<>();
        Node headCopy = head;
        while(headCopy != null)
        {
            arrayList.add(headCopy);
            headCopy = headCopy.next;
        }
        MergeSort ms = new MergeSort(arrayList);
        ms.sortGivenArray();
        arrayList = ms.getSortedArray();
        for(int i = 0 ; i < arrayList.size() ; i++) {
            arrayList.get(i).displayNodeData();
        }
    }
    public void sortNumber()
    {
        ArrayList<Node> arrayList = new ArrayList<>();
        Node headCopy = head;
        while(headCopy != null)
        {
            arrayList.add(headCopy);
            headCopy = headCopy.next;
        }
        RandomisedQuickSort hs = new RandomisedQuickSort(arrayList);
        hs.startQuickStart(0, arrayList.size()-1);
        arrayList = hs.getSortedArray();
        for(int i = 0 ; i < arrayList.size() ; i++) {
            arrayList.get(i).displayNodeData();
        }
    }
    public void sort()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Do you have enough memory? Y / N");
        String in = s.next();
        if(in.equals("Y"))
            sortName();
        else
            sortNumber();
    }
    public ArrayList<Node> getArrayList()
    {
        ArrayList<Node> arrayList = new ArrayList<>();
        Node headCopy = head;
        while(headCopy != null)
        {
            arrayList.add(headCopy);
            headCopy = headCopy.next;
        }
        return arrayList;
    }

    public void createGraph(ArrayList<Node> al)
    {
        System.out.println("Representation used-");
        for(int i=0;i<al.size();i++){
            System.out.println(al.get(i).data.name + "-" + i);
        }
        int[][] mat = new int[al.size()][al.size()];
        for(int x=0;x<al.size();x++){
            for(int y=0;y<al.size();y++){
                mat[x][y]=0;
            }
        }
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of debt transactions:");
        int n =sc.nextInt();
        System.out.println("Enter (src,dest,money) in this specified format!");
        for(int k=0;k<n;k++){
            int s=sc.nextInt();
            int d=sc.nextInt();
            int m=sc.nextInt();
            System.out.println("\n");
            mat[s][d]=m;
        }
        minCashFlow(mat);
    }

    // A utility function that returns
    // index of minimum value in arr[]
    static int getMin(int arr[])
    {
        int minInd = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[minInd])
                minInd = i;
        return minInd;
    }

    // A utility function that returns
    // index of maximum value in arr[]
    static int getMax(int arr[])
    {

        int maxInd = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[maxInd])
                maxInd = i;
        return maxInd;
    }

    // A utility function to return minimum of 2 values
    static int minOf2(int x, int y)
    {
        return (x < y) ? x: y;
    }

    // amount[p] indicates the net amount
    // to be credited/debited to/from person 'p'
    // If amount[p] is positive, then
    // i'th person will amount[i]
    // If amount[p] is negative, then
    // i'th person will give -amount[i]
    static void minCashFlowRec(int amount[])
    {
        // Find the indexes of minimum and
        // maximum values in amount[]
        // amount[mxCredit] indicates the maximum amount
        // to be given (or credited) to any person .
        // And amount[mxDebit] indicates the maximum amount
        // to be taken(or debited) from any person.
        // So if there is a positive value in amount[],
        // then there must be a negative value
        int mxCredit = getMax(amount), mxDebit = getMin(amount);

        // If both amounts are 0, then
        // all amounts are settled
        if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
            return;

        // Find the minimum of two amounts
        int min = minOf2(-amount[mxDebit], amount[mxCredit]);
        amount[mxCredit] -= min;
        amount[mxDebit] += min;

        // If minimum is the maximum amount to be
        System.out.println("Person " + mxDebit + " pays " + min
                + " to " + "Person " + mxCredit);

        // Recur for the amount array.
        // Note that it is guaranteed that
        // the recursion would terminate
        // as either amount[mxCredit]  or
        // amount[mxDebit] becomes 0
        minCashFlowRec(amount);
    }

    // Given a set of persons as graph[]
    // where graph[i][j] indicates
    // the amount that person i needs to
    // pay person j, this function
    // finds and prints the minimum
    // cash flow to settle all debts.
    public void minCashFlow(int graph[][])
    {
        int N=graph[0].length;
        // Create an array amount[],
        // initialize all value in it as 0.
        int amount[]=new int[graph[0].length];

        // Calculate the net amount to
        // be paid to person 'p', and
        // stores it in amount[p]. The
        // value of amount[p] can be
        // calculated by subtracting
        // debts of 'p' from credits of 'p'
        for (int p = 0; p < N; p++)
            for (int i = 0; i < N; i++)
                amount[p] += (graph[i][p] - graph[p][i]);

        minCashFlowRec(amount);
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

    public LRUCache createCache(int capacity) {
        LRUCache lruc = new LRUCache(capacity);
        return lruc;
    }

    public void referLRUC(Node node, LRUCache lruc) {
        lruc.refer(node);
    }

    public void displayCache(LRUCache lruc) {
        lruc.display();
    }

    public void deleteAll() {
        while(head != null) {
            deleteFirst();
        }
    }

    public Node get(int index) {
        Node f = head;
        if(index == 0)
            return f;
        else
            for(int i=0;i<index-1;i++)
                f = f.next;
        return f;
    }
}
