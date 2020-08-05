import java.io.*;
import java.util.List;

public class ObjectFile {

    void writeObjectFile(String path, List<DanhSachSP> danhSachSPS) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(danhSachSPS);
        objectOutputStream.close();
    }

    List<DanhSachSP> readObjectFil(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<DanhSachSP> danhSachSPS;
        danhSachSPS = (List<DanhSachSP>) objectInputStream.readObject();
        objectInputStream.close();
        return danhSachSPS;
    }
}
