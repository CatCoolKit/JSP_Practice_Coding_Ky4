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
public class ShowServlet extends HttpServlet {
    private static String HOMEPAGE = "HomePage.jsp";

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
            out.println("<title>Servlet ShowServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShowServlet at " + request.getContextPath() + "</h1>");
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
        Supplier_DAO spdao = new Supplier_DAO();
        String service = request.getParameter("Service");
        if(service == null){
            service = "getAll";
        }
        
        Vector<Supplier> listspl;
        if(service.equals("getAll")){
            listspl = spdao.getALlSupplier();
            request.setAttribute("list", listspl);
            request.getRequestDispatcher(HOMEPAGE).forward(request, response);
        }
        if(service.equals("delete")){
            String id = request.getParameter("SupplierID");
            Supplier sp = new Supplier(id, "", null, "", "");
            spdao.deleteRec(sp);
            
            response.sendRedirect("show");
        }
        if(service.equals("filterByName")){
            String supplierName = request.getParameter("supplierName");
            listspl = spdao.getSupplierByName(supplierName);
            request.setAttribute("list", listspl);
            request.getRequestDispatcher(HOMEPAGE).forward(request, response);
        }
        if(service.equals("filterByYear")){
            String year = request.getParameter("supplierYear");
            listspl = spdao.getSupplierByYear(year);
            request.setAttribute("list", listspl);
            request.getRequestDispatcher(HOMEPAGE).forward(request, response);
        }
        
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
