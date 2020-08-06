import product.ProductManagement;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManagement productManagement = new ProductManagement();


        boolean check = true;
        productManagement.show();
        while (check) {
            int choice;
            System.out.println("Menu");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Sửa thông tin sản phẩm");
            System.out.println("4. Sắp xếp sản phẩm theo tên");
            System.out.println("5. Sắp xếp sản phẩm theo giá");
            System.out.println("0. Exit");
            System.out.println("Enter your choice (ENTER NUMBER): ");

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
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo tên :");
                        productManagement.show();
                        break;
                    case 5:
                        productManagement.sortByPrice();
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo giá :");
                        productManagement.show();
                        break;
                    case 0:
                        check = false;
                        break;
                    default:
                        System.out.println("No choice!");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Yêu cầu nhập số");
                Main.sc.nextLine();
            }

        }
    }
}
