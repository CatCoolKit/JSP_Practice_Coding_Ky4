/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author manhc
 */
public class XuLy extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            Date date = new Date();
            String message = "Hôm này là ngày: ";
            // TODO: insert code to write html before writing the body content.
            int t = date.getDay();
            String[] thu = {"Chủ Nhật ", "Thứ Hai ", "Thứ Ba ", "Thứ Tư ", "Thứ Năm ", "Thứ Sáu ", "Thứ Bảy "};
            message += thu[t];
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            message += df.format(date);
            df = new SimpleDateFormat("hh:mm:ss");
            message += ", Bây giờ là: " + df.format(date);
            
            out.print(message);
            
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in XuLy tag", ex);
        }
    }

}
