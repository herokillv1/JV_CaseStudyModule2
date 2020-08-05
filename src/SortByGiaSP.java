import java.util.Comparator;

public class SortByGiaSP implements Comparator<DanhSachSP> {
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
}
