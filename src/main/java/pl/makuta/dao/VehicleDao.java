package pl.makuta.dao;

import pl.makuta.DbUtil;
import pl.makuta.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao {
    private static final String CREATE_VEHICLE_QUERY = "INSERT INTO vehicles(model, brand, birth, regNumber, " +
            "nextServiceDate, customerId) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_VEHICLE_QUERY = "SELECT * FROM vehicles where id = ?";
    private static final String UPDATE_VEHICLE_QUERY = "UPDATE vehicles SET model = ?, brand = ?, birth = ?, regNumber = ?, " +
            "nextServiceDate = ?, customerId = ? where id = ?";
    private static final String DELETE_VEHICLE_QUERY = "DELETE FROM vehicles WHERE id = ?";
    private static final String FIND_ALL_VEHICLES_QUERY = "SELECT * FROM vehicles";
    private static final String FIND_ALL_VEHICLES_BY_CUSTOMERID_QUERY = "SELECT * FROM vehicles WHERE customerId = ?";

    public Vehicle create(Vehicle vehicle){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREATE_VEHICLE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getBirth());
            statement.setString(4, vehicle.getRegNumber());
            statement.setString(5, vehicle.getNextServiceDate());
            statement.setInt(6, vehicle.getCustomerId());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                vehicle.setId(resultSet.getInt(1));
            }
            return vehicle;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Vehicle read(int vehicleId){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(READ_VEHICLE_QUERY);
            statement.setInt(1, vehicleId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setBirth(resultSet.getInt("birth"));
                vehicle.setRegNumber(resultSet.getString("regNumber"));
                vehicle.setNextServiceDate(resultSet.getString("nextServiceDate"));
                vehicle.setCustomerId(resultSet.getInt("customerId"));
                return vehicle;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(Vehicle vehicle){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_VEHICLE_QUERY);
            statement.setString(1, vehicle.getModel());
            statement.setString(2, vehicle.getBrand());
            statement.setInt(3, vehicle.getBirth());
            statement.setString(4, vehicle.getRegNumber());
            statement.setString(5, vehicle.getNextServiceDate());
            statement.setInt(6, vehicle.getCustomerId());
            statement.setInt(7, vehicle.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int vehicleId){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(DELETE_VEHICLE_QUERY);
            statement.setInt(1, vehicleId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Vehicle> findAll(){
        try (Connection con = DbUtil.getConnection()){
            List<Vehicle> vehicles = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(FIND_ALL_VEHICLES_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setBirth(resultSet.getInt("birth"));
                vehicle.setRegNumber(resultSet.getString("regNumber"));
                vehicle.setNextServiceDate(resultSet.getString("nextServiceDate"));
                vehicle.setCustomerId(resultSet.getInt("customerId"));
                vehicles.add(vehicle);
            }
            return vehicles;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> findAllVehiclesByCustomerId(int customerId){
        try (Connection con = DbUtil.getConnection()){
            List<Vehicle> vehicles = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(FIND_ALL_VEHICLES_BY_CUSTOMERID_QUERY);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Vehicle vehicle = new Vehicle();
                vehicle.setId(resultSet.getInt("id"));
                vehicle.setModel(resultSet.getString("model"));
                vehicle.setBrand(resultSet.getString("brand"));
                vehicle.setBirth(resultSet.getInt("birth"));
                vehicle.setRegNumber(resultSet.getString("regNumber"));
                vehicle.setNextServiceDate(resultSet.getString("nextServiceDate"));
                vehicle.setCustomerId(resultSet.getInt("customerId"));
                vehicles.add(vehicle);
            }
            return vehicles;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
