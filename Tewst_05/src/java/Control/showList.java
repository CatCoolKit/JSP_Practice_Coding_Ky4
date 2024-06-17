/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.Supplier_DAO;
import DTO.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manhc
 */
public class showList extends HttpServlet {

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
            Supplier_DAO spdao = new Supplier_DAO();
            Vector<Supplier> listspl = (Vector<Supplier>) request.getAttribute("list");
            
            if (listspl == null) {
                listspl = spdao.getALlSupplier();
                request.setAttribute("list", listspl);
                out.println("<table border=\"1\">"
                        + "<thead>\n"
                        + "                    <tr>\n"
                        + "                        <th>Code</th>\n"
                        + "                        <th>Name</th>\n"
                        + "                        <th>Date of birth</th>\n"
                        + "                        <th>Gender</th>\n"
                        + "                        <th>Address</th>\n"
                        + "                        <th></th>\n"
                        + "                    </tr>\n"
                        + "                </thead><tbody>");
                for (Supplier supplier : listspl) {
                    out.println("<tr>\n"
                            + "                            <td>" + supplier.getSupplierID() + "</td>\n"
                            + "                            <td>" + supplier.getSupplierName() + "</td>\n"
                            + "                            <td>" + supplier.getBirthDate() + "</td>\n"
                            + "                            <td>" + supplier.getGender() + "</td>\n"
                            + "                            <td>" + supplier.getAddress() + "</td>\n"
                            + "                            <td><a href=\"/Tewst_05/show?Service=delete&SupplierID=" + supplier.getSupplierID()
                            + "\">delete</a></td>\n"
                            + "                        </tr>"
                    );
                }
                out.println("</tbody></table>");
            }

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
