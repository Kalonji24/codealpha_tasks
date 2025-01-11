package hotelreservationsystem;

public class Reservation {
    String guestName;
    int roomNumber;
    int nights;
    double totalCost;

    public Reservation(String guestName, int roomNumber, int nights, double totalCost) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.nights = nights;
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + "\n" +
               "Room Number: " + roomNumber + "\n" +
               "Nights: " + nights + "\n" +
               "Total Cost: $" + totalCost + "\n";
    }
}