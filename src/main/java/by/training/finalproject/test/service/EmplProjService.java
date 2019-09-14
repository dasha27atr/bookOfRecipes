package by.training.finalproject.test.service;

import by.training.finalproject.connectionPool.ConnectionPool;
import by.training.finalproject.dao.DAOException;
import by.training.finalproject.test.dao.EmplProjDAO;
import by.training.finalproject.test.entity.EmplProj;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjService implements EmplProjDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SQL_INSERT_EMPL_PROJ =
            "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES(?, ?)";
    private static final String SQL_EMPL_PROJ_LIST_ORDER_BY_ID =
            "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";
    private static final String SQL_FIND_BY_EMPLOYEE_ID_AND_PROJECT_ID =
            "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
    private static final String SQL_UPDATE_EMPL_PROJ =
            "UPDATE EMPL_PROJ SET EMPLOYEE_ID=?, PROJECT_ID=?";
    private static final String SQL_DELETE_EMPL_PROJ =
            "DELETE FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";

    @Override
    public void add(EmplProj emplProj) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_EMPL_PROJ)
        ) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<EmplProj> findAll() throws DAOException {
        List<EmplProj> emplProjList = new ArrayList<>();
        try (Connection connection = connectionPool.retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_EMPL_PROJ_LIST_ORDER_BY_ID);
            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

                emplProjList.add(emplProj);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return emplProjList;
    }

    @Override
    public EmplProj findByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws DAOException{
        EmplProj emplProj = new EmplProj();
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMPLOYEE_ID_AND_PROJECT_ID)
        ) {
            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet=preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_EMPL_PROJ)
        ) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void remove(EmplProj emplProj) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_EMPL_PROJ)
        ) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
