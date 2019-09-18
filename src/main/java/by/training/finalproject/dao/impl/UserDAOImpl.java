package by.training.finalproject.dao.impl;

import by.training.finalproject.connectionPool.ConnectionPool;
import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.UserDAO;
import by.training.finalproject.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SQL_INSERT_USER =
            "INSERT INTO users (login, password, email, address, phone, firstName, lastName, photo, type) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_LIST_USER_ORDER_BY_ID =
            "SELECT users.userId, login, password, email, address, phone, firstName, lastName, photo, typesofusers.type " +
                    "FROM users INNER JOIN typesOfUsers ON users.type = typesOfUsers.typeId " +
                    "ORDER BY users.userId";
    private static final String SQL_FIND_USER_BY_ID =
            "SELECT users.userId, login, password, email, address, phone, firstName, lastName, photo, typesOfUsers.type " +
                    "FROM users INNER JOIN typesOfUsers ON users.type = typesOfUsers.typeId " +
                    "WHERE users.userId = ?";
    private static final String SQL_UPDATE_USER =
            "UPDATE users SET login = ?, password = ?, email = ?, address = ?, phone = ?, firstName = ?, lastName = ?, photo = ?, type = ? " +
                    "WHERE users.userId = ?";
    private static final String SQL_DELETE_USER =
            "DELETE FROM users WHERE users.userId = ?";
    private static final String SQL_FIND_USER_BY_LOGIN =
            "SELECT users.userId, login, password, email, address, phone, firstName, lastName, photo, typesOfUsers.type " +
                    "FROM users INNER JOIN typesOfUsers ON users.type = typesOfUsers.typeId " +
                    "WHERE login = ?";
    private static final String SQL_FIND_USER_BY_EMAIL =
            "SELECT users.userId, login, password, email, address, phone, firstName, lastName, photo, typesOfUsers.type " +
                    "FROM users INNER JOIN typesOfUsers ON users.type = typesOfUsers.typeId " +
                    "WHERE email = ?";
    private static final String SQL_EXIST_LOGIN =
            "SELECT userId FROM users WHERE login = ?";
//    private static final String SQL_INSERT_ROLE =
//            "INSERT INTO typesOfUsers (type) VALUES (?)";

    @Override
    public void create(User entity) throws DAOException {
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getFirstName());
            preparedStatement.setString(7, entity.getLastName());
            preparedStatement.setString(8, entity.getPhoto());
            preparedStatement.setInt(9, entity.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_LIST_USER_ORDER_BY_ID);
            while (resultSet.next()) {
                User user = new User();
                userList.add(parseResultSet(resultSet, user));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
        return userList;
    }

    @Override
    public User findById(Integer id) throws DAOException {
        return prepareIntegerStatement(SQL_FIND_USER_BY_ID, id);
    }

    @Override
    public void update(User entity, int userId) throws DAOException {
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_USER);
            preparedStatement.setString(1, entity.getLogin());
            preparedStatement.setString(2, entity.getPassword());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getAddress());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setString(6, entity.getFirstName());
            preparedStatement.setString(7, entity.getLastName());
            preparedStatement.setString(8,entity.getPhoto());
            preparedStatement.setInt(9, entity.getType());
            preparedStatement.setInt(10, userId);

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
    }

    @Override
    public void delete(int userId) throws DAOException {
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_USER);
            preparedStatement.setInt(1, userId);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
    }

    @Override
    public User findByLogin(String login) throws DAOException {
        return prepareStringStatement(SQL_FIND_USER_BY_LOGIN, login);
    }

    @Override
    public User findByEmail(String email) throws DAOException {
        return prepareStringStatement(SQL_FIND_USER_BY_EMAIL, email);
    }

    @Override
    public boolean existLogin(String login) throws DAOException {
        boolean exist;
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXIST_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            throw new DAOException();
        } finally {
            connectionPool.putbackConnection(connection);
        }
        return exist;
    }

    private User prepareStringStatement(String sql, String value) throws DAOException {
        User user = new User();
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            parseResultSet(resultSet, user);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
        return user;
    }

    private User prepareIntegerStatement(String sql, Integer value) throws DAOException {
        Connection connection = null;
        User user = new User();
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            parseResultSet(resultSet, user);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
        return user;
    }

    private static User parseResultSet(ResultSet resultSet, User user) throws SQLException {
        if (resultSet.next()) {
            user.setUserId(resultSet.getInt("userId"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setAddress(resultSet.getString("address"));
            user.setPhone(resultSet.getString("phone"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
//            user.setPhoto(resultSet.getString("photo"));
//            user.setType(resultSet.getInt("type"));
            user.setType(1);
        }
        return user;
    }

}
