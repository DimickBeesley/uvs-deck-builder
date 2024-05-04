package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.CardModel;
import models.UserModel;
import services.MySQLdb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(
        name = "LoginRedirectHelp",
        value = {"/LoginRedirectHelp"}
)
public class LoginRedirectHelp extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fn = request.getParameter("fn");

        if(fn.equals("scd")){
            RequestDispatcher requestDispatcher;
            requestDispatcher = request.getRequestDispatcher("createddeck.jsp");
            requestDispatcher.forward(request, response);

        } else if (fn.equals("cd")) {
            HttpSession session = request.getSession();
            UserModel user = (UserModel) session.getAttribute("user");
            user.resetCurnamelist();
            RequestDispatcher requestDispatcher;
            List<CardModel> cm = new ArrayList<>();
            CardModel empty = new CardModel();
            cm.add(empty);

            request.setAttribute("cds", cm);
            requestDispatcher = request.getRequestDispatcher("createnewdeck.jsp");
            requestDispatcher.forward(request, response);

        }
        String whichpage = request.getParameter("whichpage");
        List<String> parameters = new ArrayList<String>();
        parameters.add(request.getParameter("selectset"));
        parameters.add(request.getParameter("selecttype"));
        parameters.add(request.getParameter("selectrarity"));
        MySQLdb db = MySQLdb.getInstance();


        RequestDispatcher requestDispatcher;
        List<CardModel> cards = null;
        try {
            cards = db.fetchCards(parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("cards", cards);
        requestDispatcher = request.getRequestDispatcher(whichpage);
        requestDispatcher.forward(request, response);


    }
}
