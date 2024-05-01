
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
        name = "LogoutServlet",
        value = {"/LogoutServlet"}
)
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException {
        UserModel userModel = null;
        HttpSession session = request.getSession();
        session.setAttribute("user", userModel);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);
    }
}
