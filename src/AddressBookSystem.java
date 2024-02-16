import java.util.Objects;
import java.util.Scanner;
public class AddressBookSystem {
    static Contact contacts[]= new Contact[100];
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
            if(contacts[i].getFirstname()==firstname){
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Address Book");
        contacts[count++] = addcontact();
        System.out.println("enter name you want to edit: ");
        String editname= sc.next();
        editcontact(editname);
        System.out.println("All cantacts:");
        for (int i=0; i<count;i++){
            System.out.println(contacts[i]);
        }
        System.out.println("Enter name you want to delete: ");
        String deletename= sc.next();
        deletecontact(deletename);
    }
}
