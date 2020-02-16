package plCoderslabWorkshop2.dao;

import plCoderslabWorkshop2.model.User;
import plCoderslabWorkshop2.model.User_group;
import plCoderslabWorkshop2.utils.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class User_groupDao {
    private static final String CREATE_USER_GROUP_QUERY =
            "INSERT INTO users_groups(name) VALUES (?)";
    private static final String READ_USER_GROUP_QUERY =
            "SELECT * FROM users_groups where id = ?";
    private static final String UPDATE_USER_GROUP_QUERY =
            "UPDATE users_groups SET name = ? WHERE id = ?";
    private static final String DELETE_USER_GROUP_QUERY =
            "DELETE FROM users_groups WHERE id = ?";
    private static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users_groups";

    public User_group create(User_group user_group) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_GROUP_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user_group.getName());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user_group.setId(resultSet.getInt(1));
            }
            return user_group;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User_group read(int userId) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement = conn.prepareStatement(READ_USER_GROUP_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User_group user_group = new User_group();
                user_group.setId(resultSet.getInt("id"));
                user_group.setName(resultSet.getString("name"));
                return user_group;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(User_group user_group) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_USER_GROUP_QUERY);
            statement.setString(1, user_group.getName());
            statement.setInt(2, user_group.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int userId) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_USER_GROUP_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User_group[] addToArray(User_group u, User_group[] users_groups) {
        User_group[] tmpUsers_groups = Arrays.copyOf(users_groups, users_groups.length + 1);
        tmpUsers_groups[users_groups.length] = u;
        return tmpUsers_groups;
    }

    public User_group[] findAll() {
        try (Connection conn = DBUtil.Conetion()) {
            User_group[] users = new User_group[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User_group user_group = new User_group();
                user_group.setId(resultSet.getInt("id"));
                user_group.setName(resultSet.getString("name"));
                users = addToArray(user_group, users);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace(); return null;
        }
    }

}
