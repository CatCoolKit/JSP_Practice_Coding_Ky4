/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.user_DAO;
import Object.info_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author manhc
 */
public class control_Login extends HttpServlet {

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
            out.println("<title>Servlet control_Login</title>");
            out.println("</head>");
            out.println("<body>");
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
        // get current action
        String action = request.getParameter("action");

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("Back")) {
            url = "/index.jsp";
        } else if (action.equals("viewCookies")) {
            url = "";
        } else if (action.equals("deleteCookies")) {
            url = "";
        }

        // forward to the view
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
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
        user_DAO dao = new user_DAO();
        boolean test = false;

        // perform action and set URL to appropriate page
        String url = "/index.jsp";
        if (action.equals("loginUser")) {
            int check = 0;
            // get the user data
            String userID = request.getParameter("userID");
            String password = request.getParameter("password");
            int ps = 0;
            try {
                ps = Integer.parseInt(password);

                // Các thao tác khác nếu cần
            } catch (NumberFormatException e) {
                // Xử lý lỗi khi không thể chuyển đổi thành số nguyên
                e.printStackTrace(); // In ra thông báo lỗi hoặc thực hiện các xử lý cụ thể khác
            }

            // Kiểm tra điều kiện đăng nhập
            HttpSession session = request.getSession(true);

            if (session.getAttribute("loginAttempts") == null) {
                // Nếu chưa có thông tin về số lần đăng nhập, khởi tạo
                session.setAttribute("loginAttempts", 0);
                session.setAttribute("lastLoginAttempt", new Date());
            }
            int loginAttempts = (int) session.getAttribute("loginAttempts");
            Date lastLoginAttempt = (Date) session.getAttribute("lastLoginAttempt");

            // Kiểm tra số lần đăng nhập sai và thời điểm cách đây bao lâu
            if (loginAttempts >= 5) {
                // Nếu đã nhập sai quá 5 lần, kiểm tra thời gian đã cách đây bao lâu
                long timeElapsed = new Date().getTime() - lastLoginAttempt.getTime();
                long tenMinutesInMillis = 10 * 60 * 1000; // 10 phút

                if (timeElapsed < tenMinutesInMillis) {
                    check = 1;
                    // Nếu cách đây chưa đầy 10 phút, chuyển hướng về trang đăng nhập với thông báo
                    request.setAttribute("loginStatus", "locked");
                    request.getRequestDispatcher("error_java.jsp").forward(request, response);
                    
                } else {
                    // Nếu đã đầy 10 phút, reset số lần đăng nhập sai
                    session.setAttribute("loginAttempts", 0);
                    session.setAttribute("lastLoginAttempt", new Date());
                    check = 0;
                }
            }

            // store the data in a User object
            info_User user = new info_User();
            user.setUserId(userID);
            user.setPassword(ps);
            session.setAttribute("userT", user);

            ArrayList<info_User> ketQua = dao.selectAll();
            for (info_User user1 : ketQua) {
                if (user1.userId.equals(user.userId) && user1.password == user.password) {
                    test = true;
                    break;
                }
            }
            if (test == true && check == 0) {
                
                session.setAttribute("loginAttempts", 0);
                session.setAttribute("lastLoginAttempt", new Date());
                response.sendRedirect("Home_Page.jsp");
            } else if (test == false && check == 0) {
                // Đăng nhập không thành công, tăng số lần đăng nhập sai
                loginAttempts++;
                session.setAttribute("loginAttempts", loginAttempts);
                // Set thông báo lỗi và chuyển hướng về trang đăng nhập
                session.setAttribute("loginStatus", "failed");
                session.setAttribute("userT", null);
                response.sendRedirect("index.jsp");

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
