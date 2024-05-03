//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package servlets;

import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import models.UserModel;
import services.MySQLdb;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(
        name = "SignupServlet",
        value = {"/SignupServlet"}
)
public class SignupServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        MySQLdb db = MySQLdb.getInstance();
        UserModel userModel = null;

        try {
            userModel = db.doSignup(firstname,lastname,username,password);
        } catch (SQLException var9) {
            SQLException e = var9;
            e.printStackTrace();
        }

        if (userModel != null) {
            HttpSession session = request.getSession();

            if(userModel.isIfExistedUser()) {
                request.setAttribute("error", "Existing User. Please log in directly.");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("singuppage.jsp");
                requestDispatcher.forward(request, response);
            }
            else {
                session.setAttribute("user", userModel);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginredirectpage.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("singuppage.jsp");
            request.setAttribute("error", "Incorrect sign up information..!!!");
            requestDispatcher.forward(request, response);
        }

    }
}
