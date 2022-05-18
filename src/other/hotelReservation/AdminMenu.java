package other.hotelReservation;


import other.hotelReservation.api.AdminResource;
import other.hotelReservation.model.IRoom;
import other.hotelReservation.model.Room;
import other.hotelReservation.model.RoomType;

import java.util.Scanner;

import static other.hotelReservation.api.HotelResource.reservationService;

public class AdminMenu {
    public static int navigateToMainMenu = 6;
    public static Scanner input;
    private static AdminResource adminResource;

    public static void displayMenu() {
        System.out.println("———————— Admin Menu ————————");
        System.out.println("1 - See all Customers");
        System.out.println("2 - See all Rooms");
        System.out.println("3 - See all Reservations");
        System.out.println("4 - Add a Room");
        System.out.println("5 - Back to Main Menu");
    }

    public static void addANewHotelRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Room Number for the Room you add:");
        String roomID = scanner.next();
        System.out.println("Enter its Room Type 'SINGLE/DOUBLE'");
        RoomType roomType = RoomType.valueOf(String.valueOf(scanner.next()));
        System.out.println("Enter its Room Price per night");
        Double roomPrice = scanner.nextDouble();

        IRoom newHotelRoom = new Room(roomID, roomPrice, roomType);
        reservationService.addRoom(newHotelRoom, roomID, roomPrice, roomType);
    }

    public static void startAdmin() {
        input = new Scanner(System.in);
        int selection = 0;

        while (selection != navigateToMainMenu) {
            switch (selection) {
                case 1:
                    System.out.println("You requested All Customers");
                    System.out.println(AdminResource.getAllCustomers());
                    break;

                case 2:
                    System.out.println("You requested to view All Rooms");
                    System.out.println(AdminResource.getAllRooms());
                    break;
                case 3:
                    System.out.println("You requested to view All Reservations");
                    System.out.println(AdminResource.getAllReservations());
                    break;
                case 4:
                    System.out.println("Add a room to the Hotel Reservation System");
                    addANewHotelRoom();
                case 5:
                    System.out.println("You choose go to Main Menu");
                    MainMenu.mainMenu();
                    return;
            }
            displayMenu();
            selection = input.nextInt();
        }
    }

}
