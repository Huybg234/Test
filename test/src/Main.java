import entity.Client;
import entity.Room;
import sort_table.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Client> clientList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();
    private static List<Sort> sortList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        do {
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    createNewRoom();
                    printRoomInfo();
                    break;
                case 2:
                    createNewClient();
                    printClientInfo();
                    break;
                case 3:
                    sortTable();
                    break;
            }
        } while (true);
    }

    public static int functionChoice() {
        System.out.println("--------Quản lý phòng khách sạn---------");
        System.out.println("1.Nhập danh sách phòng");
        System.out.println("2.Nhập danh sách khách hàng");
        System.out.println("3.Nhập danh sách sắp xếp phòng cho mỗi khách hàng");
        System.out.println("4.Sắp xếp danh sách sắp xếp phòng");
        System.out.println("5.Tính toán và lập hóa đơn cho mỗi khách hàng");
        System.out.println("6.Thoát");
        System.out.println("Nhập sự lựa chọn của bạn: ");
        int functionChoice = 0;
        boolean check = true;
        do {
            try {
                functionChoice = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài chữ");
                check = false;
                continue;
            }
            if (functionChoice <= 0 || functionChoice > 6) {
                System.out.println("Nhập trong khoảng từ 1 đến 6! Nhập lại: ");
                check = false;
            } else break;
        } while (!check);
        return functionChoice;
    }

    public static void createNewRoom() {
        System.out.println("Nhập số lượng phòng muốn nhập: ");
        int allRoom = 0;
        boolean checkRoom = true;
        do {
            try {
                allRoom = new Scanner(System.in).nextInt();
                checkRoom = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                checkRoom = false;
                continue;
            }
            if (allRoom <= 0) {
                System.out.print("Số lượng phòng không được nhỏ hơn 0! Nhập lại: ");
                checkRoom = false;
            }
        } while (!checkRoom);

        for (int i = 0; i < allRoom; i++) {
            Room room = new Room();
            room.importRoomInfo();
            roomList.add(room);
        }
    }

    public static void printRoomInfo() {
        roomList.forEach(System.out::println);
    }

    public static void createNewClient() {
        System.out.println("Nhập số lượng khách hàng muốn nhập: ");
        int allClient = 0;
        boolean checkClient = true;
        do {
            try {
                allClient = new Scanner(System.in).nextInt();
                checkClient = true;
            } catch (Exception e) {
                System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                checkClient = false;
                continue;
            }
            if (allClient <= 0) {
                System.out.print("Số lượng khách hàng không được nhỏ hơn 0! Nhập lại: ");
                checkClient = false;
            }
        } while (!checkClient);

        for (int i = 0; i < allClient; i++) {
            Client client = new Client();
            client.importInfo();
            clientList.add(client);
        }
    }

    public static void printClientInfo() {
        clientList.forEach(System.out::println);
    }

    public static boolean isValidClientAndRoom() {
        return roomList != null && clientList != null && !roomList.isEmpty() && !clientList.isEmpty();
    }

    public static void sortTable() {
        boolean check = true;
        if (!isValidClientAndRoom()) {
            System.out.println("Bạn cần nhập khách hàng và phòng trước!");
            return;
        }
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("-----------Sắp xếp phòng cho khách hàng: " + clientList.get(i).getName() + "------------");
            System.out.println("Loại phòng khách hàng muốn thuê: " + clientList.get(i).getRoomTypeNeed());
            System.out.println("Số phòng khách hàng muốn thuê: " + clientList.get(i).getRoomNumberNeed());

            List<Room> roomType = new ArrayList<>();

            for (int j = 0; j < roomList.size(); j++) {
                if (roomList.get(j).getRoomType().equals(clientList.get(i).getRoomTypeNeed())) {
                    roomType.add(roomList.get(j));
                }
            }
            for (Room room : roomType) {
                System.out.println(room);
                if (clientList.get(i).getRoomNumberNeed() < roomType.get(0).getRoomNumber()) {
                    System.out.println("Nhập số lượng ngày khách hàng muốn thuê: ");
                    do {
                        int day;
                        try {
                            day = new Scanner(System.in).nextInt();
                            check = true;
                        } catch (Exception e) {
                            System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                            check = false;
                            continue;
                        }
                        if (day < 0) {
                            System.out.print("Số lượng ngày không được nhỏ hơn 0! Nhập lại: ");
                            check = false;
                        }
                    } while (!check);
                }
                else{
                    System.out.println("Số phòng không đủ! Chọn loại phòng khác: ");

                }
            }
        }
    }
}
