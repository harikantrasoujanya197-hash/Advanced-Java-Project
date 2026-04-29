package com.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.dao.MarkDAO;
import com.model.StudentMark;

@WebServlet("/add")
public class AddMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
        	 System.out.println("STEP 1: Request received");
            String name = req.getParameter("name");
            String subject = req.getParameter("subject");
            String marksStr = req.getParameter("marks");
            String dateStr = req.getParameter("date");

            // ✅ Validate empty marks
            if (marksStr == null || marksStr.trim().isEmpty()) {
                req.setAttribute("error", "Marks required!");
                req.getRequestDispatcher("marksadd.jsp").forward(req, res);
                return;
            }

            int marks = Integer.parseInt(marksStr);

            // ❌ Negative check
            if (marks < 0) {
                req.setAttribute("error", "Marks cannot be negative!");
                req.getRequestDispatcher("marksadd.jsp").forward(req, res);
                return;
            }

            // ✅ Create object (NO ID HERE)
            StudentMark s = new StudentMark();
            s.setStudentName(name);
            s.setSubject(subject);
            s.setMarks(marks);
            s.setExamDate(Date.valueOf(dateStr));
            
            System.out.println("STEP 2: Before DB call");

            // ✅ DAO call
            MarkDAO dao = new MarkDAO();
           dao.addMark(s);
            
            System.out.println("STEP 3: After DB call");

            // 🔥 Redirect after success
            res.sendRedirect("marksadd.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("Error: " + e.getMessage());
        }
    }
}