import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookManagement bookManagement = new AddressBookManagement();

        while (true) {
            System.out.println("\nAddress Book System Menu:");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Remove Address Book");
            System.out.println("4. Display all Address Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter address book name: ");
                    String addressBookName = scanner.nextLine();
                    bookManagement.addAddressBook(addressBookName);
                    break;
                case 2:
                    System.out.print("Enter address book name: ");
                    String selectedAddressBookName = scanner.nextLine();
                    AddressBook selectedAddressBook = bookManagement.getAddressBook(selectedAddressBookName);
                    if (selectedAddressBook != null) {
                        handleAddressBook(selectedAddressBook, scanner);
                    } else {
                        System.out.println("Address book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter address book name to remove: ");
                    String addressBookToRemove = scanner.nextLine();
                    bookManagement.removeAddressBook(addressBookToRemove);
                    break;
                case 4:
                    bookManagement.displayBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
    public static void handleAddressBook(AddressBook addressBook, Scanner scanner) {
        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter First name: ");
                    String firstname = scanner.nextLine();
                    System.out.print("Enter Last name: ");
                    String lastname = scanner.nextLine();
                    System.out.println("Enter Address");
                    String address = scanner.nextLine();
                    System.out.println("Enter city");
                    String city = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    int phone = scanner.nextInt();
                    addressBook.addContact(new Contact(firstname, lastname, address, city, phone));
                    break;
                case 2:
                    addressBook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter name to edit: ");
                    String editName = scanner.nextLine();
                    addressBook.editContact(editName);
                    break;
                case 4:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContact(deleteName);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}