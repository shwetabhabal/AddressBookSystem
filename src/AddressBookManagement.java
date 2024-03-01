import java.util.HashMap;
import java.util.Map;

class AddressBookManagement {
    private Map<String, AddressBook> addressBooks;

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