import java.util.Scanner;
public class AddressBookSystem {
    public static Contact addcontact(){
        Scanner sc = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Enter first name ");
        contact.setFirstname(sc.next());
        System.out.println("Enter last name ");
        contact.setLastname(sc.next());
        System.out.println("Enter address");
        contact.setAddress(sc.next());
        System.out.println("Enter city");
        contact.setCity(sc.next());
        System.out.println("Enter phone");
        contact.setPhone(sc.nextInt());
        return contact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book");
        Contact contact = addcontact();
        System.out.println(contact);
    }
}
