import java.io.EOFException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DSSPManager dsspManager = new DSSPManager();
        Selection selections = new Selection();
        ObjectFile objectFile = new ObjectFile();
        List<DanhSachSP> danhSachSPS;
        danhSachSPS = dsspManager.addList();


//            try {
//                objectFile.writeObjectFile("TXT/fileDanhSachSanPham.txt",danhSachSPS);
//
//            } catch (EOFException ex){
//                System.out.println("");
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }


//        try {
//            danhSachSPS = objectFile.readObjectFil("TXT/fileDanhSachSanPham.txt");
//
//            for (DanhSachSP danhSachSP : danhSachSPS){
//                System.out.println(danhSachSP);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        System.out.println("Danh sách Sản Phẩm :");
        selections.outPutDSSP(danhSachSPS);


        Scanner sc = new Scanner(System.in);
        selections.selection(dsspManager, danhSachSPS, sc);
    }
}
