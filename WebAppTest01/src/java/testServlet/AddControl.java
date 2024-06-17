/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testServlet;

import DAO.accountDAO;
import DAO.authorDAO;
import DAO.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import testData.author;
import testData.userKH;

/**
 *
 * @author manhc
 */
@WebServlet(name = "AddControl", urlPatterns = {"/add"})
public class AddControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String url = "/index.jsp";
        ArrayList<author> list = new ArrayList<>();
        // get current action
        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        if (action.equals("Load List Author")) {
            url = "/index.jsp";    // the "join" page

            //b1: load data from dao
            authorDAO dao = new authorDAO();
            list = dao.selectAll();

            //b2: set data to index.jsp
            request.setAttribute("listA", list);
        } else if (action.equals("Sign up to buy books")) {

            String id = request.getParameter("id");
            int id1 = 0;

            String khname = request.getParameter("khname");

            String khdate = request.getParameter("khdate");
            String dateFormat = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            java.util.Date convertedDate = null;

            try {
                convertedDate = sdf.parse(khdate);
                id1 = Integer.parseInt(id);
            } catch (ParseException ex) {
                Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Chuyển đổi java.util.Date thành java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(convertedDate.getTime());

            String khdiachi = request.getParameter("khdiachi");

            String[] authorED = {};
            authorED = request.getParameterValues("sauthor");

            userKH kh = new userKH(id1, khname, sqlDate, khdiachi);

            userDAO.getInstace().inSert(kh);
            for (String atID : authorED) {
                accountDAO.getInstace().inSert(atID, id);
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
