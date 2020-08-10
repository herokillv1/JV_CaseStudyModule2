package user;

import admin.History;
import product.ProductManagement;
import readandwritefile.ReadAndWriteFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private static final String PATH = "TXT/fileUser.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<InfomationUser> infomationUsers;
    private ReadAndWriteFile<InfomationUser> readAndWriteFile;
    ProductManagement productManagement = new ProductManagement();
    UserFeatures userFeatures = new UserFeatures();


    public UserManager() {
        readAndWriteFile = new ReadAndWriteFile();
        infomationUsers = readAndWriteFile.readFile(PATH);
    }


    public void newAccount() {
        System.out.println("Nhập tên :");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi :");
        int age = setAge();
        sc.nextLine();
        System.out.println("Nhập số ĐT :");
        String phone = sc.nextLine();
        System.out.println("Nhập account :");
        String account = checkAccount();
        System.out.println("Nhập Pass :");
        String pass = sc.nextLine();
        System.out.println("Tạo account thành công.");

        InfomationUser infomationUser = new InfomationUser(name, age, phone, account, pass);
        infomationUsers.add(infomationUser);
        readAndWriteFile.writeFile(PATH, infomationUsers);

    }

    public void signin() {
        System.out.println("Nhập account :");
        String account1 = sc.nextLine();
        System.out.println("Nhập Pass :");
        String pass1 = sc.nextLine();
        checkSignin(account1, pass1);
    }


    public void checkSignin(String account, String pass) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String time = simpleDateFormat.format(date.getTime());
        boolean check = true;
        for (int i = 0; i < infomationUsers.size(); i++) {
            if (account.equals(infomationUsers.get(i).getAccount()) && pass.equals(infomationUsers.get(i).getPass())) {
                check = false;
                userFeatures.userProduct(account, time);
                break;
            }
        }
        if (check) {
            System.out.println("Nhập sai");
        }
    }

    public String checkAccount() {
        String account = sc.nextLine();
        boolean check = true;
        for (int i = 0; i < infomationUsers.size(); i++) {
            if (account.equals(infomationUsers.get(i).getAccount())) {
                check = false;
            }
        }
        if (!check) {
            System.out.println("Account đã tồn tai");
            System.out.println("Nhập lại account :");
            checkAccount();
        }
        return account;
    }

    public int setAge() {
        int age = sc.nextInt();
        boolean check = true;
        while (check) {
            if (age <= 0 || age > 120) {
                System.out.println("Tuổi ko hợp lệ.");
                System.out.println("Nhập lại tuổi :");
                age = sc.nextInt();
            } else {
                check = false;
            }
        }
        return age;
    }

    public void editEx() {
        sc.nextLine();
    }

    public void show() {
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %10s", "");
        System.out.printf("%-17s  |  ", "Tên KH");
        System.out.printf("%3s", "");
        System.out.printf("%-7s  |  ", "Tuổi");
        System.out.printf("%5s", "");
        System.out.printf("%-10s  |  ", "Số ĐT");
        System.out.printf("%8s", "");
        System.out.printf("%-15s  |  ", "Account");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        for (InfomationUser infomationUser : infomationUsers) {
            System.out.printf("| %5s", "");
            System.out.printf("%-22s  |  ", infomationUser.getName());
            System.out.printf("%5s", "");
            System.out.printf("%-5d  |  ", infomationUser.getAge());
            System.out.printf("%-15s  |  ", infomationUser.getPhone());
            System.out.printf("%8s", "");
            System.out.printf("%-15s  |  ", infomationUser.getAccount());
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    public void history(String time) {
        boolean check = false;

        for (int i = 0; i < infomationUsers.size(); i++) {
            boolean check2 = false;
                for (History history : productManagement.getHistories()) {
                    if ((infomationUsers.get(i).getAccount()).equals(history.getAccount()) && time.equals(history.getTime())) {
                        check2 = true;
                    }
                }
            if (check2){
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("Hóa đơn số "+(i+1));
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.printf("| %1s", "");
                System.out.printf("%-4s  |  ", "ID SP");
                System.out.printf("%20s", "");
                System.out.printf("%-30s  |  ", "Tên SP");
                System.out.printf("%2s", "");
                System.out.printf("%-8s  |  ", "Hãng SX");
                System.out.printf("%6s", "");
                System.out.printf("%-12s  |  ", "Giá SP");
                System.out.printf("%3s", "");
                System.out.printf("%-7s  |  ", "SL SP");
                System.out.printf("%7s", "");
                System.out.printf("%-19s  |  ", "Ngày mua hàng");
                System.out.println();
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
            for (History history : productManagement.getHistories()) {
                if ((infomationUsers.get(i).getAccount()).equals(history.getAccount()) && time.equals(history.getTime())) {
                    check = true;
                    System.out.printf("| %3s", "");
                    System.out.printf("%-3d  |  ", history.getId());
                    System.out.printf("%-50s  |  ", history.getNameSP());
                    System.out.printf("%-10s  |  ", history.getBrand());
                    System.out.printf("%-18s  |  ", history.getPrice());
                    System.out.printf("%4s", "");
                    System.out.printf("%-6s  |  ", history.getAmount());
                    System.out.printf("%9s", "");
                    System.out.printf("%-17s  |  ", history.getTime());
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
                }
            }
            if (check) {
                System.out.println("Thông tin khách mua hàng :");
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("| %10s", "");
                System.out.printf("%-17s  |  ", "Tên KH");
                System.out.printf("%3s", "");
                System.out.printf("%-7s  |  ", "Tuổi");
                System.out.printf("%5s", "");
                System.out.printf("%-10s  |  ", "Số ĐT");
                System.out.printf("%8s", "");
                System.out.printf("%-15s  |  ", "Account");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------");
                System.out.printf("| %5s", "");
                System.out.printf("%-22s  |  ", infomationUsers.get(i).getName());
                System.out.printf("%5s", "");
                System.out.printf("%-5d  |  ", infomationUsers.get(i).getAge());
                System.out.printf("%-15s  |  ", infomationUsers.get(i).getPhone());
                System.out.printf("%8s", "");
                System.out.printf("%-15s  |  ", infomationUsers.get(i).getAccount());
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------");
                check = false;
            } else {
                System.out.println("Không có lịch sử mua hàng");
                break;
            }
            System.out.println();
        }
    }

}
