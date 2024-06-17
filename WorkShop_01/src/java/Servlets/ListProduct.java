/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.dao.ProductDAO;

/**
 *
 * @author manhc
 */
public class ListProduct extends HttpServlet {

    private final String HOME = "homePage.jsp";

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
            ProductDAO pd = new ProductDAO();
            List<Product> list = pd.listAll();
            request.setAttribute("dssp", list);
            //request.getRequestDispatcher(HOME).forward(request, response);
            for (Product product : list) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                currencyFormat.setCurrency(Currency.getInstance("VND"));
                String priceFormatted = currencyFormat.format(product.getPrice());
                out.println("<div class=\"media col-lg-3 col-md-4 col-sm-6 col-xs-12\">\n"
                        + "                    <div class=\"media-left\">\n"
                        + "                        <img src=\""+(product.getProductImage().startsWith("/") ? product.getProductImage().substring(1) : product.getProductImage())+"\" alt=\"card image cap\" style=\"width: 100%; height: auto;\">\n"
                        + "                    </div>\n"
                        + "                    <div class=\"media-body\">\n"
                        + "                        <h4 class=\"media-heading\">"+product.getProductName()+"</h4>\n"
                        + "                        <p class=\"brief\">"+product.getBrief()+"</p>\n"
                        + "                        <p> <span class=\"left\"> Price : <b>"+priceFormatted+"</b></span>\n"
                        + "                            <c:if test=\""+product.getDiscount()+"\">\n"
                        + "                                <span class=\"rightSpan red\">Discount: <b>"+product.getDiscount()+"</b></span>\n"
                        + "                            </c:if>\n"
                        + "                        </p>\n"
                        + "                    </div>\n"
                        + "                </div>");
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
