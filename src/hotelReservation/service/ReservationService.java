package hotelReservation.service;

import hotelReservation.model.*;

import java.util.*;

public class ReservationService {
    Collection<IRoom> rooms = new HashSet<>();
    Collection<Reservation> reservations = new HashSet<>();  // create Collections to store and retrieve a Reservation

    public void addRoom(IRoom room, String roomNumber, Double price, RoomType roomType) {
        Room newRoom = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
        rooms.add(newRoom);
    }

    public IRoom getARoom(String roomId) {
        for (IRoom room: rooms) {
            if (roomId.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;  // don't find this roomNumber
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer.getFirstName(), room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        boolean found = false;
        List<IRoom> findAvailableRooms = new ArrayList<>();
        for(IRoom room : rooms) {
            for (Reservation reservation : reservations) {
                if ((Objects.equals(room.getRoomNumber(), reservation.getRoom().getRoomNumber())
                        && ((!checkInDate.after(reservation.getCheckInDate())
                        && !checkInDate.before(reservation.getCheckOutDate())) ||
                        (!checkOutDate.after(reservation.getCheckInDate()) &&
                                !checkInDate.before(reservation.getCheckOutDate())))) ||
                        (!reservation.getRoom().getRoomNumber().contains(room.getRoomNumber()))) {
                    findAvailableRooms.add(room);
                }
            }
        }

        System.out.println(findAvailableRooms);
        return findAvailableRooms;
    }

    public Collection<Reservation> getCustomerReservation(Customer customer) {
        List<Reservation> allCustomerReservations = new ArrayList<>();
        for (Reservation reservation: reservations) {
            if (reservation.getCustomer().equals(customer.getFirstName())) {
                allCustomerReservations.add(reservation);
            }
        }
        return allCustomerReservations;
    }

    public void printAllReservation() {
        System.out.println(reservations);
    }

    public Collection<Reservation> getAllReservation() {
        return reservations;
    }

    public Collection<IRoom> allRoom() {
        return rooms;
    }
}
