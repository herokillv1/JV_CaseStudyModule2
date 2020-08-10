import admin.AdminManager;
import product.ProductManagement;
import user.UserManager;
import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();
        AdminManager adminManager = new AdminManager();
        UserManager userManager = new UserManager();

        boolean check = true;
        while (check){
            System.out.println("Menu");
            System.out.println("1.Quản lý");
            System.out.println("2.Người dùng");
            System.out.println("0.Thoát");
            System.out.println("Nhập lựa chọn (Nhập số): ");
            try {
                int choice = sc.nextInt();
                switch (choice){
                    case 1:
                        adminManager.adminManager();
                        break;
                    case 2:
                        boolean checkUser = true;
                        while (checkUser){
                            System.out.println("Menu");
                            System.out.println("1.Đăng kí");
                            System.out.println("2.Đăng nhập");
                            System.out.println("0.Thoát");
                            System.out.println("Nhập lựa chọn (Nhập số): ");
                            try {
                                int choice1 = sc.nextInt();
                                switch (choice1){
                                    case 1:
                                        try {
                                            userManager.newAccount();
                                        } catch (InputMismatchException e) {
                                            System.err.println("Tuổi phải nhập số.");
                                            userManager.editEx();
                                        }
                                        break;
                                    case 2:
                                        productManagement.deleteHistoryBuy();
                                        userManager.signin();
                                        break;
                                    case 0:
                                        checkUser = false;
                                        break;
                                    default:
                                        System.out.println("Không có lựa chọn này");
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
                        System.out.println("Không có lựa chọn này");
                }
            }catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập số");
                Main.sc.nextLine();
            }
        }

    }
}
