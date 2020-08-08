package user;

import admin.AdminFeatures;
import product.ProductManagement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserFeatures {
    public static Scanner sc = new Scanner(System.in);
    public void userProduct(String account) {
        ProductManagement productManagement = new ProductManagement();
        boolean check = true;
        while (check) {
            int choice;
            System.out.println("Menu");
            System.out.println("1. Hiển thị sản phẩm theo tên");
            System.out.println("2. Hiển thị sản phẩm theo giá");
            System.out.println("3. Tìm kiếm sản phẩm");
            System.out.println("4. Mua sản phẩm");
            System.out.println("5. Lịch sử mua hàng");
            System.out.println("0. Exit");
            System.out.println("Enter your choice (ENTER NUMBER): ");

            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        productManagement.sortByName();
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo tên :");
                        productManagement.show();
                        break;
                    case 2:
                        productManagement.sortByPrice();
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo giá :");
                        productManagement.show();
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("Nhập ID sản phẩm muốn mua");
                        int id = sc.nextInt();
                        productManagement.buy(id,account);
                        System.out.println("Mua thành công");
                        break;
                    case 5:
                        System.out.println("Sản phẩm đã mua : ");
                        productManagement.historyBuy();
                        break;
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("No choice!");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập số");
                AdminFeatures.sc.nextLine();
            }

        }
    }
}
