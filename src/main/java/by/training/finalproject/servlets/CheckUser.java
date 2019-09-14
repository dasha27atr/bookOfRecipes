package by.training.finalproject.servlets;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.impl.UserDAOImpl;
import by.training.finalproject.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckUser")
public class CheckUser extends Dispatcher {
    public String getServletInfo() {
        return "Registration servlet";
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UserDAOImpl userDao = new UserDAOImpl();
            User user = userDao.findByLogin(request.getParameter("login"));
            if (!userDao.existLogin(user.getLogin())) {
                this.forward("/jsp/errorLogin.jsp", request, response);
            } else {
                if (!user.getPassword().equals(request.getParameter("password"))) {
                    this.forward("/jsp/registration.jsp", request, response);
                } else {
                    this.forward("/jsp/successLogin.jsp", request, response);
                }
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
