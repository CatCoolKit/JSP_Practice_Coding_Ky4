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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Category;
import model.Product;
import model.dao.ProductDAO;

/**
 *
 * @author manhc
 */
public class ProductAddNew extends HttpServlet {

    private final String ADDPRODUCT = "productAddNew.jsp";

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
            out.println("<title>Servlet ProductAddNew</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductAddNew at " + request.getContextPath() + "</h1>");
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
        ProductDAO pdd = new ProductDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productImage = request.getParameter("productImage");
        String brief = request.getParameter("brief");

        Category type = new Category(Integer.parseInt(request.getParameter("type")), "", "");
        Account account = new Account(request.getParameter("account"), "", "", "", null, true, "", true, 0);
        String unit = request.getParameter("unit");
        String priceStr = request.getParameter("price");
        double price = 0.0;
        if (priceStr != null && !priceStr.isEmpty()) {
            price = Double.parseDouble(priceStr);
        }
        String discountStr = request.getParameter("discount");
        double discount = 0.0;
        if (discountStr != null && !discountStr.isEmpty()) {
            discount = Double.parseDouble(request.getParameter("discount"));
        }

        Product pd = new Product(productId, productName, productImage, brief, null, type, account, unit, price, discount);
        pdd.insertRec(pd);
        request.getRequestDispatcher(ADDPRODUCT).forward(request, response);
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
