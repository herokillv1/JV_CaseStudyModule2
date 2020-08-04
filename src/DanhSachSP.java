public class DanhSachSP implements Comparable<DanhSachSP> {
    private String MaSP;
    private String TenSP;
    private String HangSX;
    private String GiaSP;

    public DanhSachSP(){
    }

    public DanhSachSP(String maSP, String tenSP, String hangSX, String giaSP) {
        MaSP = maSP;
        TenSP = tenSP;
        HangSX = hangSX;
        GiaSP = giaSP;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getHangSX() {
        return HangSX;
    }

    public void setHangSX(String hangSX) {
        HangSX = hangSX;
    }

    public String getGiaSP() {
        return GiaSP;
    }

    public void setGiaSP(String giaSP) {
        GiaSP = giaSP;
    }

    @Override
    public String toString() {
        return this.MaSP+"."+this.TenSP+"-"+this.HangSX+" -> "+this.GiaSP+"vnđ";
    }

    @Override
    public int compareTo(DanhSachSP danhSachSP) {
        return this.getTenSP().compareTo(danhSachSP.getTenSP());
    }

}

