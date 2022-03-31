package hotelReservation.model;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, Double price, RoomType roomType) {
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public String toString() {
        return "Room Number " + getRoomNumber() + " is a " + getRoomType() + "which is FREE room and now is available!";
    }
}
