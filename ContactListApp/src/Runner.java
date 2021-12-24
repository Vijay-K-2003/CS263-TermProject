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
        contact_list.update("Vansh", "Vamsh", "8888888888", "8888888888");
        contact_list.printLinkedListForward();
        contact b = new contact("Mukesh", "9999999999","9999999999", money);
        contact_list.insertLast(b);
        contact_list.printLinkedListBackward();
    }
}
