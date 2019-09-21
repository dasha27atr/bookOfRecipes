package by.training.finalproject.dao.impl;

import by.training.finalproject.connectionPool.ConnectionPool;
import by.training.finalproject.dao.RecipeDAO;
import by.training.finalproject.dao.exception.RecipeDAOException;
import by.training.finalproject.entity.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RecipeDaoImpl implements RecipeDAO {
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final String SQL_INSERT_RECIPES =
            "insert into recipes (title, userLogin, uploadDate, photo, description, categoryId) " +
                    "values (?, ?, ?, ?, ?, ?);";
    private static final String SQL_EXIST_LOGIN =
            "SELECT recipeId FROM recipes WHERE title = ?";

    @Override
    public void create(Recipe entity) throws RecipeDAOException {
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_RECIPES);
            preparedStatement.setString(1, entity.getTitle());
            preparedStatement.setString(2, entity.getUserLogin());
            preparedStatement.setDate(3, entity.getUploadDate());
            preparedStatement.setString(4, entity.getPhoto());
            preparedStatement.setString(5, entity.getDescription());
            preparedStatement.setInt(6, entity.getCategoryId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RecipeDAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
    }
    @Override
    public boolean existTitle(String title) throws RecipeDAOException {
        boolean exist;
        Connection connection = null;
        try {
            connection = connectionPool.retrieveConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXIST_LOGIN);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            exist = resultSet.next();
        } catch (SQLException e) {
            throw new RecipeDAOException(e);
        } finally {
            connectionPool.putbackConnection(connection);
        }
        return exist;
    }

    @Override
    public List<Recipe> findAll() throws RecipeDAOException {
        return null;
    }

    @Override
    public Recipe findById(Integer id) throws RecipeDAOException {
        return null;
    }

    @Override
    public void update(Recipe entity, int id) throws RecipeDAOException {

    }

    @Override
    public void delete(int id) throws RecipeDAOException {

    }


    @Override
    public List<Recipe> findHotDishes() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findSalads() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findSnacks() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findSoups() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findBaking() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findDesserts() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findDrinks() throws RecipeDAOException {
        return null;
    }

    @Override
    public List<Recipe> findByLogin(String login) throws RecipeDAOException {
        return null;
    }
}
