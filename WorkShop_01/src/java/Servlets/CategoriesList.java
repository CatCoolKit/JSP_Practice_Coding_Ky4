/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Category;
import model.dao.CategoryDAO;

/**
 *
 * @author manhc
 */
public class CategoriesList extends HttpServlet {
    private final String UPDATE_CATEGORY = "categoriesList.jsp";

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
            CategoryDAO cate = new CategoryDAO();
            HttpSession ss = request.getSession();
            List<Category> listCate = cate.listAll();
            ss.setAttribute("CATEGORIES", listCate);

            out.println("<div class=\"table-responsive\"><table class=\"table table-tripped table-hover\"><tr>\n"
                    + "                    <td>TypeId</td>\n"
                    + "                    <td>Category Name</td>\n"
                    + "                    <td>Memo</td>\n"
                    + "                    <td>Action</td>\n"
                    + "                </tr>");
            for (Category category : listCate) {
                out.println("<tr class=\"account-row\">\n"
                        + "                            <td>" + category.getTypeId() + "</td>\n"
                        + "                            <td>" + category.getCategoryName() + "</td>\n"
                        + "                            <td>" + category.getMemo() + "</td>\n"
                        + "                            <td>\n"
                        + "                                <button class=\"btn btn-primary\" value=\"UPD#" + category.getTypeId() + "\" onclick=\"validateForm(event)\">Update</button>\n"
                        + "                                <button class=\"btn btn-danger\" value=\"DEL#" + category.getTypeId() + "\" onclick=\"validateForm(event)\">Delete</button>\n"
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
        String categoryId = request.getParameter("categoryId");
        String status = request.getParameter("status");
        CategoryDAO p = new CategoryDAO();
        Category x = p.getObjectById(categoryId);
        switch (status) {
            case "UPD":
                HttpSession sess = request.getSession();
                sess.setAttribute("CTG", x);
                response.sendRedirect(UPDATE_CATEGORY);
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
