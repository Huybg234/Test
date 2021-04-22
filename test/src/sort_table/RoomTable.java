package sort_table;

import entity.Room;

public class RoomTable {
    private Room room;
    private int roomTotal;
    private int day;

    public RoomTable(Room room, int roomTotal, int day) {
        this.room = room;
        this.roomTotal = roomTotal;
        this.day = day;
    }

    public RoomTable() {
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoomTotal() {
        return roomTotal;
    }

    public void setRoomTotal(int roomTotal) {
        this.roomTotal = roomTotal;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "room_table{" +
                "room=" + room +
                ", roomTotal=" + roomTotal +
                ", day=" + day +
                '}';
    }
}
