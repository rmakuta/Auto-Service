package pl.makuta.dao;

import pl.makuta.DbUtil;
import pl.makuta.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static final String CREATE_EMPLOYEE_QUERY = "INSERT INTO employees(name, surname, address, phoneNumber, note, manHourCost) " +
            "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String READ_EMPLOYEE_QUERY = "SELECT * FROM employees WHERE id = ?";
    private static final String UPDATE_EMPLOYEE_QUERY = "UPDATE employees SET name = ?, surname = ?, address = ?, phoneNumber = ?," +
            "note = ?, manHourCost = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employees WHERE id = ?";
    private static final String FIND_ALL_EMPLOYEES_QUERY = "SELECT * FROM employees";

    public Employee create(Employee employee){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREATE_EMPLOYEE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getManHourCost());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                employee.setId(resultSet.getInt(1));
            }
            return employee;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Employee read(int employeeId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(READ_EMPLOYEE_QUERY);
            statement.setInt(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getString("phoneNumber"));
                employee.setNote(resultSet.getString("note"));
                employee.setManHourCost(resultSet.getDouble("manHourCost"));
                return employee;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(Employee employee){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_EMPLOYEE_QUERY);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhoneNumber());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getManHourCost());
            statement.setInt(7, employee.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int employeeId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(DELETE_EMPLOYEE_QUERY);
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Employee> findAll(){
        try (Connection conn = DbUtil.getConnection()){
            List<Employee> employees = new ArrayList<>();
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_EMPLOYEES_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setSurname(resultSet.getString("surname"));
                employee.setAddress(resultSet.getString("address"));
                employee.setPhoneNumber(resultSet.getString("phoneNumber"));
                employee.setNote(resultSet.getString("note"));
                employee.setManHourCost(resultSet.getDouble("manHourCost"));
                employees.add(employee);
            }
            return employees;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
