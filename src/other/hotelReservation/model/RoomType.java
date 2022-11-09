package other.hotelReservation.model;

public enum RoomType{  // different room type
    SINGLE, DOUBLE;

    public static RoomType lookup(String id) {
        try {
            return RoomType.valueOf(id);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("RoomType must be upper case: 'SINGLE' or 'DOUBLE" + id);
        }
    }
}
