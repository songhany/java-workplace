package other.hotelReservation;

import other.hotelReservation.api.HotelResource;
import other.hotelReservation.model.Customer;
import other.hotelReservation.model.IRoom;
import other.hotelReservation.service.CustomerService;
import other.hotelReservation.service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    private  static final CustomerService customerService = new CustomerService();
    private  static final ReservationService reservationService = new ReservationService();
    public static int exitApp = 5;
    public static Scanner input;

    public static void displayMenu() {
        System.out.println("—————— Welcome to Songhan's Hotels! Choose an option below. ——————");
        System.out.println("1 - Find and reserve a room");
        System.out.println("2 - See my reservations");
        System.out.println("3 - Create an account");
        System.out.println("4 - Admin");
        System.out.println("5 - Exit");
    }

    private static void viewMyReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("For checking all your reservations, Please enter your Customer mail: ");
        String email = scanner.next();
        System.out.println(HotelResource.getCustomerReservations(email));
    }

    public static Customer createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Customer Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Customer Email:");
        String email = scanner.next();

        HotelResource.createACustomer(email, firstName, lastName);
        return new Customer(firstName, lastName, email);
    }

    public static void findAndReserveARoom() {
        Date checkOutDate = new Date();
        Date checkInDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        // Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Check In date in MM/DD/YYYY format");
        String checkInString = scanner.next();
        // Converting dates
        try {
            checkInDate = formatter.parse(checkInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter your Check Out date in MM/DD/YYYY format");
        String checkOutString = scanner.next();
        try {
            checkOutDate = formatter.parse(checkOutString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Find available rooms
        System.out.println("All Available Hotel Rooms for your Days of Travel");
        System.out.println(HotelResource.findARoom(checkInDate, checkOutDate));

        System.out.println("Enter room number: ");
        String roomNumber = scanner.next();
        IRoom room = HotelResource.getRoom(roomNumber);
        System.out.println(room);
        System.out.println(roomNumber);

        System.out.println("Enter customer email: ");
        String email = scanner.next();

        HotelResource.bookARoom(email, room, checkInDate, checkOutDate);
        System.out.println(email + " " + room + " " + checkInDate + " " + checkOutDate);
        System.out.println("Your Reservation has finished");
    }

    public static void mainMenu() {
        displayMenu();
        input = new Scanner(System.in);
        int selection = input.nextInt();

        while (selection != exitApp) {
            switch (selection) {
                case 1:
                    // find and reserve a room
                    System.out.println("You choose to make a new Reservation");
                    findAndReserveARoom();
                    break;
                case 2:
                    //Views the customers current reservations
                    System.out.println("You choose to view your Reservations");
                    viewMyReservation();
                    break;
                case 3:
                    //creates a user account
                    System.out.println("You choose to create a new Account");
                    createAccount();
                    break;
                case 4:
                    //switches to admin menu
                    System.out.println("You choose to view Admin Menu");
                    AdminMenu.startAdmin();
                    return;
                case 5:
                    //closes console
                    input.close();
                    System.exit(0);
                default:
                    //User inputs an unexpected choice
                    System.out.println("Incorrect Input");
                    break;
            }
            displayMenu();
            selection = input.nextInt();
        }
    }
}
