import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        DSSPManager dsspManager = new DSSPManager();


        dsspManager.show();
        while (true) {
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
                        dsspManager.add();
                        System.out.println("Đã thêm xong");
                        break;
                    case 2:
                        System.out.println("Chọn mã SP muốn xóa :");
                        sc.nextLine();
                        String id1 = sc.nextLine();
                        int idSP1 = Integer.parseInt(id1);
                        dsspManager.delete(idSP1);
                        break;
                    case 3:
                        System.out.println("Chọn mã SP muốn sửa :");
                        sc.nextLine();
                        String id2 = sc.nextLine();
                        int idSP2 = Integer.parseInt(id2);
                        dsspManager.edit(idSP2);
                        System.out.println("Danh sách Sản Phẩm sau khi sửa :");
                        dsspManager.show();

                        break;
                    case 4:
                        dsspManager.sortByTenSP();
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo tên :");
                        dsspManager.show();
                        break;
                    case 5:
                        dsspManager.sortByGiaSP();
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo giá :");
                        dsspManager.show();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("No choice!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Nhập số cơ mà ??:D??");
                break;
            }
        }
    }
}
