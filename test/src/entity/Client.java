package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Client extends Person implements Serializable {
    private int id;
    private String roomTypeNeed;
    private int roomNumberNeed;

    private static int AUTO_ID = 100;

    public Client() {
    }

    public Client(int id, String roomType, int roomNumber) {
        this.id = id;
        this.roomTypeNeed = roomType;
        this.roomNumberNeed = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomTypeNeed() {
        return roomTypeNeed;
    }

    public void setRoomTypeNeed(String roomTypeNeed) {
        this.roomTypeNeed = roomTypeNeed;
    }

    public int getRoomNumberNeed() {
        return roomNumberNeed;
    }

    public void setRoomNumberNeed(int roomNumberNeed) {
        this.roomNumberNeed = roomNumberNeed;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

        @Override
    public void importInfo(){
        super.importInfo();

        this.setId(Client.AUTO_ID);
        System.out.println("Nhập kiểu phòng: ");
        this.roomTypeNeed = new Scanner(System.in).nextLine();
        System.out.println("Nhập số phòng cần thuê: ");
        boolean check = true;
        do {
            try {
                this.roomNumberNeed = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại");
                check = false;
                continue;
            }
            if (this.roomNumberNeed <= 0){
                System.out.println("Số phòng cần thuê phải lớn hơn 0! Nhập lại");
                check = false;
            }
        }while (!check);
        Client.AUTO_ID++;
    }

    @Override
    public String toString() {
        return super.toString() + "Client{" +
                "id=" + id +
                ", roomType='" + roomTypeNeed + '\'' +
                ", roomNumber=" + roomNumberNeed +
                '}';
    }
}
