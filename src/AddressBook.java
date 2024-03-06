import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AddressBook {
    private Map<String, Contact> contacts;

    public AddressBook() {
        contacts = new HashMap<>();
    }

    public void addContact(Contact contact) {
        //check if name already exist
        String fullName = contact.getFirstname() + " " + contact.getLastname();

        boolean contactExists = contacts.keySet().stream().anyMatch(key -> key.equals(fullName));
        if (contactExists) {
            System.out.println("Contact already exists.");
//            return;
        }
        else {
        contacts.put(contact.getFirstname(), contact);
        System.out.println("Contact added successfully.");
        }
    }

    public void displayContacts() {
        System.out.println("Contacts:");
        for (Contact contact : contacts.values()) {
            System.out.println("First Name: " + contact.getFirstname());
            System.out.println("Last Name: " + contact.getLastname());
            System.out.println("Address: "+contact.getAddress());
            System.out.println("City: "+contact.getCity());
            System.out.println("Phone: " + contact.getPhone());
            System.out.println();
        }
    }

    public void editContact(String name){
        Scanner sc = new Scanner(System.in);
        Contact cont = contacts.get(name);
        if(cont == null){
            System.out.println("Contact not found");
            return;
        }

        System.out.println("Enter new first name");
        cont.setFirstname(sc.nextLine());
        System.out.println("Enter new last name");
        cont.setLastname(sc.nextLine());
        System.out.println("Enter new address");
        cont.setAddress(sc.nextLine());
        System.out.println("Enter new city");
        cont.setAddress(sc.nextLine());
        System.out.println("Enter new phone");
        cont.setPhone(sc.nextInt());
    }

    public void deleteContact(String name) {
        if (contacts.remove(name) != null) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}