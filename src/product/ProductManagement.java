package product;

import readandwritefile.ReadAndWriteFile;
import java.util.*;

public class ProductManagement {

    private static final String PATH = "TXT/fileDanhSachSanPham.txt";
    private static final String PATH1 = "TXT/fileHistoryBuy.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<ProductsList> productsLists1;
    private List<ProductsList> productsLists2;
    private ReadAndWriteFile<ProductsList> readAndWriteFile;


    public ProductManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        productsLists1 = readAndWriteFile.readFile(PATH);
        productsLists2 = readAndWriteFile.readFile(PATH1);
    }


    public void add() {
        int idSP;
        int count = 0;
        for (int i = 0; i < productsLists1.size(); i++) {
            if (count < productsLists1.get(i).getId()) {
                count = productsLists1.get(i).getId();
            }
        }
        idSP = count + 1;

        System.out.println("Id SP = " + idSP);
        System.out.println("Tên SP mới : ");
        String name = sc.nextLine();
        int amount = (int) Math.round(Math.random() * 100);
        System.out.println("Hãng sản xuất : ");
        String brand = sc.nextLine();
        System.out.println("Giá SP mới : ");
        long price = sc.nextLong();
        sc.nextLine();

        ProductsList productsList = new ProductsList(idSP, amount, name, brand, price);
        productsLists1.add(productsList);
        readAndWriteFile.writeFile(PATH, productsLists1);
    }

    public void editEx() {
        sc.nextLine();
    }

    public void delete(int idSP) {
        ProductsList danhSachSP = null;

        for (int i = 0; i < productsLists1.size(); i++) {
            if (productsLists1.get(i).getId() == idSP) {
                danhSachSP = productsLists1.get(i);
                break;
            }
        }
        if (danhSachSP != null) {
            System.out.println("Đã xóa sản phẩm : " + danhSachSP.getName());
            System.out.println();
            productsLists1.remove(danhSachSP);
            readAndWriteFile.writeFile(PATH, productsLists1);
        } else {
            System.out.printf("Id = %d không tồn tại.\n", idSP);
        }
    }

    public void edit(int id) {
        boolean isExisted = false;
        for (int i = 0; i < productsLists1.size(); i++) {
            if (id == (productsLists1.get(i).getId())) {
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
                            System.out.println("Sửa tên SP " + productsLists1.get(i).getName() + " thành : ");
                            sc.nextLine();
                            String tenSP = sc.nextLine();
                            productsLists1.get(i).setName(tenSP);
                            System.out.println("Sản phẩm sau khi sửa tên :");
                            display(productsLists1.get(i));
                            break;
                        case 32:
                            System.out.println("Sửa hãng SX " + productsLists1.get(i).getBrand() + " thành : ");
                            sc.nextLine();
                            String hangSX = sc.nextLine();
                            productsLists1.get(i).setBrand(hangSX);
                            System.out.println("Sản phẩm sau khi sửa hãng SX :");
                            display(productsLists1.get(i));
                            break;
                        case 33:
                            System.out.println("Sửa giá SP " + productsLists1.get(i).getPrice() + " thành : ");
                            sc.nextLine();
                            long giaSP = sc.nextLong();
                            productsLists1.get(i).setPrice(giaSP);
                            System.out.println("Sản phẩm sau khi sửa giá :");
                            display(productsLists1.get(i));
                            break;
                        case 34:
                            System.out.println("Sửa số lượng SP " + productsLists1.get(i).getAmount() + " thành : ");
                            sc.nextLine();
                            int soLuongSP = sc.nextInt();
                            productsLists1.get(i).setAmount(soLuongSP);
                            System.out.println("Sản phẩm sau khi sửa số lượng :");
                            display(productsLists1.get(i));
                            break;
                        case 30:
                            System.out.println("Đã sủa xong.");
                            System.out.println();
                            sc.nextLine();
                            run = false;
                            break;
                        default:
                            System.out.println("No choice!");
                    }
                }
            }
        }
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n", id);
        } else {
            readAndWriteFile.writeFile(PATH, productsLists1);
        }
    }

    public void buy(int id) {
        boolean isExisted = false;
        for (int i = 0; i < productsLists1.size(); i++) {
            if (id == (productsLists1.get(i).getId())) {
                isExisted = true;
                System.out.println("Nhập số lượng muốn mua :");
                int amount = setAmount();
                if (amount>0){
                    if (amount<= productsLists1.get(i).getAmount()){
                        productsLists1.get(i).setAmount(productsLists1.get(i).getAmount()-amount);
                        readAndWriteFile.writeFile(PATH, productsLists1);
                    }else {
                        System.out.println("Hiện tại chỉ còn : "+ productsLists1.get(i).getAmount()+" SP");
                        buy(id);
                        break;
                    }
                }else {
                    System.out.println("Số lượng không được nhở hơn 0.");
                    buy(id);
                    break;
                }
                ProductsList productsList = new ProductsList(productsLists1.get(i).getId(), amount, productsLists1.get(i).getName(), productsLists1.get(i).getBrand(),productsLists1.get(i).getPrice());
                productsLists2.add(productsList);
            }
        }
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n", id);
        } else {
            readAndWriteFile.writeFile(PATH1, productsLists2);
        }
    }

    public int setAmount(){
        while (true) {
            try {
                int amount = sc.nextInt();
                return amount;
            } catch (NumberFormatException ex) {
                System.err.print("Không hợp lệ! Nhập lại số lượng : ");
            }
        }
    }

    public void historyBuy(){
        show1();
    }

    public void sortByName() {
        Collections.sort(productsLists1, new SortByName());
    }


    public void sortByPrice() {
        Collections.sort(productsLists1, new SortByPrice());
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
        for (ProductsList productsList : productsLists1) {
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

    public void show1() {
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
        for (ProductsList productsList : productsLists2) {
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
