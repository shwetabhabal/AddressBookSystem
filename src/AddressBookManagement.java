import java.util.*;
import java.util.stream.Collectors;

class AddressBookManagement {
    public static Map<String, AddressBook> addressBooks;

    public List<Contact> getAllContacts() {
        List<Contact> allContacts = new ArrayList<>();
        for (AddressBook addressBook : addressBooks.values()) {
            allContacts.addAll(addressBook.getContacts());
        }
        return allContacts;
    }

    public List<Contact> searchPersonInCityOrState(String name, String city) {
        return addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getName().equalsIgnoreCase(name)
                        && contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public AddressBookManagement() {
        addressBooks = new HashMap<>();
    }
    public void addAddressBook(String name) {
        addressBooks.put(name, new AddressBook());
        System.out.println("Address book '" + name + "' created successfully.");
    }

    public AddressBook getAddressBook(String name) {
        return addressBooks.get(name);
    }

//    public void displayBook() {
//        List<String> sortedNames = new ArrayList<>(addressBooks.keySet());
//        Collections.sort(sortedNames);
//
//        System.out.println("Address Books in Alphabetical Order:");
//        for (String name : sortedNames) {
//            System.out.println(name);
//        }
//    }
    //sort by city
    public void displayBook() {
        if (addressBooks.isEmpty()) {
            System.out.println("No address books available.");
            return;
        }

        System.out.println("Address Books sorted by city:");

        for (Map.Entry<String, AddressBook> entry : addressBooks.entrySet()) {
            String addressBookName = entry.getKey();
            AddressBook addressBook = entry.getValue();

            System.out.println("Address Book: " + addressBookName);


        }
    }
    public void removeAddressBook(String name) {
        addressBooks.remove(name);
        System.out.println("Address book '" + name + "' deleted successfully.");
    }
}