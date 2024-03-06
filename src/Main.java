import java.util.*;
import java.util.stream.Collectors;

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
            System.out.println("5. Search Person in city across Address Book");
            System.out.println("6. View Persons by City");
            System.out.println("7. Count Contacts by City");
            System.out.println("8. Exit");
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
                    searchPersonInCityOrState(bookManagement);
                    break;
                case 6:
                    viewPersonsByCity(bookManagement);
                    break;
                case 7:
                    Map<String, Integer> contactCountByCity = countContactsByCity();
                    System.out.println("Number of contacts by city:");
                    for (Map.Entry<String, Integer> entry : contactCountByCity.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                case 8:
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

    public static void searchPersonInCityOrState(AddressBookManagement bookManagement) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        System.out.print("Enter city to search: ");
        String city = scanner.nextLine();

        List<Contact> matchingContacts = bookManagement.searchPersonInCityOrState(name, city);

        if (matchingContacts.isEmpty()) {
            System.out.println("No matching contacts found.");
        } else {
            System.out.println("Matching contacts:");
            for (Contact contact : matchingContacts) {
                System.out.println(contact);
            }
        }
    }

    public static void viewPersonsByCity(AddressBookManagement bookManagement) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city to view persons: ");
        String city = scanner.nextLine();

        // Retrieve all contacts from all address books
        List<Contact> allContacts = bookManagement.getAllContacts();

        // Use streams to filter contacts by city
        List<Contact> contactsInCity = allContacts.stream()
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        if (contactsInCity.isEmpty()) {
            System.out.println("No persons found in " + city + ".");
        } else {
            System.out.println("Persons in " + city + ":");
            contactsInCity.forEach(contact -> System.out.println(contact.getFirstname() + " " + contact.getLastname()));
        }
    }
    public static List<Contact> getAllContacts() {
        List<Contact> allContacts = new ArrayList<>();
        for (AddressBook addressBook : AddressBookManagement.addressBooks.values()) {
            allContacts.addAll(addressBook.getContacts());
        }
        return allContacts;
    }
    public static Map<String, Integer> countContactsByCity() {
        Map<String, Integer> contactCountByCity = new HashMap<>();
        List<Contact> allContacts =  getAllContacts();

        for (Contact contact : allContacts) {
            String city = contact.getCity();
            contactCountByCity.put(city, contactCountByCity.getOrDefault(city, 0) + 1);
        }

        return contactCountByCity;
    }

}