import entity.Client;
import entity.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Client> clientList = new ArrayList<>();
    private static List<Room> roomList = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
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
        }
    }

    public static int functionChoice() {
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
        for (int i = 0; i < clientList.size(); i++) {
            System.out.println("Thống kê cho khách hàng " + clientList.get(i).getName() + " :");
            System.out.println("Nhập loại phòng khách hàng muốn thuê: ");
           do {
               for (int j = 0; j < roomList.size(); j++) {
                   System.out.println("Nhập id phòng khách hàng muốn thuê: ");
                   int roomid = 0;
                   do {
                       try {
                           roomid = new Scanner(System.in).nextInt();
                           check = true;
                       } catch (Exception e) {
                           System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                           check = false;
                           continue;
                       }
                       if (roomid <= 0) {
                           System.out.print("Số lượng khách hàng không được nhỏ hơn 0! Nhập lại: ");
                           check = false;
                       }
                   } while (!check);
                   Room room = searchRoomID(roomid);
                   int roomAmount = 0;
                   if (room != null){
                       System.out.println("Nhập số lượng phòng khách hàng muốn thuê: ");
                       do {
                           try {
                               roomAmount = new Scanner(System.in).nextInt();
                               check = true;
                           } catch (Exception e) {
                               System.out.println("Không được nhập ký tự khác ngoài số! Nhập lại: ");
                               check = false;
                               continue;
                           }
                           if (roomAmount <= 0) {
                               System.out.print("Số lượng khách hàng không được nhỏ hơn 0! Nhập lại: ");
                               check = false;
                           }
                       } while (!check);
                       if (roomList.get(j).getRoomNumber() < roomAmount){
                           System.out.println("Không đủ số phòng! Nhập lại từ đầu nhé bạn");
                           check = false;
                           break;
                       }
                   }
                   else System.out.println("Không có id vừa nhập! Nhập lại: ");
               }
           }while (!check);
        }
    }

    public static Room searchRoomID(int id) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getId() == id) {
                return roomList.get(i);
            }
        }
        return null;
    }
}
