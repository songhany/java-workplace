package hotelReservation.api;

// create the resource classes, so we can provide an intermediary between the UI components and services.
// Resource classes are used for defining the Application Programming Interface(API)


import hotelReservation.model.Customer;
import hotelReservation.model.IRoom;
import hotelReservation.model.Reservation;
import hotelReservation.service.CustomerService;
import hotelReservation.service.ReservationService;

import java.util.*;

public class HotelResource {
    public static final CustomerService customerService = new CustomerService();
    public static final ReservationService reservationService = new ReservationService();

    public static Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) {
        customerService.addCustomer(email, firstName, lastName);
        System.out.println("Hi " + firstName + ". Your account has been created !");
    }

    public static IRoom getRoom(String roomNumber) {
        return reservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservationService.reserveARoom(customerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservationService.getCustomerReservation(customerService.getCustomer(customerEmail));
    }

    public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return reservationService.findRooms(checkInDate, checkOutDate);
    }
}
