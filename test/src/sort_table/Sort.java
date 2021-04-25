package sort_table;

import entity.Client;
import entity.Room;

import java.util.List;

public class Sort {
    private Client client;
    private List<Room> rooms;
    private int roomTotal;
    private int day;

    public Sort() {
    }

    public Sort(Client client, List<Room> rooms, int roomTotal, int day) {
        this.client = client;
        this.rooms = rooms;
        this.roomTotal = roomTotal;
        this.day = day;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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
}
