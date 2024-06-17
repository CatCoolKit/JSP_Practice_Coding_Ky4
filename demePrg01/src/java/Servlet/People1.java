/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.dao_Interface;
import DAO.peoPle_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import obJect.peoPle1;

/**
 *
 * @author manhc
 */
@WebServlet(name = "People1", urlPatterns = {"/people1"})
public class People1 extends HttpServlet {

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
            out.println("<title>Servlet People1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet People1 at " + request.getContextPath() + "</h1>");
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
        String url = "/index.jsp";
        peoPle_DAO dao = new peoPle_DAO();

        // get current action
        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        if (action.equals("Loading")) {
            ArrayList<peoPle1> peoList = new ArrayList<>();
            url = "InforPerson.jsp";    // the "join" page

            //b1: load data from dao
            peoList = dao.selectAll();

            //b2: set data to inforperson.jsp
            request.setAttribute("userList", peoList);
        } else if (action.equals("Insert")) {
            url = "InforPerson.jsp";

            String idString = request.getParameter("humanid");
            int id = Integer.parseInt(idString);
            String name = request.getParameter("humanname");
            String dob = request.getParameter("humandob");
            String gender = request.getParameter("humangender");
            String typeString = request.getParameter("typeid");
            int type = Integer.parseInt(typeString);

            peoPle1 p1 = new peoPle1(id, name, dob, gender, type);

            dao.inSert(p1);

        } else if (action.equals("Edit")) {
            url = "InforPerson.jsp";

            String idString = request.getParameter("userId");
            int id = 0;
            if (!idString.isEmpty()) {
                id = Integer.parseInt(idString);
                // Continue processing with intValue
            } else {
                // Handle the case where the string is empty
            }

            String name = request.getParameter("humanname");
            String dob = request.getParameter("humandob");
            String gender = request.getParameter("humangender");
            String typeString = request.getParameter("typeid");
            int type = Integer.parseInt(typeString);

            peoPle1 p1 = new peoPle1(id, name, dob, gender, type);

            dao.upDate(p1);
        } else if (action.equals("Delete")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            url = "InforPerson.jsp";

            peoPle1 p1 = new peoPle1(userId, "", "", "", 0);
            dao.deLete(p1);

        } else if (action.equals("Find")) {
            ArrayList<peoPle1> peoList1 = new ArrayList<>();
            url = "InforPerson.jsp";

            String name = request.getParameter("humanname");
            peoPle1 p1 = new peoPle1(0, name, "", "", 0);

            peoList1 = dao.selectById(p1);

            request.setAttribute("userList", peoList1);
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
