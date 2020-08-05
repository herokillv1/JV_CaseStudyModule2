import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DSSPManager extends DanhSachSP implements Comparator<DanhSachSP> {

    public static List<DanhSachSP> addList() {
        List<DanhSachSP> danhSachSPS = new ArrayList<>();
        danhSachSPS.add(new DanhSachSP("0032", "Iphone 11 Pro Max", "Apple", "33990000"));
        danhSachSPS.add(new DanhSachSP("0001", "Vsmart Active 3", "Vsmart", "3990000"));
        danhSachSPS.add(new DanhSachSP("0019", "OPPO Find X2", "OPPO", "20990000"));
        danhSachSPS.add(new DanhSachSP("0096", "Xiaomi Mi Note 10 Pro", "Xiaomi", "13990000"));
        danhSachSPS.add(new DanhSachSP("0078", "Samsung Galaxy Note Mới 2", "Samsung", "30990000"));
        return danhSachSPS;
    }

    @Override
    public int compare(DanhSachSP o1, DanhSachSP o2) {
        long x1 = Integer.parseInt(o1.getGiaSP());
        long x2 = Integer.parseInt(o2.getGiaSP());
        if (x1 > x2) {
            return -1;
        } else if (o1.getGiaSP() == o2.getGiaSP()) {
            return 0;
        } else {
            return 1;
        }
    }

    public DanhSachSP add1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Mã SP mới (Nhập 4 số) : ");
        String maSP = sc.nextLine();
        System.out.println("Tên SP mới : ");
        String tenSP = sc.nextLine();
        System.out.println("Hãng sản xuất : ");
        String hangSX = sc.nextLine();
        System.out.println("Giá SP mới : ");
        String giaSP = sc.nextLine();

        DanhSachSP danhSachSP = new DanhSachSP(maSP, tenSP, hangSX, giaSP);
        return danhSachSP;
    }

    public static void delete(List<DanhSachSP> danhSachSPS, String id1) {
        for (int i = 0; i < danhSachSPS.size(); i++) {
            if (id1.endsWith(danhSachSPS.get(i).getMaSP())) {
                System.out.println("Đã xóa SP : " + danhSachSPS.get(i).getTenSP());
                danhSachSPS.remove(i);
            }
        }
    }

    public static void edit(List<DanhSachSP> danhSachSPS, Scanner sc, String id2) {
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
                            danhSachSPS.get(i).setTenSP(tenSP);
                            System.out.println("Sản phẩm sau khi sửa tên :");
                            display(danhSachSPS.get(i));
                            break;
                        case 32:
                            System.out.println("Sửa hãng SX " + danhSachSPS.get(i).getHangSX() + " thành : ");
                            sc.nextLine();
                            String hangSX = sc.nextLine();
                            danhSachSPS.get(i).setHangSX(hangSX);
                            System.out.println("Sản phẩm sau khi sửa hãng SX :");
                            display(danhSachSPS.get(i));
                            break;
                        case 33:
                            System.out.println("Sửa giá SP " + danhSachSPS.get(i).getGiaSP() + " thành : ");
                            sc.nextLine();
                            String giaSP = sc.nextLine();
                            danhSachSPS.get(i).setGiaSP(giaSP);
                            System.out.println("Sản phẩm sau khi sửa giá :");
                            display(danhSachSPS.get(i));
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
    }

    public static void display(DanhSachSP danhSachSP) {
        System.out.printf("%5s  |  ", danhSachSP.getMaSP());
        System.out.printf("%30s  |  ", danhSachSP.getTenSP());
        System.out.printf("%10s  |  ", danhSachSP.getHangSX());
        System.out.printf("%10s  |  ", danhSachSP.getGiaSP());
    }


}
