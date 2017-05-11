package ua.kiev.prog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet(name = "FormServlet", urlPatterns = "/form")
public class FormServlet extends HttpServlet {
    static final List<String> list = new ArrayList<String>();
    static final int Q1_YES = 0;
    static final int Q1_NO = 1;
    static final int Q2_YES = 2;
    static final int Q2_NO = 3;

    static final int[] arr = new int[4];
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        list.add(req.getParameter("name") + " " + req.getParameter("surname") + " " + req.getParameter("age") + " years");
        String question1 = req.getParameter("firstQuestion");
        String question2 = req.getParameter("secondQuestion");
        int q1 = question1.equals("yes")? Q1_YES : Q1_NO;
        int q2 = question2.equals("yes")? Q2_YES : Q2_NO;
        arr[q1]++;
        arr[q2]++;

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html><head><title>Form</title></head>");
        pw.println("<body><p>" + list.toString() + "</p>");
        pw.println("FirstQuestion: Yes - " + arr[0] + "; No - " + arr[1] + "<br>");
        pw.println("SecondQuestion: Yes - " + arr[0] + "; No - " + arr[1] + "</body></html>");
    }
}
