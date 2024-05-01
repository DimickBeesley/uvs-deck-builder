package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import services.MySQLdb;
import models.BookModel;
import models.UserModel;
import services.MySQLdb;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import models.UserModel;
import services.MySQLdb;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(
        name = "ReserveServlet",
        value = {"/ReserveServlet"}
)
public class ReserveServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookname = request.getParameter("bookname");
        HttpSession session = request.getSession();
        UserModel user = (UserModel)session.getAttribute("user");

        List<String> bb = user.getBorrowedBooks();

        if(bb.isEmpty() || !bb.contains(bookname)) {
            user.setBorrowedBooks(bookname);
            int i = 0;
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
            request.setAttribute("error", "Good news~ Added to your cart. Enjoy it.");
            requestDispatcher.forward(request, response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("cart.jsp");
            request.setAttribute("error", "Oh,No! Already in your cart!!!!");
            requestDispatcher.forward(request, response);

        }
    }
}
