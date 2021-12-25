import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static LRUCache cache;
    public static LRUCache cache1;
    public static DoublyLinkedList contact_list;
    public static DoublyLinkedList contact_list_unnamed;

    public static void main(String[] args) {
        contact_list = new DoublyLinkedList();
        contact_list_unnamed = new DoublyLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("<----------------- WELCOME TO CONTACT MANAGER  ----------------->");
        System.out.println();
        System.out.println("_________________________________________________________________");
        System.out.println("|   Select Number           |   Operation to be performed       |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       1                   |       Add contact                 |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       2                   |       Delete contact              |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       3                   |       Modify contact              |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       4                   |       Delete duplicate contacts   |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       5                   |       Sort the contact list       |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       6                   |       Create Cache Memory         |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       7                   |       Search Result               |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       8                   |       Split the bill              |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       9                   |       Print contact details       |");
        System.out.println("|_______________________________________________________________|");
        System.out.println("|       10                  |       Exit                        |");
        System.out.println("|_______________________________________________________________|");
        System.out.println();
        System.out.print("Choose an option from above table to perform corresponding operation : ");
        int sentinel = sc.nextInt();
        while (sentinel>=1 && sentinel<10) {
            if (sentinel == 1) {
                System.out.println("came in");
                if (contact_list.isEmpty()) {
                    System.out.print("Do you want to add emergency contacts(Y/N) : ");
                    char sent = sc.next().charAt(0);
                    if (sent == 'Y') {
                        addEmergency();
                        System.out.println("Emergency contacts added successfully");
                        System.out.print("Enter mobile number : ");
                        String a = sc.next();
                        if (a.length() != 10) {
                            System.out.println("Enter correct mobile number of 10 digits");
                        } else {
                            System.out.print("Do you want to add a name to the contact (Y/N) : ");
                            char bool = sc.next().charAt(0);
                            if (bool == 'Y') {
                                System.out.print("Enter the name : ");
                                String name = sc.next();
                                contact add = new contact(name, a);
                                contact_list.insertFirst(add);
                            } else {
                                contact add = new contact(a, a);
                                contact_list_unnamed.insertLast(add);
                            }
                        }
                    }
                }
                else{
                    System.out.print("Enter mobile number : ");
                    String a = sc.next();
                    if (a.length() != 10) {
                        System.out.println("Enter correct mobile number of 10 digits");
                    } else {
                        System.out.print("Do you want to add a name to the contact (Y/N) : ");
                        char bool = sc.next().charAt(0);
                        if (bool == 'Y') {
                            System.out.print("Enter the name : ");
                            String name = sc.next();
                            contact add = new contact(name, a);
                            contact_list.insertFirst(add);
                        } else {
                            contact add = new contact(a, a);
                            contact_list_unnamed.insertLast(add);
                        }
                    }
                }
            } else if (sentinel == 2) {
                System.out.print("Enter contact to be deleted : ");
                String a = sc.next();
                Node temp = contact_list.search(a);
                if(temp != null){
                    contact_list.deleteNode(temp);
                    System.out.println("contact deleted successfully");
                }
                else
                    System.out.println("Contact not found");
            }
            else if(sentinel == 3){
                System.out.println("Enter contact to be updated : ");
                String a = sc.next();
                Node temp = contact_list.search(a);
                if(temp == null){
                    System.out.println("Contact not found");
                }
                else{
                    System.out.println("Enter new name : ");
                    String new_name = sc.next();
                    System.out.println("Enter new contact number : ");
                    String new_contact = sc.next();
                    contact_list.update(a,new_name,new_contact);
                    System.out.println("Contact updated successfully");
                }
            }
            else if(sentinel == 4){
                contact_list.removeDuplicates();
                contact_list_unnamed.removeDuplicates();
                System.out.println("Removed duplicate contacts");
            }
            else if(sentinel == 5){
                char input;
                System.out.print("Press 1 if you have memory : ");
                input = sc.next().charAt(0);
                if(input == '1'){
                    ArrayList a = contact_list.getArrayList();
                    MergeSort sort = new MergeSort(a);
                    contact_list.printLinkedListForward();
                    HeapSort sort2 = new HeapSort();
                    sort2.heapSort(contact_list_unnamed, contact_list_unnamed.size);
                    contact_list_unnamed.printLinkedListForward();
                }
                else{
                    ArrayList a = contact_list.getArrayList();
                    RandomisedQuickSort sort = new RandomisedQuickSort(a);
                    contact_list.printLinkedListForward();
                }
            }
            else if(sentinel == 6){
                cache = contact_list.createCache(contact_list.size/10);
                cache1 = contact_list_unnamed.createCache(contact_list_unnamed.size/10);
            }
            else if(sentinel == 7){

            }
            else if(sentinel == 8){

            }
            else if(sentinel == 9){
                System.out.println("Printing named contact list");
                contact_list.printLinkedListForward();
                System.out.println("Printing unnamed contact list");
                contact_list_unnamed.printLinkedListForward();
            }
            System.out.print("Enter other sentinel : ");
            sentinel = sc.nextInt();
        }
    }
    public static void addEmergency () {
        contact a = new contact("Ambulance", "102");
        contact_list.insertFirst(a);
        a = new contact("Fire Brigade", "101");
        contact_list.insertFirst(a);
        a = new contact("Police", "100");
        contact_list.insertFirst(a);
        a = new contact("National helpline", "112");
        contact_list.insertFirst(a);
        a = new contact("Women Helpline", "1091");
        contact_list.insertFirst(a);
    }
}