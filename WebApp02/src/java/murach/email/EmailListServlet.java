package murach.email;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.*;
import javax.servlet.http.*;
import murach.business.User;
import murach.data.UserDB;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";
        
        // initialize the current year that's used in the copyright notice
        GregorianCalendar currentDate = new GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        request.setAttribute("currentYear", currentYear);
        
        // get current action
        String action = request.getParameter("action");
        
        // print action value to console AND log file
        System.out.println("EmailListServlet action: " + action);
        log("action=" + action);
        
        // set default action
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        if (action.equals("Back")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String[] music = {};
            music = request.getParameterValues("music");
            String res = "";
            //response.getWriter().print(music.length);
            if (music != null) {
                res = res + music[0];
                for (int i = 1; i < music.length; i++) {
                    res = res + "," + music[i];
                }
            }
            
            // store data in User object
            User user = new User(firstName, lastName, email, res);

            // validate the parameters
            String message = "", message1 = "", message2 = "", message3 = "";
            if (firstName == null || lastName == null || email == null ||
                    firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                if(firstName.isEmpty() && lastName.isEmpty() && email.isEmpty()){
                    message = "Please fill out all three text boxes.";
                    request.setAttribute("message", message);
                }
                else if(email.isEmpty()){
                    message1 = "Email is Empty.";
                    request.setAttribute("message1", message1);
                }
                else if(firstName.isEmpty()){
                    message2 = "FistName is Empty.";
                    request.setAttribute("message2", message2);
                }
                else if(lastName.isEmpty()){
                    message3 = "LastName is Empty.";
                    request.setAttribute("message3", message3);
                }
                
                url = "/index.jsp";
            } 
            else {
                String path = request.getServletContext().getRealPath(getInitParameter("relativePathToFile"));
                //response.getWriter().print(music[0]);
                UserDB userDB = new UserDB();
                if(userDB.emailExisted(email,path)){
                    url = "/index.jsp";
                    message1 = "Email is existed";
                    request.setAttribute("message1", message1);
                }else{
                    url = "/thanks.jsp";
                    UserDB.insert(user, path);
                }
            }
            request.setAttribute("user", user);
            
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}