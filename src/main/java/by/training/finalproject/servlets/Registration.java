package by.training.finalproject.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Registration")
public class Registration extends Dispatcher {
    public String getServletInfo() {
        return "Registration servlet";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("login") != null) {
            this.forward("/CheckUser", request, response);
        } else if (request.getParameter("registration") != null) {
            this.forward("/jsp/registration.jsp", request, response);
        }
    }
}
