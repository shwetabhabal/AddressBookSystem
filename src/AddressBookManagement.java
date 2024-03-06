import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class AddressBookManagement {
    private Map<String, AddressBook> addressBooks;

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

    public void displayBook(){
        for(String name : addressBooks.keySet() ){
            System.out.println(name);
        }
    }
    public void removeAddressBook(String name) {
        addressBooks.remove(name);
        System.out.println("Address book '" + name + "' deleted successfully.");
    }
}