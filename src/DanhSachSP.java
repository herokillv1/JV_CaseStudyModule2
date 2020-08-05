import java.io.Serializable;

public class DanhSachSP implements Serializable {
    private int idSP;
    private String SoLuongSP;
    private String TenSP;
    private String HangSX;
    private String GiaSP;

    public DanhSachSP(){
    }

    public DanhSachSP(int idSP, String soLuongSP, String tenSP, String hangSX, String giaSP) {
        this.idSP = idSP;
        SoLuongSP = soLuongSP;
        TenSP = tenSP;
        HangSX = hangSX;
        GiaSP = giaSP;
    }

    public int getIdSP() {
        return idSP;
    }

    public void setIdSP(int idSP) {
        this.idSP = idSP;
    }

    public String getSoLuongSP() {
        return SoLuongSP;
    }

    public void setSoLuongSP(String soLuongSP) {
        SoLuongSP = soLuongSP;
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




}

