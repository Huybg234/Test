package entity;

import java.io.Serializable;
import java.util.Scanner;

public class Room implements Serializable {
    private int id;
    private String roomType;
    private float moneyLevel;
    private int roomNumber;

    public static final String SINGLE_ROOM = "Phòng đơn";
    public static final String DOUBLE_ROOM = "Phòng đôi";
    public static final String VIP_ROOM = "Phòng vip";
    private static int AUTO_ID = 100;

    public Room() {
    }

    public Room(int id, String roomType, float moneyLevel, int roomNumber) {
        this.id = id;
        this.roomType = roomType;
        this.moneyLevel = moneyLevel;
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getMoneyLevel() {
        return moneyLevel;
    }

    public void setMoneyLevel(float moneyLevel) {
        this.moneyLevel = moneyLevel;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public static String getSingleRoom() {
        return SINGLE_ROOM;
    }

    public static String getDoubleRoom() {
        return DOUBLE_ROOM;
    }

    public static String getVipRoom() {
        return VIP_ROOM;
    }

    public static int getAutoId() {
        return AUTO_ID;
    }

    public static void setAutoId(int autoId) {
        AUTO_ID = autoId;
    }

    public void importRoomInfo(){
        this.setId(Room.AUTO_ID);

        boolean check = true;
        System.out.println("Nhập mức tiền thuê: ");
        do {
            try {
                this.moneyLevel = new Scanner(System.in).nextFloat();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại");
                check = false;
                continue;
            }
            if (this.moneyLevel <= 0){
                System.out.println("Mức tiền thuê phải lớn hơn 0! Nhập lại");
                check = false;
            }
        }while (!check);
        System.out.println("Nhập số phòng hiện có: ");
        do {
            try {
                this.roomNumber = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại");
                check = false;
                continue;
            }
            if (this.roomNumber <= 0){
                System.out.println("Mức tiền thuê phải lớn hơn 0! Nhập lại");
                check = false;
            }
        }while (!check);
        System.out.println("Nhập kiểu phòng: ");
        System.out.println("1.Phòng đơn");
        System.out.println("2.Phòng đôi");
        System.out.println("3.Phòng VIP");
        System.out.println("Nhập sự lựa chọn của bạn:");
        do {
            int choice = 0;
            try {
                choice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                check = false;
                continue;
            }
            if (choice <= 0 || choice > 4) {
                System.out.print("Nhập số trong khoảng từ 1 đến 3! Nhập lại: ");
                check = false;
                continue;
            }
            switch (choice){
                case 1:
                    this.setRoomType(Room.SINGLE_ROOM);
                    check = true;
                    break;
                case 2:
                    this.setRoomType(Room.DOUBLE_ROOM);
                    check = true;
                    break;
                case 3:
                    this.setRoomType(Room.VIP_ROOM);
                    check = true;
                    break;
                default:
                    System.out.println("Nhập không hợp lệ! Nhập lại: ");
                    check = false;
                    break;
            }
        }while (!check);
        Room.AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", moneyLevel=" + moneyLevel +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
