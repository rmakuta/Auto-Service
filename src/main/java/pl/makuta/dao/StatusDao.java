package pl.makuta.dao;

import pl.makuta.DbUtil;
import pl.makuta.model.Status;

import java.sql.*;

public class StatusDao {
    private static final String CREATE_STATUS_QUERY = "INSERT INTO statuses(name) VALUES ?";
    private static final String READ_STATUS_QUERY = "SELECT * FROM statuses WHERE id = ?";
    private static final String UPDATE_STATUS_QUERY = "UPDATE statuses SET name = ? WHERE id = ?";
    private static final String DELETE_STATUS_QUERY = "DELETE FROM statuses WHERE id = ?";

    public Status create(Status status){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(CREATE_STATUS_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, status.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if(resultSet.next()){
                status.setId(resultSet.getInt(1));
            }
            return status;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Status read(int statusId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(READ_STATUS_QUERY);
            statement.setInt(1, statusId);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                Status status = new Status();
                status.setId(resultSet.getInt("id"));
                status.setName(resultSet.getString("name"));
                return status;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(Status status){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_STATUS_QUERY);
            statement.setString(1, status.getName());
            statement.setInt(2, status.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int statusId){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(DELETE_STATUS_QUERY);
            statement.setInt(1, statusId);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
