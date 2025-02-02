/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.dao.AccountDao;

/**
 *
 * @author manhc
 */
public class AccountAddNew extends HttpServlet {
    private final String ADDACCOUNT = "addNewAccount.jsp";

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
        AccountDao acd = new AccountDao();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Lấy các thông tin từ request
        String account = request.getParameter("account");
        String password = request.getParameter("pass");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phone = request.getParameter("phone");
        String birthdayStr = request.getParameter("birthday");
        boolean gender = "Male".equals(request.getParameter("gender"));
        int roleInSystem = Integer.parseInt(request.getParameter("roleInSystem"));
        boolean isActive = request.getParameter("isUse") != null && request.getParameter("isUse").equals("on");

        Date birthday = null;
        try {
            birthday = sdf.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Xử lý lỗi ở đây
        }

        Account ac = new Account(account, password, lastName, firstName, birthday, gender, phone, isActive, roleInSystem);
        acd.insertRec(ac);
        
        request.getRequestDispatcher(ADDACCOUNT).forward(request, response);
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
