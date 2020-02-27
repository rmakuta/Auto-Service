package pl.makuta.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private int id;
    private String addDate;
    private String repairPlannedDate;
    private String repairDate;
    private int employeeId;
    private String problemDescription;
    private String repairDescription;
    private enum status {ADDED, ACCEPTED, IN_PROGRES, READY, DELETED, ENDED};
    private int vehicleId;
    private double repairCost;
    private double carPartsCost;
    private double manHourCost;
    private int manHourQuantity;

    public Order() {
        setAdoptionDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public void setAdoptionDate(){
        LocalDateTime createdDateTime = LocalDateTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.addDate = createdDateTime.format(pattern);
    }

    public String getRepairPlannedDate() {
        return repairPlannedDate;
    }

    public void setRepairPlannedDate(String repairPlannedDate) {
        this.repairPlannedDate = repairPlannedDate;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public double getCarPartsCost() {
        return carPartsCost;
    }

    public void setCarPartsCost(double carPartsCost) {
        this.carPartsCost = carPartsCost;
    }

    public double getManHourCost() {
        return manHourCost;
    }

    public void setManHourCost(double manHourCost) {
        this.manHourCost = manHourCost;
    }

    public int getManHourQuantity() {
        return manHourQuantity;
    }

    public void setManHourQuantity(int manHourQuantity) {
        this.manHourQuantity = manHourQuantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", addDate='" + addDate + '\'' +
                ", repairPlannedDate='" + repairPlannedDate + '\'' +
                ", repairDate='" + repairDate + '\'' +
                ", employeeId=" + employeeId +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", vehicleId=" + vehicleId +
                ", repairCost=" + repairCost +
                ", carPartsCost=" + carPartsCost +
                ", manHourCost=" + manHourCost +
                ", manHourQuantity=" + manHourQuantity +
                '}';
    }
}
