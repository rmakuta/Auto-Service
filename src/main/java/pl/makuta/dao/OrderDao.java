package pl.makuta.dao;

import pl.makuta.DbUtil;
import pl.makuta.model.Order;

import java.sql.*;

public class OrderDao {
    private static final String CREAT_ORDER_QUERY = "INSERT INTO orders(adoptionDate, repairPlannedDate, repairDate, " +
            "employeeId, problemDescription, repairDescription, statusId, vehicleId, repairCost, carPartsCost, manHourCost," +
            "manHourQuantity) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ORDER_QUERY = "SELECT * FROM orders WHERE id =?";
    private static final String UPDATE_ORDER_QUERY = "UPDATE orders SET adoptionDate = ?, repairPlannedDate = ?, repairDate = ?, " +
            "employeeId = ?, problemDescription = ?, repairDescription = ?, statusId = ?, vehicleId = ?, reapirCost = ?, " +
            "carPartsCost = ?, manHourCost = ?, manHourQuantity = ? WHERE id = ?";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE id = ?";

    public Order create(Order order){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREAT_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, order.getAdoptionDate());
            statement.setString(2, order.getRepairPlannedDate());
            statement.setString(3, order.getRepairDate());
            statement.setInt(4, order.getEmployeeId());
            statement.setString(5, order.getProblemDescription());
            statement.setString(6, order.getRepairDescription());
            statement.setInt(7, order.getStatusId());
            statement.setInt(8, order.getVehicleId());
            statement.setDouble(9, order.getRepairCost());
            statement.setDouble(10, order.getCarPartsCost());
            statement.setDouble(11, order.getManHourCost());
            statement.setInt(12, order.getManHourQuantity());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                order.setId(resultSet.getInt(1));
            }
            return order;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Order read(int orderId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(READ_ORDER_QUERY);
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAdoptionDate(resultSet.getString("adoptionDate"));
                order.setRepairPlannedDate(resultSet.getString("repairPlaneDate"));
                order.setRepairDate(resultSet.getString("repairDate"));
                order.setEmployeeId(resultSet.getInt("employeeId"));
                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatusId(resultSet.getInt("statusId"));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setCarPartsCost(resultSet.getDouble("carPartsCost"));
                order.setManHourCost(resultSet.getDouble("manHourCost"));
                order.setManHourQuantity(resultSet.getInt("manHourQuantity"));
                return order;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(Order order){
        try (Connection con = DbUtil.getConnection()){
            PreparedStatement statement = con.prepareStatement(UPDATE_ORDER_QUERY);
            statement.setString(1, order.getAdoptionDate());
            statement.setString(2, order.getRepairPlannedDate());
            statement.setString(3, order.getRepairDate());
            statement.setInt(4, order.getEmployeeId());
            statement.setString(5, order.getProblemDescription());
            statement.setString(6, order.getRepairDescription());
            statement.setInt(7, order.getStatusId());
            statement.setInt(8, order.getVehicleId());
            statement.setDouble(9, order.getRepairCost());
            statement.setDouble(10, order.getCarPartsCost());
            statement.setDouble(11, order.getManHourCost());
            statement.setInt(12, order.getManHourQuantity());
            statement.setInt(13, order.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int orderId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(DELETE_ORDER_QUERY);
            statement.setInt(1, orderId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}