package admin;

import java.io.Serializable;

public class History implements Serializable {
    private String account;
    private int id;
    private String nameSP;
    private String brand;
    private long price;
    private int amount;

    public History(){
    }

    public History(String account, int id, String nameSP, String brand, long price, int amount) {
        this.account = account;
        this.id = id;
        this.nameSP = nameSP;
        this.brand = brand;
        this.price = price;
        this.amount = amount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
