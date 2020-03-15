package pl.makuta.model;

import java.time.LocalDate;

public class Order {
    private int id;
    private LocalDate addDate;
    private LocalDate repairPlannedDate;
    private LocalDate repairDate;
    private int employeeId;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private int vehicleId;
    private double repairCost;
    private double carPartsCost;
    private double manHourCost;
    private int manHourQuantity;

    public Order() {
        this.addDate = LocalDate.now();
        this.repairPlannedDate = null;
        this.repairDate = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = LocalDate.parse(addDate);
    }

    public LocalDate getRepairPlannedDate() {
        return repairPlannedDate;
    }

    public void setRepairPlannedDate(String repairPlannedDate) {
        if(repairPlannedDate == null){
            this.repairPlannedDate = null;
        }else {
            this.repairPlannedDate = LocalDate.parse(repairPlannedDate);
        }
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        if(repairDate == null){
            this.repairDate = null;
        }else {
            this.repairDate = LocalDate.parse(repairDate);
        }
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
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
                ", status=" + status +
                ", vehicleId=" + vehicleId +
                ", repairCost=" + repairCost +
                ", carPartsCost=" + carPartsCost +
                ", manHourCost=" + manHourCost +
                ", manHourQuantity=" + manHourQuantity +
                '}';
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


}
