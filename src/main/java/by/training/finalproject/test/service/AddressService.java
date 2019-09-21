package by.training.finalproject.test.service;

import by.training.finalproject.connectionPool.ConnectionPool;
import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.test.dao.AddressDAO;
import by.training.finalproject.test.entity.Address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressService implements AddressDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SQL_INSERT_ADDRESS =
            "INSERT INTO ADDRESS (ID, COUNTRY, CITY, STREET, POST_CODE) " +
                    "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_LIST_ADDRESS_ORDER_BY_ID =
            "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS ORDER BY ID";
    private static final String SQL_FIND_ADDRESS_BY_ID =
            "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS WHERE ID=?";
    private static final String SQL_UPDATE_ADDRESS =
            "UPDATE ADDRESS SET COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID=?";
    private static final String SQL_DELETE_ADDRESS =
            "DELETE FROM ADDRESS WHERE ID=?";

    @Override
    public void add(Address address) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_ADDRESS)
        ) {
            preparedStatement.setLong(1, address.getId());
            preparedStatement.setString(2, address.getCountry());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getStreet());
            preparedStatement.setString(5, address.getPostCode());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Address> findAll() throws DAOException {
        List<Address> addressList = new ArrayList<>();
        try (Connection connection = connectionPool.retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_LIST_ADDRESS_ORDER_BY_ID);
            while (resultSet.next()) {
                Address address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCountry(resultSet.getString("COUNTRY"));
                address.setCity(resultSet.getString("CITY"));
                address.setStreet(resultSet.getString("STREET"));
                address.setPostCode(resultSet.getString("POST_CODE"));

                addressList.add(address);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return addressList;
    }

    @Override
    public Address findById(Long id) throws DAOException {
        Address address = new Address();
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ADDRESS_BY_ID)
        ) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            address.setId(resultSet.getLong("ID"));
            address.setCountry(resultSet.getString("COUNTRY"));
            address.setCity(resultSet.getString("CITY"));
            address.setStreet(resultSet.getString("STREET"));
            address.setPostCode(resultSet.getString("POST_CODE"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return address;
    }

    @Override
    public void update(Address address) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_ADDRESS)
        ) {
            preparedStatement.setString(1, address.getCountry());
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setString(4, address.getPostCode());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void remove(Address address) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_ADDRESS)
        ) {
            preparedStatement.setLong(1, address.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
