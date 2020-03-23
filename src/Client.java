public class Client {
    private final String name;
    private final String phone;

    Client(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client customer = (Client) o;

        return getPhoneNumber().equals(customer.getPhoneNumber());
    }

    public int hashCode() {
        return getPhoneNumber().hashCode();
    }

    public String toString() {
        return "{"  + name +  ": "   +  phone + "}";
    }
}