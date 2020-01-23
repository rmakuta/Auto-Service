package pl.makuta.model;

import java.util.Date;

public class Order {
    private int id;
    private Date receiptDate;
    private Date repairPlannedDate;
    private Date repairDate;
    private int employeeId;
    private String problemDescription;
    private String repairDescription;
    private int statusId;
    private int vehicleId;
    private double repairCost;
    private double carPartsCost;
    private double manHourCost;
    private int manHourQuantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Date getRepairPlannedDate() {
        return repairPlannedDate;
    }

    public void setRepairPlannedDate(Date repairPlannedDate) {
        this.repairPlannedDate = repairPlannedDate;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
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

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
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
                ", receiptDate=" + receiptDate +
                ", repairPlannedDate=" + repairPlannedDate +
                ", repairDate=" + repairDate +
                ", employeeId=" + employeeId +
                ", problemDescription='" + problemDescription + '\'' +
                ", repairDescription='" + repairDescription + '\'' +
                ", statusId=" + statusId +
                ", vehicleId=" + vehicleId +
                ", repairCost=" + repairCost +
                ", carPartsCost=" + carPartsCost +
                ", manHourCost=" + manHourCost +
                ", manHourQuantity=" + manHourQuantity +
                '}';
    }
}
