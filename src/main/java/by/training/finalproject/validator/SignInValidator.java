package by.training.finalproject.validator;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.dao.impl.UserDAOImpl;
import by.training.finalproject.entity.User;

import javax.servlet.http.HttpServletRequest;

public class SignInValidator implements Validator {
    private static final UserDAOImpl userDao = new UserDAOImpl();

    @Override
    public boolean validate(HttpServletRequest request) {
        boolean result = false;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null) {
            try {
                User user = userDao.findByLogin(login);
                if (user != null && password.equals(user.getPassword())) {
                    result = true;
                }
            } catch (DAOException e) {
                //something?
            }
        }
        return result;
    }
}
