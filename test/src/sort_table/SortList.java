package sort_table;

import entity.Client;

import java.util.ArrayList;
import java.util.List;

public class SortList {
    private Client client;
    private List<RoomTable> roomTables = new ArrayList<>();

    public SortList() {
    }

    public SortList(Client client, List<RoomTable> roomTables) {
        this.client = client;
        this.roomTables = roomTables;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<RoomTable> getRoomTables() {
        return roomTables;
    }

    public void setRoomTables(List<RoomTable> roomTables) {
        this.roomTables = roomTables;
    }

    @Override
    public String toString() {
        return "SortList{" +
                "client=" + client +
                ", roomTables=" + roomTables +
                '}';
    }
}
