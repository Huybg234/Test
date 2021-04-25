package sort_table;

import entity.Client;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class Sort {
    private Client client;
    private String roomType;
    private int roomTotal;
    private int day;

    public Sort() {
    }

    public Sort(Client client, String roomType, int roomTotal, int day) {
        this.client = client;
        this.roomType = roomType;
        this.roomTotal = roomTotal;
        this.day = day;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
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
        return "Sort{" +
                "client=" + client +
                ", roomType='" + roomType + '\'' +
                ", roomTotal=" + roomTotal +
                ", day=" + day +
                '}';
    }
}
