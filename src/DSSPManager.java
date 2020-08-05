import java.util.*;

public class DSSPManager {

    public static Scanner sc = new Scanner(System.in);
    private List<DanhSachSP> danhSachSPS;
    private DSSPFile dsspFile;


    public DSSPManager() {
        dsspFile = new DSSPFile();
        danhSachSPS = dsspFile.readObjectFil();
    }



    public void add() {
        int idSP = danhSachSPS.size();
        if (idSP > 0) {
            idSP += 1;
        } else {
            idSP = 1;
        }
        System.out.println("Id SP = " + idSP);
        System.out.println("Số lượng SP : ");
        String maSP = sc.nextLine();
        System.out.println("Tên SP mới : ");
        String tenSP = sc.nextLine();
        System.out.println("Hãng sản xuất : ");
        String hangSX = sc.nextLine();
        System.out.println("Giá SP mới : ");
        String giaSP = sc.nextLine();

        DanhSachSP danhSachSP = new DanhSachSP(idSP, maSP, tenSP, hangSX, giaSP);
        danhSachSPS.add(danhSachSP);
        dsspFile.writeObjectFile(danhSachSPS);
    }

    public void delete(int idSP) {
        DanhSachSP danhSachSP = null;

        for (int i = 0; i < danhSachSPS.size(); i++) {
            if (danhSachSPS.get(i).getIdSP() == idSP) {
                danhSachSP = danhSachSPS.get(i);
                break;
            }
        }
        if (danhSachSP != null) {
            danhSachSPS.remove(danhSachSP);
            dsspFile.writeObjectFile(danhSachSPS);
        } else {
            System.out.printf("Id = %d không tồn tại.\n", idSP);
        }
    }

    public void edit(int idSP) {
        boolean isExisted = false;
        String idSPString = String.valueOf(idSP);
        for (int i = 0; i < danhSachSPS.size(); i++) {
            if (idSPString.equals(danhSachSPS.get(i).getIdSP())) {
                isExisted = true;
                System.out.println("Menu");
                System.out.println("31. Sửa tên SP");
                System.out.println("32. Sửa hãng SX");
                System.out.println("33. Sửa giá SP");
                System.out.println("34. Sửa số lượng SP");
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
                        case 34:
                            System.out.println("Sửa số lượng SP " + danhSachSPS.get(i).getSoLuongSP() + " thành : ");
                            sc.nextLine();
                            String soLuongSP = sc.nextLine();
                            danhSachSPS.get(i).setSoLuongSP(soLuongSP);
                            System.out.println("Sản phẩm sau khi sửa số lượng :");
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
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n", idSP);
        } else {
            dsspFile.writeObjectFile(danhSachSPS);
        }
    }

    public void sortByTenSP() {
        Collections.sort(danhSachSPS, new SortByTenSP());
    }


    public void sortByGiaSP() {
        Collections.sort(danhSachSPS, new SortByGiaSP());
    }

    public void display(DanhSachSP danhSachSP) {
        System.out.printf("%5s  |  ", danhSachSP.getSoLuongSP());
        System.out.printf("%30s  |  ", danhSachSP.getTenSP());
        System.out.printf("%10s  |  ", danhSachSP.getHangSX());
        System.out.printf("%10s  |  ", danhSachSP.getGiaSP());
    }

    public void show() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("| %1s", "");
        System.out.printf("%-4s  |  ", "ID SP");
        System.out.printf("%12s", "");
        System.out.printf("%-18s  |  ", "Tên SP");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Hãng SX");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Giá SP");
        System.out.printf("%3s", "");
        System.out.printf("%-7s  |  ", "SL SP");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------");
        for (DanhSachSP danhSachSP : danhSachSPS) {
            System.out.printf("| %1s", "");
            System.out.printf("%-5d  |  ", danhSachSP.getIdSP());
            System.out.printf("%-30s  |  ", danhSachSP.getTenSP());
            System.out.printf("%-10s  |  ", danhSachSP.getHangSX());
            System.out.printf("%-10s  |  ", danhSachSP.getGiaSP());
            System.out.printf("%3s", "");
            System.out.printf("%-7s  |  ", danhSachSP.getSoLuongSP());
            System.out.println();
            System.out.println("-------------------------------------------------------------------------------------------");
        }
    }
}
