package admin;

import product.ProductManagement;
import user.UserManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminFeatures {
    public static Scanner sc = new Scanner(System.in);
    public void adminManager() {
        ProductManagement productManagement = new ProductManagement();
        UserManager userManager = new UserManager();
        boolean check = true;
        while (check) {
            int choice;
            System.out.println("Menu");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Sửa thông tin sản phẩm");
            System.out.println("4. Hiển thị danh sách SP");
            System.out.println("5. Lịch sửa bán hàng");
            System.out.println("6. Hiển thị tài khoản người dùng");
            System.out.println("0. Thoát");
            System.out.println("Nhập lựa chọn (Nhập số): ");

            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        try {
                            productManagement.add();
                            sc.nextLine();
                            System.out.println("Đã thêm xong");
                            System.out.println();
                        } catch (InputMismatchException e) {
                            System.err.println("Yêu cầu nhập số");
                            productManagement.editEx();
                        }
                        break;
                    case 2:
                        System.out.println("Chọn ID SP muốn xóa :");
                        sc.nextLine();
                        int id1 = sc.nextInt();
                        productManagement.delete(id1);
                        break;
                    case 3:
                        System.out.println("Chọn ID SP muốn sửa :");
                        sc.nextLine();
                        int id2 = sc.nextInt();
                        productManagement.edit(id2);

                        break;
                    case 4:
                        productManagement.sortByName();
                        System.out.println("Danh sách Sản Phẩm :");
                        productManagement.show();
                        break;
                    case 5:
                        sc.nextLine();
                        System.out.println("Nhập ngày muốn kiểm tra lịch sử :");
                        System.out.println("Ngày :");
                        String day = sc.nextLine();
                        System.out.println("Tháng :");
                        String month = sc.nextLine();
                        System.out.println("Năm :");
                        String year = sc.nextLine();
                        String time = day+"/"+month+"/"+year;
                        userManager.history(time);
                        break;
                    case 6:
                        System.out.println("Danh sách KH :");
                        userManager.show();
                        break;
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("Không có lựa chọn này");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập số");
                AdminFeatures.sc.nextLine();
            }

        }
    }

    public void checkAdmin(String account ,String pass){
        if (account.equals("admin")){
            if (pass.equals("*****")){
                adminManager();
            }else {
                System.out.println("Sai pass");
            }
        }else {
            System.out.println("Sai account");
        }
    }
}
