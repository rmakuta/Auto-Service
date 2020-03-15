package pl.makuta.model;

import java.time.LocalDate;

public class Vehicle {
    private int id;
    private String model;
    private String brand;
    private LocalDate birth;
    private String regNumber;
    private LocalDate nextServiceDate;
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

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        if(birth == null){
            this.birth = null;
        } else {
            this.birth = LocalDate.parse(birth);
        }
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getNextServiceDate() {
        return nextServiceDate;
    }

    public void setNextServiceDate(String nextServiceDate) {
        if(nextServiceDate == null){
            this.nextServiceDate = null;
        } else {
            this.nextServiceDate = LocalDate.parse(nextServiceDate);
        }
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
                ", nextServiceDate='" + nextServiceDate + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
