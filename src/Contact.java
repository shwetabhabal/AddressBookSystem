public class Contact {
    String firstname;
    String lastname;
    String address;
    String city;
    int phone;

    public Contact() {
    }

    public Contact(String firstname, String lastname, String address, String city, int phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phone, String email) {
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }
    public String toString(){
        return "Contact : Name:"+firstname +" "+ lastname +" Address: " +address+" City:"+ city+ " phone:"+ phone;
    }

}