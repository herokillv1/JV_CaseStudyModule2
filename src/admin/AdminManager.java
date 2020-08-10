package admin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminManager {

    public static Scanner sc = new Scanner(System.in);

    public void adminManager(){

        AdminFeatures adminFeatures = new AdminFeatures();

        boolean check = true;
        while (check){
            System.out.println("Menu");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Lấy lại tài khoản quản lý");
            System.out.println("0.Thoát");
            System.out.println("Nhập lựa chọn (Nhập số): ");
            try {
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("<- Đăng nhập ->");
                        sc.nextLine();
                        System.out.println("Account :");
                        String account = sc.nextLine();
                        System.out.println("Pass :");
                        String pass = sc.nextLine();
                        adminFeatures.checkAdmin(account,pass);
                        break;
                    case 2:
                        System.out.println("Câu hỏi bí mật :");
                        System.out.println("Tên của 1 dân chơi trong lớp ?");
                        sc.nextLine();
                        String name = sc.nextLine();
                        if (name.equals("Đào Rich Hiệp")){
                            System.out.println("Account : admin");
                            System.out.println("Pass : admin");
                        }else {
                            System.out.println("Câu trả lời ko đúng.");
                        }
                        break;
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("No choice!");
                }
            }catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập số");
                AdminManager.sc.nextLine();
            }
        }
    }
}
