package user;

import admin.AdminProduct;
import readandwritefile.ReadAndWriteFile;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private static final String PATH = "TXT/fileUser.txt";
    public static Scanner sc = new Scanner(System.in);
    private List<InfomationUser> infomationUsers;
    private ReadAndWriteFile<InfomationUser> readAndWriteFile;
    AdminProduct adminManager = new AdminProduct();


    public void add(){
        infomationUsers.add(new InfomationUser("Hiệp",23,"0123456789","user","user"));
        readAndWriteFile.writeFile(PATH,infomationUsers);
    }

    public UserManager(){
        readAndWriteFile = new ReadAndWriteFile();
        infomationUsers = readAndWriteFile.readFile(PATH);
    }

    public void newAccount(){
        System.out.println("Nhập tên :");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi :");
        int age = setAge();
        sc.nextLine();
        System.out.println("Nhập số ĐT :");
        String phone = sc.nextLine();
        System.out.println("Nhập account :");
        String account = sc.nextLine();
        System.out.println("Nhập Pass :");
        String pass = sc.nextLine();
        checkAccount(account,pass);

        InfomationUser infomationUser = new InfomationUser(name,age,phone,account,pass);
        infomationUsers.add(infomationUser);
        readAndWriteFile.writeFile(PATH,infomationUsers);

    }
     public  void signin(){
         System.out.println("Nhập account :");
         String account1 = sc.nextLine();
         System.out.println("Nhập Pass :");
         String pass1 = sc.nextLine();
         checkSignin(account1,pass1);
     }

     public void checkSignin(String account,String pass){
        boolean check = true;
        for (int i=0;i<infomationUsers.size();i++){
            if (account.equals(infomationUsers.get(i).getAccount())&&pass.equals(infomationUsers.get(i).getPass())){
                check = false;
                adminManager.adminManager();
                break;
            }
        }
        if (check){
            System.out.println("Nhập sai");
        }
     }
    public void checkAccount(String account,String pass){
        boolean check = true;
        for (int i=0;i<infomationUsers.size();i++){
            if (account.equals(infomationUsers.get(i).getAccount())){
                check = false;
            }
        }
        if (check){
            System.out.println("Tạo account thành công");
        }else {
            System.out.println("Account đã tồn tai");
            newAccount();
        }
    }

    public int setAge() {
        while (true) {
            try {
                int age = sc.nextInt();
                if (age < 0 && age > 120) {
                    throw new NumberFormatException();
                }
                return age;
            } catch (NumberFormatException ex) {
                System.err.print("Không hợp lệ! Nhập lại tuổi : ");
            }
        }
    }
}
