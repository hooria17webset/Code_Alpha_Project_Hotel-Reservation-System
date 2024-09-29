public class Reservation {
    private static int idCounter = 1;
    private int id;
    private Room room;
    private String customerName;
    private int nights;
    private double totalCost;
    private String paymentMethod;

    public Reservation(Room room, String customerName, int nights, double totalCost, String paymentMethod) {
        this.id = idCounter++;
        this.room = room;
        this.customerName = customerName;
        this.nights = nights;
        this.totalCost = totalCost;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + id + "\n" +
                "Customer Name: " + customerName + "\n" +
                "Room Number: " + room.getRoomNumber() + "\n" +
                "Room Type: " + room.getRoomType() + "\n" +
                "Nights: " + nights + "\n" +
                "Total Cost: $" + totalCost + "\n" +
                "Payment Method: " + paymentMethod;
    }
}
