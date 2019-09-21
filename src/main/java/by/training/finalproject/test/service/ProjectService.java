package by.training.finalproject.test.service;

import by.training.finalproject.connectionPool.ConnectionPool;
import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.test.dao.ProjectDAO;
import by.training.finalproject.test.entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService implements ProjectDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SQL_INSERT_PROJECT =
            "INSERT INTO PROJECT (ID, TITLE) VALUES(?, ?)";
    private static final String SQL_PROJECT_LIST_ORDER_BY_ID =
            "SELECT ID, TITLE FROM PROJECT";
    private static final String SQL_FIND_PROJECT_BY_ID =
            "SELECT ID, TITLE FROM PROJECT WHERE ID=?";
    private static final String SQL_UPDATE_PROJECT =
            "UPDATE PROJECT SET TITLE=? WHERE ID=?";
    private static final String SQL_DELETE_PROJECT =
            "DELETE FROM PROJECT WHERE ID=?";

    @Override
    public void add(Project project) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PROJECT)
        ) {
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Project> findAll() throws DAOException {
        List<Project> projectList = new ArrayList<>();
        try (Connection connection = connectionPool.retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SQL_PROJECT_LIST_ORDER_BY_ID);
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                projectList.add(project);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return projectList;
    }

    @Override
    public Project findById(Long id) throws DAOException {
        Project project = new Project();
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_PROJECT_BY_ID)
        ) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return project;
    }

    @Override
    public void update(Project project) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_PROJECT)
        ) {
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void remove(Project project) throws DAOException {
        try (Connection connection = connectionPool.retrieveConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_PROJECT)
        ) {
            preparedStatement.setLong(1, project.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
