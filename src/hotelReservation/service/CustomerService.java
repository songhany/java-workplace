package hotelReservation.service;

import hotelReservation.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerService {
    private static final List<Customer> customers = new ArrayList<>();

    public void addCustomer(String email, String firstName, String lastName) {
        Customer customer = new Customer(firstName, lastName, email);
        customers.add(customer);
    }

    public Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;  // customer not found with customerEmail
    }

    public Collection<Customer> getAllCustomers() {
        return customers;
    }
}
