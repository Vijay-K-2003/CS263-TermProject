import java.util.ArrayList;
public class Runner
{
    public static void main(String[] args) {
        DoublyLinkedList contact_list = new DoublyLinkedList();
        System.out.println("Enter 1 to add a contact");
        ArrayList<String> money = new ArrayList<>();
        money.add("300 paid to Sai");
        money.add("500 took from Nivas");
        contact a = new contact("Vansh","7777777777","100",money);
        contact_list.insertLast(a);
        contact_list.search(a);
        contact_list.printLinkedListForward();
        contact_list.update("Vansh", "Vamsh", "9777777770", "9777777770");
        contact_list.printLinkedListForward();
        contact b = new contact("xukesh", "9888888888","9888888888", money);
        contact_list.insertLast(b);
        contact_list.printLinkedListBackward();
        contact c = new contact("Vamsh", "9777777770", "9777777770", money);
        contact_list.insertLast(c);
        contact_list.printLinkedListBackward();
        contact_list.removeDuplicates();
        contact_list.printLinkedListBackward();
        contact_list.sortName();
        ArrayList<Node> arrayList = contact_list.getArrayList();
        contact_list.createGraph(arrayList);
        contact_list.sortNumber();

        LRUCache lruc = contact_list.createCache(5);
        contact_list.referLRUC(contact_list.search("Vamsh"), lruc);
        contact_list.referLRUC(contact_list.search("xukesh"), lruc);
        contact d = new contact("Vams", "9777777770", "9777777770", money);
        contact_list.insertFirst(d);
        contact e = new contact("Vam", "9777777770", "9777777770", money);
        contact_list.insertFirst(e);
        contact f = new contact("Va", "9777777770", "9777777770", money);
        contact_list.insertFirst(f);
        contact_list.referLRUC(contact_list.search("Vams"), lruc);
        contact_list.referLRUC(contact_list.search("Vam"), lruc);
        contact_list.referLRUC(contact_list.search("Va"), lruc);
        contact_list.displayCache(lruc);
        contact g = new contact("VJK", "7777777777", "9696969696", money);
        contact_list.insertFirst(g);
        contact_list.referLRUC(contact_list.search("VJK"), lruc);
        contact_list.displayCache(lruc);
    }
}
