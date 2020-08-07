import admin.AdminProduct;
import user.UserManager;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AdminProduct adminManagers = new AdminProduct();
        UserManager userManager = new UserManager();
        userManager.add();

        boolean check = true;
        while (check){
            System.out.println("Menu");
            System.out.println("1.Admin");
            System.out.println("2.User");
            System.out.println("0.Exit");
            System.out.println("Enter your choice (ENTER NUMBER): ");
            try {
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        break;
                    case 2:
                        boolean checkUser = true;
                        while (checkUser){
                            System.out.println("Menu");
                            System.out.println("1.Đăng kí");
                            System.out.println("2.Đăng nhập");
                            System.out.println("0.Exit");
                            System.out.println("Enter your choice (ENTER NUMBER): ");
                            try {
                                int choice1 = sc.nextInt();
                                switch (choice1){
                                    case 1:
                                        userManager.newAccount();
                                        break;
                                    case 2:
                                        userManager.signin();
                                        break;
                                    case 0:
                                        checkUser = false;
                                        break;
                                    default:
                                        System.out.println("No choice!");
                                }
                            }catch (InputMismatchException ex) {
                                System.err.println("Yêu cầu nhập số");
                                Main.sc.nextLine();
                            }
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
                Main.sc.nextLine();
            }
        }

//        adminManagers.adminManager();

    }
}
