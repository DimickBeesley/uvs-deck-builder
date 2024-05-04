package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CardModel;
import services.MySQLdb;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(
        name = "FetchCardsInformation",
        value = {"/FetchCardsInformation"}
)
public class FetchCardsInformation extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        String selectItem = request.getParameter("selecttype");
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

