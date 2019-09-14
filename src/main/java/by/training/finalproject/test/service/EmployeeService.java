package by.training.finalproject.test.service;

import by.training.finalproject.connectionPool.ConnectionPool;
import by.training.finalproject.dao.DAOException;
import by.training.finalproject.test.dao.EmployeeDAO;
import by.training.finalproject.test.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements EmployeeDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SQL_INSERT_EMPLOYEE =
            "INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID) " +
                    "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_EMPLOYEE_LIST_ORDER_BY_ID =
            "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYEE";
    private static final String SQL_FIND_EMPLOYEE_BY_ID =
            "SELECT ID, FIRST_NAME, LAST_NAME, BIRTHDAY, ADDRESS_ID FROM EMPLOYEE WHERE ID=?";
    private static final String SQL_UPDATE_EMPLOYEE =
            "UPDATE EMPLOYEE SET FIRST_NAME=?, LAST_NAME=?, BIRTHDAY=?, ADDRESS_ID=? WHERE ID=?";
    private static final String SQL_DELETE_EMPLOYEE =
            "DELETE FROM EMPLOYEE WHERE ID=?";

    @Override
    public void add(Employee employee) throws DAOException{
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_EMPLOYEE)
        ) {
            preparedStatement.setLong(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setLong(5, employee.getAddressId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Employee> findAll() throws DAOException {
        List<Employee> addressList = new ArrayList<>();
        try (Connection connection = connectionPool.retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_EMPLOYEE_LIST_ORDER_BY_ID);
            while (resultSet.next()) {
                Employee address = new Employee();
                address.setId(resultSet.getLong("ID"));
                address.setFirstName(resultSet.getString("FIRST_NAME"));
                address.setLastName(resultSet.getString("LAST_NAME"));
                address.setBirthday(resultSet.getDate("BIRTHDAY"));
                address.setAddressId(resultSet.getLong("ADDRESS_ID"));

                addressList.add(address);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return addressList;
    }

    @Override
    public Employee findById(Long id) throws DAOException {
        Employee employee = new Employee();
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_EMPLOYEE_BY_ID)
        ) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            employee.setId(resultSet.getLong("ID"));
            employee.setFirstName(resultSet.getString("FIRST_NAME"));
            employee.setLastName(resultSet.getString("LAST_NAME"));
            employee.setBirthday(resultSet.getDate("BIRTHDAY"));
            employee.setAddressId(resultSet.getLong("ADDRESS_ID"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return employee;
    }

    @Override
    public void update(Employee employee) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_EMPLOYEE)
        ) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setLong(4, employee.getAddressId());
            preparedStatement.setLong(5, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void remove(Employee employee) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_EMPLOYEE)
        ) {
            preparedStatement.setLong(1, employee.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
