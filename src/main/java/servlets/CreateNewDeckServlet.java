package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CardModel;
import services.MySQLdb;
import models.UserModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//import javax.smartcardio.Card;

@WebServlet(
        name = "CreateNewDeckServlet",
        value = {"/CreateNewDeckServlet"}
)
public class CreateNewDeckServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String whichpage = request.getParameter("whichpage");
        List<String> parameters = new ArrayList<String>();
        parameters.add(request.getParameter("selectset"));
        parameters.add(request.getParameter("selecttype"));
        parameters.add(request.getParameter("selectrarity"));
        String q = request.getParameter("query");
        String newdeckname = request.getParameter("newdeckname");
        String cardname = request.getParameter("cardname");
        HttpSession session = request.getSession();
        UserModel user = (UserModel) session.getAttribute("user");
//        List<CardModel> curdeck = (List<CardModel>) session.getAttribute("cds");
//        List<String> bb = user.getCards();
        String done = request.getParameter("done");

        if(!(q==null)){
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

        }else if(!(done==null)){
            user.addDifferentdeckbuilders(user.getDecks());
            user.addBuildernames(newdeckname);
            user.resetDeck();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginredirectpage.jsp");
            request.setAttribute("error", "Congrats! Add one deck to your system.");
            requestDispatcher.forward(request, response);
        }else if(!(cardname==null)) {
            MySQLdb db = MySQLdb.getInstance();
            try {
                if (user.getCurnamelist().isEmpty() || !user.getCurnamelist().contains(cardname)) {
                    CardModel card = db.fetchIndividualCard(cardname);
                    user.addDeck(card);
                    user.addCurnamelist(card.getName());

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("addconfimation.jsp");
                    request.setAttribute("error", "Have added the card into your current deck builder. Go back to select more");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("addconfimation.jsp");
                    request.setAttribute("error", "Oh,No! Already in your deck!!!!");
                    requestDispatcher.forward(request, response);
                }
//
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
