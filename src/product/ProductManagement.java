package product;

import readandwritefile.ReadAndWriteFile;

import java.util.*;

public class ProductManagement {

    private static final String PATH = "TXT/fileDanhSachSanPham.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<ProductsList> productsLists;
    private ReadAndWriteFile<ProductsList> readAndWriteFile;


    public ProductManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        productsLists = readAndWriteFile.readFile(PATH);
    }


    public void add() {
        int idSP;
        int count =0;
        for (int i =0 ; i<productsLists.size();i++){
            if (count<productsLists.get(i).getId()){
                count = productsLists.get(i).getId();
            }
        }
        idSP = count+1;

        System.out.println("Id SP = " + idSP);
        System.out.println("Tên SP mới : ");
        String name = sc.nextLine();
        System.out.println("Hãng sản xuất : ");
        String brand = sc.nextLine();
        System.out.println("Giá SP mới : ");
        long price = sc.nextLong();
        sc.nextLine();

        ProductsList productsList = new ProductsList(idSP, 100, name, brand, price);
        productsLists.add(productsList);
        readAndWriteFile.writeFile(PATH, productsLists);
    }

    public void editEx() {
        sc.nextLine();
    }

    public void delete(int idSP) {
        ProductsList danhSachSP = null;

        for (int i = 0; i < productsLists.size(); i++) {
            if (productsLists.get(i).getId() == idSP) {
                danhSachSP = productsLists.get(i);
                break;
            }
        }
        if (danhSachSP != null) {
            System.out.println("Đã xóa sản phẩm : " + danhSachSP.getName());
            System.out.println();
            productsLists.remove(danhSachSP);
            readAndWriteFile.writeFile(PATH, productsLists);
        } else {
            System.out.printf("Id = %d không tồn tại.\n", idSP);
        }
    }

    public void edit(int id) {
        boolean isExisted = false;
        for (int i = 0; i < productsLists.size(); i++) {
            if (id == (productsLists.get(i).getId())) {
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
                            System.out.println("Sửa tên SP " + productsLists.get(i).getName() + " thành : ");
                            sc.nextLine();
                            String tenSP = sc.nextLine();
                            productsLists.get(i).setName(tenSP);
                            System.out.println("Sản phẩm sau khi sửa tên :");
                            display(productsLists.get(i));
                            break;
                        case 32:
                            System.out.println("Sửa hãng SX " + productsLists.get(i).getBrand() + " thành : ");
                            sc.nextLine();
                            String hangSX = sc.nextLine();
                            productsLists.get(i).setBrand(hangSX);
                            System.out.println("Sản phẩm sau khi sửa hãng SX :");
                            display(productsLists.get(i));
                            break;
                        case 33:
                            System.out.println("Sửa giá SP " + productsLists.get(i).getPrice() + " thành : ");
                            sc.nextLine();
                            long giaSP = sc.nextLong();
                            productsLists.get(i).setPrice(giaSP);
                            System.out.println("Sản phẩm sau khi sửa giá :");
                            display(productsLists.get(i));
                            break;
                        case 34:
                            System.out.println("Sửa số lượng SP " + productsLists.get(i).getAmount() + " thành : ");
                            sc.nextLine();
                            int soLuongSP = sc.nextInt();
                            productsLists.get(i).setAmount(soLuongSP);
                            System.out.println("Sản phẩm sau khi sửa số lượng :");
                            display(productsLists.get(i));
                            break;
                        case 30:
                            System.out.println("Đã sủa xong.");
                            System.out.println();
                            run = false;
                            break;
                        default:
                            System.out.println("No choice!");
                    }
                }
            }
        }
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n",id);
        } else {
            readAndWriteFile.writeFile(PATH, productsLists);
        }
    }

    public void buy(){

    }

    public void sortByName() {
        Collections.sort(productsLists, new SortByName());
    }


    public void sortByPrice() {
        Collections.sort(productsLists, new SortByPrice());
    }

    public void display(ProductsList productsList) {
        System.out.printf("| %3s", "");
        System.out.printf("%-3d  |  ", productsList.getId());
        System.out.printf("%-34s  |  ", productsList.getName());
        System.out.printf("%-10s  |  ", productsList.getBrand());
        System.out.printf("%-10s  |  ", productsList.getPrice());
        System.out.printf("%3s", "");
        System.out.printf("%-7s  |  ", productsList.getAmount());
        System.out.println();
    }

    public void show() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %1s", "");
        System.out.printf("%-4s  |  ", "ID SP");
        System.out.printf("%20s", "");
        System.out.printf("%-30s  |  ", "Tên SP");
        System.out.printf("%2s", "");
        System.out.printf("%-8s  |  ", "Hãng SX");
        System.out.printf("%6s", "");
        System.out.printf("%-12s  |  ", "Giá SP");
        System.out.printf("%3s", "");
        System.out.printf("%-7s  |  ", "SL SP");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        for (ProductsList productsList : productsLists) {
            System.out.printf("| %3s", "");
            System.out.printf("%-3d  |  ", productsList.getId());
            System.out.printf("%-50s  |  ", productsList.getName());
            System.out.printf("%-10s  |  ", productsList.getBrand());
            System.out.printf("%-18s  |  ", productsList.getPrice());
            System.out.printf("%3s", "");
            System.out.printf("%-7s  |  ", productsList.getAmount());
            System.out.println();
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        }
    }
}
