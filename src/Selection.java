import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Selection {
    public static void selection(DSSPManager dsspManager, List<DanhSachSP> danhSachSPS, Scanner sc) {
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
                        danhSachSPS.add(dsspManager.add1());
                        System.out.println("Đã thêm xong");
                        break;
                    case 2:
                        System.out.println("Chọn mã SP muốn xóa :");
                        sc.nextLine();
                        String id1 = sc.nextLine();

                        dsspManager.delete(danhSachSPS, id1);

                        break;
                    case 3:
                        System.out.println("Chọn mã SP muốn sửa :");
                        sc.nextLine();
                        String id2 = sc.nextLine();

                        dsspManager.edit(danhSachSPS, sc, id2);
                        System.out.println("Danh sách Sản Phẩm sau khi sửa :");
                        outPutDSSP(danhSachSPS);

                        break;
                    case 4:
                        danhSachSPS.sort(DanhSachSP::compareTo);
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo tên :");
                        outPutDSSP(danhSachSPS);
                        break;
                    case 5:
                        Collections.sort(danhSachSPS, dsspManager);
                        System.out.println("Danh sách Sản Phẩm sắp xếp theo giá :");
                        outPutDSSP(danhSachSPS);
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

    public static void outPutDSSP(List<DanhSachSP> danhSachSPS) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("| %3s", "");
        System.out.printf("%-7s  |  ", "Mã SP");
        System.out.printf("%12s", "");
        System.out.printf("%-18s  |  ", "Tên SP");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Hãng SX");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Giá SP");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        for (DanhSachSP danhSachSP : danhSachSPS) {
            System.out.printf("| %3s", "");
            System.out.printf("%-7s  |  ", danhSachSP.getMaSP());
            System.out.printf("%-30s  |  ", danhSachSP.getTenSP());
            System.out.printf("%-10s  |  ", danhSachSP.getHangSX());
            System.out.printf("%-10s  |  ", danhSachSP.getGiaSP());
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}
