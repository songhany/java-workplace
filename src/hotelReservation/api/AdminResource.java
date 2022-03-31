package hotelReservation.api;

import hotelReservation.model.*;
import hotelReservation.service.CustomerService;
import hotelReservation.service.ReservationService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    public static final CustomerService customerService = new CustomerService();
    public static final ReservationService reservationService = new ReservationService();

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public static void addRoom(List<IRoom> rooms) {
        for (IRoom aRoom: rooms) {
            reservationService.addRoom(aRoom, aRoom.getRoomNumber(), aRoom.getRoomPrice(), aRoom.getRoomType());
        }
        System.out.println("Your rooms has been added in AdminResource by addRoom(List<IRoom> rooms)");
    }

    public static Collection<IRoom> getAllRooms() {
        return reservationService.allRoom();
    }

    public static Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public void displayAllReservations() {  // print all reservation
        for (Reservation reservation : reservationService.getAllReservation()) {
            System.out.println(reservation);
        }
    }

    public static Collection<Reservation> getAllReservations() {
        return reservationService.getAllReservation();
    }
}
