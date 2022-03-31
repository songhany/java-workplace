package hotelReservation.model;

public class Tester {
    public static void main(String[] args) {
        Customer customer = new Customer("John", "Doe", "j@domain.com");
        System.out.println(customer);

        Customer illegalCustomer = new Customer("first", "second", "email");
        System.out.println(illegalCustomer);
    }
}
