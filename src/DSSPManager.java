import java.util.Comparator;
import java.util.Scanner;

public class DSSPManager extends DanhSachSP implements Comparator<DanhSachSP> {
    @Override
    public int compare(DanhSachSP o1, DanhSachSP o2) {
        long x1 = Integer.parseInt(o1.getGiaSP());
        long x2 = Integer.parseInt(o2.getGiaSP());
        if(x1 > x2){
            return -1;
        }else if(o1.getGiaSP() == o2.getGiaSP()){
            return 0;
        }else{
            return 1;
        }
    }

    public DanhSachSP add1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mã SP mới : ");
        String maSP = sc.nextLine();
        System.out.println("Tên SP mới : ");
        String tenSP = sc.nextLine();
        System.out.println("Hãng sản xuất : ");
        String hangSX = sc.nextLine();
        System.out.println("Giá SP mới : ");
        String giaSP = sc.nextLine();

        DanhSachSP danhSachSP = new DanhSachSP(maSP,tenSP,hangSX,giaSP);
        return danhSachSP;
    }

}
