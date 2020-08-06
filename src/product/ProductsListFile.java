package product;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsListFile {


    void writeObjectFile(String PATH,List<ProductsList> productsLists) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(PATH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productsLists);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    List<ProductsList> readObjectFil(String PATH) {
        List<ProductsList> productsLists = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            productsLists = (List<ProductsList>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Ko có sản phẩm nào");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
            return productsLists;
        }

    }
