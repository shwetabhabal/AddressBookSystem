import java.util.Objects;
import java.util.Scanner;
public class AddressBookSystem {
    static Contact[] contacts = new Contact[100];
    static int count=0;
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
        contacts[count++] = contact;
        return contact;
    }
    public static void editcontact(String firstname){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<count;i++){
            if(Objects.equals(contacts[i].getFirstname(), firstname)){
                System.out.println("Enter new first name: ");
                contacts[i].setFirstname(sc.next());
                System.out.println("Enter new lastname: ");
                contacts[i].setLastname(sc.next());
                System.out.println("Enter new address: ");
                contacts[i].setAddress(sc.next());
                System.out.println("Enter new city: ");
                contacts[i].setCity(sc.next());
                System.out.println("Enter new phone: ");
                contacts[i].setCity(sc.next());
                System.out.println("Contact updated successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
    public static void deletecontact(String firstname){
        boolean found =false;
        for(int i=0; i<count;i++){
            if(Objects.equals(contacts[i].getFirstname(), firstname)){
                for(int j=i; j<count-1; j++){
                    contacts[j] = contacts[j+1];
                }
                count--;
                System.out.println("Contact deleted successfully.");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("Contact not found.");
        }
    }
    public static void viewAllContacts() {
        if (count == 0) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("\nAll Contacts in the Address Book:");
            for (int i = 0; i < count; i++) {
                System.out.println(contacts[i]);
                System.out.println("-----------------------------");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Adding new contact:");
                    addcontact();
                    break;
                case 2:
                    System.out.print("Enter the first name of the contact you want to edit: ");
                    String editName = sc.nextLine();
                    editcontact(editName);
                    break;
                case 3:
                    System.out.print("Enter the first name of the contact you want to delete: ");
                    String deleteName = sc.nextLine();
                    deletecontact(deleteName);
                    break;
                case 4:
                    viewAllContacts();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
