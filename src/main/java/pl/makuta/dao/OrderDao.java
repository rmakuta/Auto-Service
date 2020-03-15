package pl.makuta.dao;

import pl.makuta.DbUtil;
import pl.makuta.model.Order;
import pl.makuta.model.Status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static final String CREAT_ORDER_QUERY = "INSERT INTO orders(addDate, repairPlannedDate, repairDate, " +
            "employeeId, problemDescription, repairDescription, status, vehicleId, repairCost, carPartsCost, manHourCost," +
            "manHourQuantity) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_ORDER_QUERY = "SELECT * FROM orders WHERE id =?";
    private static final String UPDATE_ORDER_QUERY = "UPDATE orders SET addDate = ?, repairPlannedDate = ?, repairDate = ?, " +
            "employeeId = ?, problemDescription = ?, repairDescription = ?, status = ?, vehicleId = ?, repairCost = ?, " +
            "carPartsCost = ?, manHourCost = ?, manHourQuantity = ? WHERE id = ?";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM orders WHERE id = ?";
    private static final String FIND_ALL_ORDERS_QUERY = "SELECT * FROM orders";
    private static final String FIND_ALL_ORDERS_BY_EMPLOYEEID_QUERY = "SELECT * FROM orders WHERE employeeId = ?";
    private static final String FIND_ALL_ORDERS_BY_VEHICLEID_QUERY = "SELECT * FROM orders WHERE vehicleId = ?";
    private static final String FIND_ALL_ORDERS_BY_STATUS_QUERY = "SELECT * FROM orders WHERE status = ?";

    public Order create(Order order){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREAT_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(order.getAddDate()));
            if(order.getRepairPlannedDate() != null){
                statement.setDate(2, Date.valueOf(order.getRepairPlannedDate()));
            }else {
                statement.setDate(2, null);
            }
            if(order.getRepairDate() != null){
                statement.setDate(3, Date.valueOf(order.getRepairDate()));
            }else {
                statement.setDate(3, null);
            }
            statement.setInt(4, order.getEmployeeId());
            statement.setString(5, order.getProblemDescription());
            statement.setString(6, order.getRepairDescription());
            statement.setString(7, order.getStatus().name());
            statement.setInt(8, order.getVehicleId());
            statement.setDouble(9, order.getCarPartsCost() + (order.getManHourCost() * order.getManHourQuantity()));
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
                order.setAddDate(resultSet.getString("addDate"));
                order.setRepairPlannedDate(resultSet.getString("repairPlannedDate"));
                order.setRepairDate(resultSet.getString("repairDate"));
                order.setEmployeeId(resultSet.getInt("employeeId"));
                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
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
            statement.setDate(1, Date.valueOf(order.getAddDate()));
            if(order.getRepairPlannedDate() != null){
                statement.setDate(2, Date.valueOf(order.getRepairPlannedDate()));
            }else {
                statement.setDate(2, null);
            }
            if(order.getRepairDate() != null){
                statement.setDate(3, Date.valueOf(order.getRepairDate()));
            }else {
                statement.setString(3, null);
            }
            statement.setInt(4, order.getEmployeeId());
            statement.setString(5, order.getProblemDescription());
            statement.setString(6, order.getRepairDescription());
            statement.setString(7, order.getStatus().name());
            statement.setInt(8, order.getVehicleId());
            statement.setDouble(9, order.getCarPartsCost() + (order.getManHourCost() * order.getManHourQuantity()));
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

    public List<Order> findAll(){
        try (Connection conn = DbUtil.getConnection()){
            List<Order> orders = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_ORDERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAddDate(resultSet.getString("addDate"));
                order.setRepairPlannedDate(resultSet.getString("repairPlannedDate"));
                order.setRepairDate(resultSet.getString("repairDate"));
                order.setEmployeeId(resultSet.getInt("employeeId"));
                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setCarPartsCost(resultSet.getDouble("carPartsCost"));
                order.setManHourCost(resultSet.getDouble("manHourCost"));
                order.setManHourQuantity(resultSet.getInt("manHourQuantity"));
                orders.add(order);
            }
            return orders;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> findAllOrdersByEmployeeId(int employeeId){
        try (Connection con = DbUtil.getConnection()){
            List<Order> orders = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(FIND_ALL_ORDERS_BY_EMPLOYEEID_QUERY);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAddDate(resultSet.getString("addDate"));
                order.setRepairPlannedDate(resultSet.getString("repairPlannedDate"));
                order.setRepairDate(resultSet.getString("repairDate"));
                order.setEmployeeId(resultSet.getInt("employeeId"));
                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setCarPartsCost(resultSet.getDouble("carPartsCost"));
                order.setManHourCost(resultSet.getDouble("manHourCost"));
                order.setManHourQuantity(resultSet.getInt("manHourQuantity"));
                orders.add(order);
            }
            return orders;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> findAllOrdersByVehicleId(int vehicleId){
        try (Connection con = DbUtil.getConnection()){
            List<Order> orders = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(FIND_ALL_ORDERS_BY_VEHICLEID_QUERY);
            statement.setInt(1, vehicleId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAddDate(resultSet.getString("addDate"));
                order.setRepairPlannedDate(resultSet.getString("repairPlannedDate"));
                order.setRepairDate(resultSet.getString("repairDate"));
                order.setEmployeeId(resultSet.getInt("employeeId"));
                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setCarPartsCost(resultSet.getDouble("carPartsCost"));
                order.setManHourCost(resultSet.getDouble("manHourCost"));
                order.setManHourQuantity(resultSet.getInt("manHourQuantity"));
                orders.add(order);
            }
            return orders;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Order> findAllOrdersByStatus(String status){
        try (Connection con = DbUtil.getConnection()){
            List<Order> orders = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(FIND_ALL_ORDERS_BY_STATUS_QUERY);
            statement.setString(1, status);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setAddDate(resultSet.getString("addDate"));
                order.setRepairPlannedDate(resultSet.getString("repairPlannedDate"));
                order.setRepairDate(resultSet.getString("repairDate"));
                order.setEmployeeId(resultSet.getInt("employeeId"));
                order.setProblemDescription(resultSet.getString("problemDescription"));
                order.setRepairDescription(resultSet.getString("repairDescription"));
                order.setStatus(Status.valueOf(resultSet.getString("status")));
                order.setVehicleId(resultSet.getInt("vehicleId"));
                order.setRepairCost(resultSet.getDouble("repairCost"));
                order.setCarPartsCost(resultSet.getDouble("carPartsCost"));
                order.setManHourCost(resultSet.getDouble("manHourCost"));
                order.setManHourQuantity(resultSet.getInt("manHourQuantity"));
                orders.add(order);
            }
            return orders;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
