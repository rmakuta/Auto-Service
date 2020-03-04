package pl.makuta.dao;

import pl.makuta.DbUtil;
import pl.makuta.model.Customer;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    private static final String CREATE_CUSTOMER_QUERY = "INSERT INTO customers(name, surname, birthDate) VALUES(?, ?, ?)";
    private static final String READ_CUSTOMER_QUERY = "SELECT * FROM customers WHERE id = ?";
    private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customers SET name = ?, surname = ?, birthDate = ? WHERE id = ?";
    private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customers WHERE id = ?";
    private static final String FIND_ALL_CUSTOMERS_QUERY = "SELECT * FROM customers";

    public Customer create(Customer customer){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREATE_CUSTOMER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getBirthDate());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                customer.setId(resultSet.getInt(1));
            }
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Customer read(int customerId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(READ_CUSTOMER_QUERY);
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setBirthDate(resultSet.getString("birthDate"));
                return customer;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(Customer customer){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_CUSTOMER_QUERY);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getSurname());
            statement.setString(3, customer.getBirthDate());
            statement.setInt(4, customer.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int customerId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(DELETE_CUSTOMER_QUERY);
            statement.setInt(1, customerId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Customer> findAll(){
        try (Connection con = DbUtil.getConnection()){
            List<Customer> customers = new ArrayList<>();
            PreparedStatement statement = con.prepareStatement(FIND_ALL_CUSTOMERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setBirthDate(resultSet.getString("birthDate"));
                customers.add(customer);
            }
            return customers;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
