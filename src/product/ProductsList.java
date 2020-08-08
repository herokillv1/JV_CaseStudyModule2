package product;

import java.io.Serializable;

public class ProductsList implements Serializable {
    private int id;
    private String name;
    private String brand;
    private long price;
    private int amount;

    public ProductsList(){
    }

    public ProductsList(int id, int amount, String name, String brand, long price) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}

