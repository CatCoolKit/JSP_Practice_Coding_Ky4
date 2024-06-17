/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.dao.AccountDao;

/**
 *
 * @author manhc
 */
public class LoginControl extends HttpServlet {

    private final String PRIVATE = "dashboard.jsp";
    private final String PUBLICVR = "homePageVR.jsp";
    private final String PUBLIC = "homePage.jsp";
    private final String LOGIN = "index.jsp";
    private final String INVALID_LOGIN = "Invalid login information";
    private final String BLOCKED_LOGIN = "Your account is currently banned from access";

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
        doPost(request, response);
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
        String action = request.getParameter("action");
        String url = LOGIN;
        AccountDao acd = new AccountDao();
        HttpSession session = request.getSession();

        if (action.equals("loginUser")) {
            // get the user data
            String account = request.getParameter("uname");
            String pass = request.getParameter("psw");

            Account ac = acd.getObjectById(account);
            if (ac != null && ac.getPass().equals(pass) && account.equals("admin") && ac.isIsUse() == true) {

                session.setAttribute("USER", ac);
                response.sendRedirect(PRIVATE);
            } else if(ac != null && ac.getPass().equals(pass) && ac.isIsUse() == true){
                
                session.setAttribute("USER", ac);
                response.sendRedirect(PUBLICVR);
            } else {
                if(ac != null && ac.isIsUse() == false){
                    request.setAttribute("ErrorMessage", BLOCKED_LOGIN);
                }else{
                    request.setAttribute("ErrorMessage", INVALID_LOGIN);
                }
                
                request.getRequestDispatcher(url).forward(request, response);
            }

        }

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
