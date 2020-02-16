package plCoderslabWorkshop2.dao;

import plCoderslabWorkshop2.model.Solutions;
import plCoderslabWorkshop2.model.User;
import plCoderslabWorkshop2.utils.DBUtil;

import java.sql.*;
import java.util.Arrays;

public class SolutionsDao {

        private static final String CREATE_SOLUTION_QUERY =
                "INSERT INTO solutions(created, updated, description, exercise_id, user_id) VALUES (?, ?, ?, ?, ?)";
        private static final String READ_SOLUTION_QUERY =
                "SELECT * FROM solutions where id = ?";
        private static final String UPDATE_SOLUTION_QUERY =
                "UPDATE solutions SET created=?, updated=?, description=?, exercise_id=?, user_id=? WHERE id=?";
        private static final String DELETE_SOLUTION_QUERY =
                "DELETE FROM solutions WHERE id = ?";
        private static final String FIND_ALL_SOLUTIONS_QUERY =
                "SELECT * FROM solutions";
        private static final String READ_SOLUTION_BY_USER =
                "select * from solutions join users u on solutions.user_id = u.id where user_id=?";

    public Solutions create(Solutions solutions) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_SOLUTION_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, solutions.getCreated());
            statement.setString(2, solutions.getUpdated());
            statement.setString(3, solutions.getDescription());
            statement.setInt(4, solutions.getExercises_id());
            statement.setInt(5,solutions.getUser_id());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                solutions.setId(resultSet.getInt(1));
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Solutions read(int solutionId) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_QUERY);
            statement.setInt(1, solutionId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Solutions solution= new Solutions();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercises_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Solutions solutions) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement = conn.prepareStatement(UPDATE_SOLUTION_QUERY);
            statement.setString(1, solutions.getCreated());
            statement.setString(2, solutions.getUpdated());
            statement.setString(3, solutions.getDescription());
            statement.setInt(4,solutions.getExercises_id());
            statement.setInt(5, solutions.getUser_id());
            statement.setInt(6, solutions.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int solutions_id) {
        try (Connection conn = DBUtil.Conetion()) {
            PreparedStatement statement = conn.prepareStatement(DELETE_SOLUTION_QUERY);
            statement.setInt(1, solutions_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Solutions[] addToArray(Solutions s, Solutions[] solutions) {
        Solutions[] tmpSolutions = Arrays.copyOf(solutions, solutions.length + 1);
        tmpSolutions[solutions.length] = s;
        return tmpSolutions;
    }

    public Solutions[] findAll() {
        try (Connection conn = DBUtil.Conetion()) {
            Solutions[] solutions = new Solutions[0];
            PreparedStatement statement = conn.prepareStatement(FIND_ALL_SOLUTIONS_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solutions solution = new Solutions();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercises_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                solutions = addToArray(solution,solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace(); return null;
        }
    }

    public Solutions[] SolutionsUser(int userId) {
        try (Connection conn = DBUtil.Conetion()) {
            Solutions[] solutions = new Solutions[0];
            PreparedStatement statement = conn.prepareStatement(READ_SOLUTION_BY_USER);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Solutions solution = new Solutions();
                solution.setId(resultSet.getInt("id"));
                solution.setCreated(resultSet.getString("created"));
                solution.setUpdated(resultSet.getString("updated"));
                solution.setDescription(resultSet.getString("description"));
                solution.setExercises_id(resultSet.getInt("exercise_id"));
                solution.setUser_id(resultSet.getInt("user_id"));
                solutions = addToArray(solution,solutions);
            }
            return solutions;
        } catch (SQLException e) {
            e.printStackTrace(); return null;
        }
    }

}
