package user;

import java.io.Serializable;

public class InfomationUser implements Serializable {
    private String name;
    private int age;
    private String phone;
    private String account;
    private String pass;

    public  InfomationUser(){
    }

    public InfomationUser(String name, int age, String phone, String account, String pass) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.account = account;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
