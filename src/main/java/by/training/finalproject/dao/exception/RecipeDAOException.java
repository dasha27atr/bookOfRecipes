package by.training.finalproject.dao.exception;

public class RecipeDAOException extends DAOException {
    public RecipeDAOException() {
    }

    public RecipeDAOException(String message) {
        super(message);
    }

    public RecipeDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipeDAOException(Throwable cause) {
        super(cause);
    }
}
