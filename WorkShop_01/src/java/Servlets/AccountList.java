/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
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
public class AccountList extends HttpServlet {

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
            AccountDao ac = new AccountDao();
            HttpSession ss = request.getSession();
            List<Account> list = ac.listAll();
            ss.setAttribute("ACCOUNTS", list);
            //request.getRequestDispatcher("accountList.jsp").forward(request, response);
            out.println("<div class=\"table-responsive\"><table class=\"table table-tripped\"><tr>\n"
                    + "                    <td>Account</td>\n"
                    + "                    <td>Full name</td>\n"
                    + "                    <td>Birth day</td>\n"
                    + "                    <td>Gender</td>\n"
                    + "                    <td>Phone</td>\n"
                    + "                    <td>Role in system</td>\n"
                    + "                    <td>Action</td>\n"
                    + "                </tr>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Account account : list) {
                out.println("<tr class=\"account-row\">\n"
                        + "                        <td>" + account.getAccount() + "</td>\n"
                        + "                        <td>" + account.getFirstName() + ", " + account.getLastName() + "</td>\n"
                        + "                        <td>\n"
                        + sdf.format(account.getBirthday())
                        + "                    </td>\n"
                        + "                    <td>" + (account.isGender() ? "Male" : "Female") + "</td>\n"
                        + "                    <td>" + account.getPhone() + "</td>\n"
                        + "                    <td>" + (account.getRoleInSystem() == 1 ? "Administrator" : "Staff") + "</td>\n"
                        + "                    <td>\n"
                        + "                        <!--                        <form action=\"acc_process\" method=\"post\">\n"
                        + "                                                    <input type=\"hidden\" name=\"actionType\" value=\"UPD#${i.account}\"/>\n"
                        + "                                                    <input type=\"submit\" class=\"btn btn-primary\" value=\"Update\"/>\n"
                        + "                                                </form>\n"
                        + "                                                <form action=\"acc_process\" method=\"post\">\n"
                        + "                                                    <input type=\"hidden\" name=\"actionType\" value=\"ATV#${i.account}\"/>\n"
                        + "                                                    <input type=\"submit\" class=\"btn btn-success\" value='${i.isUse?\"Deactive\":\"Active\"}'/>\n"
                        + "                                                </form>\n"
                        + "                                                <form action=\"acc_process\" method=\"post\">\n"
                        + "                                                    <input type=\"hidden\" name=\"actionType\" value=\"DEL#${i.account}\"/>\n"
                        + "                                                    <input type=\"submit\" class=\"btn btn-danger\" value=\"delete\"/>\n"
                        + "                                                </form>\n"
                        + "                        -->\n"
                       
                        + "                        <button class=\"btn btn-primary\" data-isuse=\"9999\" value=\"UPD#"+account.getAccount()+"\" onclick=\"validateForm(event)\">Update</button>\n"
                        + "                        <button class=\"btn btn-success activate-btn\" data-isuse=\""+(account.isIsUse() ? 0 : 1)+"\" value=\"ATV#"+account.getAccount()+"\" onclick=\"validateForm(event)\">"+(account.isIsUse()?"Deactive":"Active")+"</button>\n"
                        + "                        <button class=\"btn btn-danger\" data-isuse=\"9999\" value=\"DEL#"+account.getAccount()+"\" onclick=\"validateForm(event)\">Delete</button>\n"
                        + "                    </td>\n"
                        + "                    </tr>");
            }
            out.println("</table></div>");
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
        processRequest(request, response);
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
