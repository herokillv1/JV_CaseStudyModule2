package product;

import admin.History;
import readandwritefile.ReadAndWriteFile;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductManagement {

    private static final String PATH = "TXT/fileDanhSachSanPham.txt";
    private static final String PATHBUY = "TXT/fileHistoryBuy.txt";
    private static final String PATHHISTORY = "TXT/fileHistory.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<ProductsList> productsLists1;
    private List<ProductsList> productsLists2;
    private ReadAndWriteFile<ProductsList> readAndWriteFile;
    private List<History> histories;
    private ReadAndWriteFile<History> readAndWriteFileHistory;



    public ProductManagement() {
        readAndWriteFile = new ReadAndWriteFile();
        productsLists1 = readAndWriteFile.readFile(PATH);
        productsLists2 = readAndWriteFile.readFile(PATHBUY);
        readAndWriteFileHistory = new ReadAndWriteFile();
        histories = readAndWriteFileHistory.readFile(PATHHISTORY);
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

    public void edit(int id) {
        boolean isExisted = false;
        for (int i = 0; i < productsLists1.size(); i++) {
            if (id == (productsLists1.get(i).getId())) {
                isExisted = true;
                System.out.println("Menu");
                System.out.println("1. Sửa tên SP");
                System.out.println("2. Sửa hãng SX");
                System.out.println("3. Sửa giá SP");
                System.out.println("4. Sửa số lượng SP");
                System.out.println("0. Kết thúc sủa thông tin SP");
                int choice1;
                boolean run = true;
                while (run) {
                    choice1 = sc.nextInt();
                    switch (choice1) {
                        case 1:
                            System.out.println("Sửa tên SP " + productsLists1.get(i).getName() + " thành : ");
                            sc.nextLine();
                            String tenSP = sc.nextLine();
                            productsLists1.get(i).setName(tenSP);
                            System.out.println("Sản phẩm sau khi sửa tên :");
                            display(productsLists1.get(i));
                            break;
                        case 2:
                            System.out.println("Sửa hãng SX " + productsLists1.get(i).getBrand() + " thành : ");
                            sc.nextLine();
                            String hangSX = sc.nextLine();
                            productsLists1.get(i).setBrand(hangSX);
                            System.out.println("Sản phẩm sau khi sửa hãng SX :");
                            display(productsLists1.get(i));
                            break;
                        case 3:
                            System.out.println("Sửa giá SP " + productsLists1.get(i).getPrice() + " thành : ");
                            sc.nextLine();
                            long giaSP = sc.nextLong();
                            productsLists1.get(i).setPrice(giaSP);
                            System.out.println("Sản phẩm sau khi sửa giá :");
                            display(productsLists1.get(i));
                            break;
                        case 4:
                            System.out.println("Sửa số lượng SP " + productsLists1.get(i).getAmount() + " thành : ");
                            sc.nextLine();
                            int soLuongSP = sc.nextInt();
                            productsLists1.get(i).setAmount(soLuongSP);
                            System.out.println("Sản phẩm sau khi sửa số lượng :");
                            display(productsLists1.get(i));
                            break;
                        case 0:
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

    public void editEx() {
        sc.nextLine();
    }

    public void buy(int id,String account,String time) {
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
                        buy(id,account,time);
                        break;
                    }
                }else {
                    System.out.println("Số lượng không được nhở hơn 0.");
                    buy(id,account,time);
                    break;
                }
                ProductsList productsList = new ProductsList(productsLists1.get(i).getId(), amount, productsLists1.get(i).getName(), productsLists1.get(i).getBrand(),productsLists1.get(i).getPrice());
                History history = new History(time,account,productsLists1.get(i).getId(), productsLists1.get(i).getName(), productsLists1.get(i).getBrand(),productsLists1.get(i).getPrice(),amount);
                histories.add(history);
                productsLists2.add(productsList);
            }
        }
        if (!isExisted) {
            System.out.printf("Id = %d không tồn tại.\n", id);
        } else {
            readAndWriteFile.writeFile(PATHBUY, productsLists2);
            readAndWriteFileHistory.writeFile(PATHHISTORY,histories);
        }
    }

    public int setAmount(){
        while (true) {
            try {
                int amount = sc.nextInt();
                return amount;
            } catch (InputMismatchException ex) {
                System.out.print("Không hợp lệ! Nhập lại số lượng : \n");
                ProductManagement.sc.nextLine();
            }
        }
    }

    public void historyBuy(){
        show1();
    }

    public void deleteHistoryBuy(){
        productsLists2.removeAll(productsLists2);
        readAndWriteFile.writeFile(PATHBUY, productsLists2);
    }

    public boolean checkKey(String key , String input){
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    public void  searchProduct(String key){
        List<ProductsList> productsListsSearch = new ArrayList<>();
        Iterator<ProductsList> iterator = productsLists1.iterator();
        while (iterator.hasNext()){
            ProductsList productsList = iterator.next();
            if (checkKey(key,productsList.getName())){
                productsListsSearch.add(productsList);
            }
        }
        showSearch(productsListsSearch);
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

    public long sumPrice(){
        long sum = 0;
        for (ProductsList productsList : productsLists2) {
            sum += productsList.getPrice()*productsList.getAmount();
        }
        return sum;
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
        System.out.println("Tổng tiền phải trả : "+sumPrice()+"vnđ");
        System.out.println();
    }

    public void showSearch(List<ProductsList> productsListsSearch) {
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
        for (ProductsList productsList : productsListsSearch) {
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

    public List<History> getHistories(){
        return histories;
    }
}
