package user;

import product.ProductsList;
import readandwritefile.ReadAndWriteFile;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private static final String PATH = "TXT/fileUser.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<InfomationUser> infomationUsers;
    private ReadAndWriteFile<InfomationUser> readAndWriteFile;
    UserProduct userProduct = new UserProduct();


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
        boolean check = true;
        for (int i = 0; i < infomationUsers.size(); i++) {
            if (account.equals(infomationUsers.get(i).getAccount()) && pass.equals(infomationUsers.get(i).getPass())) {
                check = false;
                userProduct.userProduct();
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
            account = sc.nextLine();
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
}
