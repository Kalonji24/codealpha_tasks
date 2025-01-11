package hotelreservationsystem;

public class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}