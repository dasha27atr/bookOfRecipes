package by.training.finalproject.command;

import by.training.finalproject.dao.DAOException;
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
            if (validator.validate(request)) {
                String login = request.getParameter("login");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                Integer type = 2;
                User newUser = new User();
                newUser.setLogin(login);
                newUser.setPassword(password);
                newUser.setEmail(email);
                newUser.setAddress(address);
                newUser.setPhone(phone);
                newUser.setFirstName(firstName);
                newUser.setLastName(lastName);
                newUser.setType(type);
                userDAO.create(newUser);
//                newUser = userDAO.findByLogin(login);
                page = "/jsp/successRegistration.jsp";
            }
        } catch (DAOException e) {
            //something
        }
        return page;
    }
}
