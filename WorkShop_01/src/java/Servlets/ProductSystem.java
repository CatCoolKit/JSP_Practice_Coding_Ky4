/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.dao.ProductDAO;

/**
 *
 * @author manhc
 */
public class ProductSystem extends HttpServlet {
    private final String UPDATE_PRODUCT = "productUpdate.jsp";

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
            request.setAttribute("PRODUCT", list);

            out.println("<div class=\"table-responsive\"><table class=\"table table-tripped table-hover\"><tr>\n"
                    + "                    <td>ProductId</td>\n"
                    + "                    <td>ProductName</td>\n"
                    + "                    <td>ProductImage</td>\n"
                    + "                    <td>Brief</td>\n"
                    + "                    <td>PostedDate</td>\n"
                    + "                    <td>Type</td>\n"
                    + "                    <td>Account</td>\n"
                    + "                    <td>Unit</td>\n"
                    + "                    <td>Price</td>\n"
                    + "                    <td>Discount</td>\n"
                    + "                    <td>Action</td>\n"
                    + "                </tr>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (Product product : list) {
                NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
                currencyFormat.setCurrency(Currency.getInstance("VND"));
                String priceFormatted = currencyFormat.format(product.getPrice());
                out.println("<tr class=\"account-row\">\n"
                        + "                            <td>" + product.getProductId() + "</td>\n"
                        + "                            <td>" + product.getProductName() + "</td>\n"
                        + "                            <td>" + product.getProductImage() + "</td>\n"
                        + "                            <td>" + product.getBrief() + "</td>\n"
                        + "                        <td>\n"
                        + sdf.format(product.getPostedDate())
                        + "                    </td>\n"
                        + "                            <td>" + product.getType().getTypeId() + "</td>\n"
                        + "                            <td>" + product.getAccount().getAccount() + "</td>\n"
                        + "                            <td>" + product.getUnit() + "</td>\n"
                        + "                            <td>" + priceFormatted + "</td>\n"
                        + "                            <td>" + product.getDiscount() + "</td>\n"
                        + "                            <td>\n"
                     
                        + "                                <button class=\"btn btn-primary\" value=\"UPD#"+product.getProductId()+"\" onclick=\"validateForm(event)\">Update</button>\n"
                        + "                                <button class=\"btn btn-danger\" value=\"DEL#"+product.getProductId()+"\" onclick=\"validateForm(event)\">Delete</button>\n"
                        + "                            </td>\n"
                        + "                        </tr>");
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
        // Lấy các thông tin gửi từ ajax
        String productId = request.getParameter("productId");
        String status = request.getParameter("status");
        ProductDAO p = new ProductDAO();
        Product x = p.getObjectById(productId);
        switch (status) {
            case "UPD":
                HttpSession sess = request.getSession();
                sess.setAttribute("PRD", x);
                response.sendRedirect(UPDATE_PRODUCT);
                break;
            case "DEL":
                p.deleteRec(x);
                break;
            default:
                // Xử lý trường hợp không xác định được
                break;
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
