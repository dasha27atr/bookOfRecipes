package by.training.finalproject.command;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.impl.UserDAOImpl;
import by.training.finalproject.entity.User;
import by.training.finalproject.validator.Validator;
import by.training.finalproject.validator.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements Command {
    private static final UserDAOImpl userDao = new UserDAOImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/errorLogin.jsp";
        Validator validator = ValidatorFactory.getInstance().getSignInValidator();

        if (validator.validate(request)) {
            try {
                String login = request.getParameter("login");
                User user = userDao.findByLogin(login);

                page = "/jsp/successLogin.jsp";
            } catch (DAOException e) {
                //something
            }
        }
        return page;
    }
}
