package by.training.finalproject.validator;

import by.training.finalproject.dao.exception.DAOException;
import by.training.finalproject.dao.impl.UserDAOImpl;

import javax.servlet.http.HttpServletRequest;

public class SignUpValidator implements Validator {
    private static final UserDAOImpl userDao = new UserDAOImpl();


    @Override
    public boolean validate(HttpServletRequest request) {
        boolean exist = true;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        if (login != null && password != null && email != null &&
                address != null && phone != null && firstName != null &&
                lastName != null) {
            try {
                if (!userDao.existLogin(login)) {
                    exist = false;
                }
            } catch (DAOException e) {
                //something?
            }
        }
        return exist;
    }
}
