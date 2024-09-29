//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Room> rooms = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize room data
        initializeRooms();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservation Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewReservationDetails();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Initialize available rooms in the system
    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 50, true));
        rooms.add(new Room(102, "Double", 80, true));
        rooms.add(new Room(103, "Suite", 150, true));
        rooms.add(new Room(104, "Single", 50, false));
        rooms.add(new Room(105, "Double", 80, false));
    }

    // Search for available rooms based on room type
    private static void searchRooms() {
        System.out.print("Enter room type (Single, Double, Suite): ");
        String roomType = scanner.next();

        System.out.println("\nAvailable Rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                System.out.println(room);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available rooms of this type.");
        }
    }

    // Make a reservation
    private static void makeReservation() {
        System.out.print("Enter Room Number to reserve: ");
        int roomNumber = scanner.nextInt();

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            System.out.print("Enter your name: ");
            String customerName = scanner.next();

            System.out.print("Enter number of nights: ");
            int nights = scanner.nextInt();

            double totalCost = selectedRoom.getPricePerNight() * nights;
            System.out.println("Total cost: $" + totalCost);

            System.out.print("Enter payment method (Card/Cash): ");
            String paymentMethod = scanner.next();

            Reservation reservation = new Reservation(selectedRoom, customerName, nights, totalCost, paymentMethod);
            reservations.add(reservation);
            selectedRoom.setAvailable(false); // Mark the room as unavailable

            System.out.println("Reservation successful! Your booking ID is " + reservation.getId());
        } else {
            System.out.println("Room not available or invalid room number.");
        }
    }

    // View reservation details
    private static void viewReservationDetails() {
        System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();

        for (Reservation reservation : reservations) {
            if (reservation.getId() == bookingId) {
                System.out.println("\n--- Reservation Details ---");
                System.out.println(reservation);
                return;
            }
        }

        System.out.println("No reservation found with that ID.");
    }
}
