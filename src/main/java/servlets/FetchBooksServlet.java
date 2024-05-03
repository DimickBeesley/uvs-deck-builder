//package servlets;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//import services.MySQLdb;
//import models.BookModel;
//import models.UserModel;
//import services.MySQLdb;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import models.UserModel;
//import services.MySQLdb;
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
//
//@WebServlet(
//        name = "FetchBooksServlet",
//        value = {"/FetchBooksServlet"}
//)
//public class FetchBooksServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//        String selectItem = request.getParameter("selectitem");
//        String whichpage = request.getParameter("whichpage");
////        String password = request.getParameter("password");
//        MySQLdb db = MySQLdb.getInstance();
//
////        int album_id = 1;
////        HttpSession session = request.getSession();
////        MySQLdb db = MySQLdb.getInstance();
//        RequestDispatcher requestDispatcher;
//        if(selectItem.equals("all")) {
//            List<BookModel> bookModelList = null;
//            try {
//                bookModelList = db.fetchALL();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            request.setAttribute("list_of_books", bookModelList);
//
//        } else if (selectItem.equals("xml")) {
//            List<BookModel> bookModelList = null;
//            try {
//                bookModelList = db.fetchXML();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            request.setAttribute("list_of_books", bookModelList);
//        }else if(selectItem.equals("jsp")) {
//            List<BookModel> bookModelList = null;
//            try {
//                bookModelList = db.fetchJSP();
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            request.setAttribute("list_of_books", bookModelList);
//        }
//        requestDispatcher = request.getRequestDispatcher(whichpage);
//        requestDispatcher.forward(request, response);
//
//
//    }
//}
