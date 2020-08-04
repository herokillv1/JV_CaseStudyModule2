import java.util.*;

public class Main {
    public static void main(String[] args) {
        DSSPManager dsspManager = new DSSPManager();
        List<DanhSachSP> danhSachSPS = new ArrayList<>();
        danhSachSPS.add(new DanhSachSP("0032", "Iphone 11 Pro Max", "Apple", "33990000"));
        danhSachSPS.add(new DanhSachSP("0001", "Vsmart Active 3", "Vsmart", "3990000"));
        danhSachSPS.add(new DanhSachSP("0019", "OPPO Find X2", "OPPO", "20990000"));
        danhSachSPS.add(new DanhSachSP("0096", "Xiaomi Mi Note 10 Pro", "Xiaomi", "13990000"));
        danhSachSPS.add(new DanhSachSP("0078", "Samsung Galaxy Note Mới 2", "Samsung", "30990000"));

        System.out.println("Danh sách Sản Phẩm :");
        outPutDSSP(danhSachSPS);

        Scanner sc = new Scanner(System.in);


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
                        System.out.println("Danh sách Sản Phẩm sau khi thêm :");
                        outPutDSSP(danhSachSPS);
                        break;
                    case 2:
                        System.out.println("Chọn mã SP muốn xóa :");
                        sc.nextLine();
                        String id1 = sc.nextLine();

                        for (int i = 0; i < danhSachSPS.size(); i++) {
                            if (id1.endsWith(danhSachSPS.get(i).getMaSP())) {
                                danhSachSPS.remove(i);
                            }
                        }
                        System.out.println("Danh sách Sản Phẩm sau khi xóa :");
                        outPutDSSP(danhSachSPS);

                        break;
                    case 3:
                        System.out.println("Chọn mã SP muốn sửa :");
                        sc.nextLine();
                        String id2 = sc.nextLine();

                        for (int i = 0; i < danhSachSPS.size(); i++) {
                            if (id2.equals(danhSachSPS.get(i).getMaSP())) {
                                System.out.println("Menu");
                                System.out.println("31. Sửa tên SP");
                                System.out.println("32. Sửa hãng SX");
                                System.out.println("33. Sửa giá SP");
                                System.out.println("30. Kết thúc sủa thông tin SP");
                                int choice1;
                                boolean run = true;
                                while (run) {
                                    choice1 = sc.nextInt();
                                    switch (choice1) {
                                        case 31:
                                            System.out.println("Sửa tên SP " + danhSachSPS.get(i).getTenSP() + " thành : ");
                                            sc.nextLine();
                                            String tenSP = sc.nextLine();
                                            DanhSachSP danhSachSP0 = new DanhSachSP(id2, tenSP, danhSachSPS.get(i).getHangSX(), danhSachSPS.get(i).getGiaSP());
                                            danhSachSPS.remove(i);
                                            danhSachSPS.add(danhSachSP0);
                                            System.out.println("Sản phẩm sau khi sửa tên :");
                                            System.out.printf("%5s  |  ", danhSachSP0.getMaSP());
                                            System.out.printf("%30s  |  ", danhSachSP0.getTenSP());
                                            System.out.printf("%10s  |  ", danhSachSP0.getHangSX());
                                            System.out.printf("%10s  |  ", danhSachSP0.getGiaSP());
                                            break;
                                        case 32:
                                            System.out.println("Sửa hãng SX " + danhSachSPS.get(i).getHangSX() + " thành : ");
                                            sc.nextLine();
                                            String hangSX = sc.nextLine();
                                            DanhSachSP danhSachSP1 = new DanhSachSP(id2, danhSachSPS.get(i).getTenSP(), hangSX, danhSachSPS.get(i).getGiaSP());
                                            danhSachSPS.remove(i);
                                            danhSachSPS.add(danhSachSP1);
                                            System.out.println("Sản phẩm sau khi sửa hãng SX :");
                                            System.out.printf("%5s  |  ", danhSachSP1.getMaSP());
                                            System.out.printf("%30s  |  ", danhSachSP1.getTenSP());
                                            System.out.printf("%10s  |  ", danhSachSP1.getHangSX());
                                            System.out.printf("%10s  |  ", danhSachSP1.getGiaSP());
                                            break;
                                        case 33:
                                            System.out.println("Sửa giá SP " + danhSachSPS.get(i).getGiaSP() + " thành : ");
                                            sc.nextLine();
                                            String giaSP = sc.nextLine();
                                            DanhSachSP danhSachSP2 = new DanhSachSP(id2, danhSachSPS.get(i).getTenSP(), danhSachSPS.get(i).getHangSX(), giaSP);
                                            danhSachSPS.remove(i);
                                            danhSachSPS.add(danhSachSP2);
                                            System.out.println("Sản phẩm sau khi sửa giá3 :");
                                            System.out.printf("%5s  |  ", danhSachSP2.getMaSP());
                                            System.out.printf("%30s  |  ", danhSachSP2.getTenSP());
                                            System.out.printf("%10s  |  ", danhSachSP2.getHangSX());
                                            System.out.printf("%10s  |  ", danhSachSP2.getGiaSP());
                                            break;
                                        case 30:
                                            run = false;
                                            break;
                                        default:
                                            System.out.println("No choice!");
                                    }
                                }
                            }
                        }
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
        for (DanhSachSP danhSachSP : danhSachSPS) {
            System.out.printf("%5s  |  ", danhSachSP.getMaSP());
            System.out.printf("%30s  |  ", danhSachSP.getTenSP());
            System.out.printf("%10s  |  ", danhSachSP.getHangSX());
            System.out.printf("%10s  |  ", danhSachSP.getGiaSP());
            System.out.println();
        }
    }
}
