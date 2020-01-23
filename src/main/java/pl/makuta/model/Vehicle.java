package pl.makuta.model;

import java.util.Date;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private int birth;
    private String regNumber;
    private Date nextService;
    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public Date getNextService() {
        return nextService;
    }

    public void setNextService(Date nextService) {
        this.nextService = nextService;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", birth=" + birth +
                ", regNumber='" + regNumber + '\'' +
                ", nextService=" + nextService +
                ", customerId=" + customerId +
                '}';
    }
}
