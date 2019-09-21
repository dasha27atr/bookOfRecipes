package by.training.finalproject.command;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.dao.UserDAO;
import by.training.finalproject.dao.impl.UserDAOImpl;
import by.training.finalproject.entity.User;
import by.training.finalproject.validator.Validator;
import by.training.finalproject.validator.ValidatorFactory;

import javax.servlet.http.HttpServletRequest;

public class SignUpCommand implements Command {
    private static final UserDAO userDAO = new UserDAOImpl();

    @Override
    public String execute(HttpServletRequest request) {
        String page = "/jsp/errorRegistration.jsp";
        Validator validator = ValidatorFactory.getInstance().getSignUpValidator();
        try {
            if (!validator.validate(request)) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");

                User newUser = new User(login, password, email, address, phone, firstName, lastName);
                userDAO.create(newUser);

                request.getSession().setAttribute("userId", newUser.getUserId());
                request.getSession().setAttribute("login", newUser.getLogin());
                request.getSession().setAttribute("password", newUser.getPassword());
                request.getSession().setAttribute("email", newUser.getEmail());
                request.getSession().setAttribute("address", newUser.getAddress());
                request.getSession().setAttribute("phone", newUser.getPhone());
                request.getSession().setAttribute("firstName", newUser.getFirstName());
                request.getSession().setAttribute("lastName", newUser.getLastName());
                request.getSession().setAttribute("photo", newUser.getPhoto());
                request.getSession().setAttribute("type", newUser.getType());

                page = "/jsp/successRegistration.jsp";
            }
        } catch (DAOException e) {
            //something
        }
        return page;
    }
}
