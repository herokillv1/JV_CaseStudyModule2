import java.util.Comparator;

public class SortByTenSP implements Comparator<DanhSachSP> {
    @Override
    public int compare(DanhSachSP o1, DanhSachSP o2) {
        return o1.getTenSP().compareTo(o2.getTenSP());
    }
}
