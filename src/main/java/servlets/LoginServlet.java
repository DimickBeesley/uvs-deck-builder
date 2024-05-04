
package servlets;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import models.CardModel;
import models.UserModel;
import services.MySQLdb;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//import javax.smartcardio.Card;

@WebServlet(
        name = "LoginServlet",
        value = {"/LoginServlet"}
)
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        MySQLdb db = MySQLdb.getInstance();
        UserModel userModel = null;

        try {
            userModel = db.doLogin(username, password);
        } catch (SQLException var9) {
            SQLException e = var9;
            e.printStackTrace();
        }

        if (userModel != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userModel);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginredirectpage.jsp");
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginpage.jsp");
            request.setAttribute("error", "Incorrect email or password OR you have not registered yet..!!!");
            requestDispatcher.forward(request, response);
        }

    }
}
