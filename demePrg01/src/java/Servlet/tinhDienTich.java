/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manhc
 */
@WebServlet(name = "tinhDienTich", urlPatterns = {"/tinhdt"})
public class tinhDienTich extends HttpServlet {

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
            out.println(HoTro.hotro1.tieuDe("Tinh dien tich hinh hoc khong gian"));
            out.println("<body>");
            String tamgiac = request.getParameter("action");
            String tron = request.getParameter("action");
            if (tamgiac.equals("Loading")) {
                String canhA = request.getParameter("canhA");
                String canhB = request.getParameter("canhB");
                String canhC = request.getParameter("canhC");

                // Parse strings to double values
                double a = Double.parseDouble(canhA);
                double b = Double.parseDouble(canhB);
                double c = Double.parseDouble(canhC);

                // Calculate triangle area using Heron's formula
                double p = (a + b + c) / 2; // calculate the semi-perimeter
                double areaTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));

                out.println("<div class=\"alert alert-success\">Dien tich tam giac la " + areaTriangle + "</div>");
                out.println("<a href='index.html'>Home Page</a>");
            } else if (tron.equals("Loading1")) {
                String banKinh = request.getParameter("banKinh");

                // Parse string to double value
                double radius = Double.parseDouble(banKinh);

                // Calculate circle area
                double areaCircle = Math.PI * radius * radius;

                out.println("<div class=\"alert alert-success\">Dien tich hinh tron la " + areaCircle + "</div>");
                out.println("<span class=\"badge bg-secondary\"><a href='index.html'>Home Page</a></span>");
            }
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
