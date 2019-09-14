package by.training.finalproject.servlets;

import by.training.finalproject.dao.DAOException;
import by.training.finalproject.dao.UserDAO;
import by.training.finalproject.dao.impl.UserDAOImpl;
import by.training.finalproject.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddUser")
public class AddUser extends Dispatcher {
    public String getServletInfo() {
        return "Add user servlet";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
//        if (request.getParameter("save") != null) {
//            String login = request.getParameter("login");
//            String password = request.getParameter("password");
//            String email = request.getParameter("email");
//            String address = request.getParameter("address");
//            String phone = request.getParameter("phone");
//            User newUser = new User();
//            newUser.setLogin(login);
//            newUser.setPassword(password);
//            newUser.setEmail(email);
//            newUser.setAddress(address);
//            newUser.setPhone(phone);
//            servletContext.setAttribute("login", newUser);
//            UserDAO userDAO = new UserDAOImpl();
//            try {
//                userDAO.create(newUser);
//                this.forward("/jsp/successRegistration.jsp", request, response);
////                if (userDAO.existLogin(String.valueOf(newUser.getUserId()))) {
////                    this.forward("/jsp/successRegistration.jsp", request, response);
////                } else {
////                    this.forward("/jsp/errorRegistration.jsp", request, response);
////                }
//            } catch (DAOException e){
//                //something
//            }
//        }
    }
}
