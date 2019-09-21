package by.training.finalproject.command;

import by.training.finalproject.dao.exception.DAOException;
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

                request.getSession().setAttribute("userId", user.getUserId());
                request.getSession().setAttribute("login", user.getLogin());
                request.getSession().setAttribute("password", user.getPassword());
                request.getSession().setAttribute("email", user.getEmail());
                request.getSession().setAttribute("address", user.getAddress());
                request.getSession().setAttribute("phone", user.getPhone());
                request.getSession().setAttribute("firstName", user.getFirstName());
                request.getSession().setAttribute("lastName", user.getLastName());
                request.getSession().setAttribute("photo", user.getPhoto());
                request.getSession().setAttribute("type", user.getType());

                page = "/jsp/account.jsp";
            } catch (DAOException e) {
                //something
            }
        }
        return page;
    }
}
