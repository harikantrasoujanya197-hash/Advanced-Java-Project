package com.servlet;

import com.dao.MarkDAO;
import com.model.StudentMark;
import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            MarkDAO dao = new MarkDAO();
            String type = request.getParameter("type");
            System.out.println("TYPE = " + type);

            List<StudentMark> list = new ArrayList<>();

            if (type == null) {
                response.getWriter().println("Report type missing!");
                return;
            }

            if (type.equals("above")) {

                String marksStr = request.getParameter("marks");
                if (marksStr != null && !marksStr.isEmpty()) {
                    int marks = Integer.parseInt(marksStr);
                    list = dao.getStudentsAboveMarks(marks);
                }

            } else if (type.equals("subject")) {

                String subject = request.getParameter("subject");
                if (subject != null && !subject.isEmpty()) {
                    list = dao.getStudentsBySubject(subject);
                }

            } else if (type.equals("top")) {

                String topStr = request.getParameter("top");
                if (topStr != null && !topStr.isEmpty()) {
                    int top = Integer.parseInt(topStr);
                    list = dao.getTopNStudents(top);
                }
            }

            request.setAttribute("list", list);
            request.getRequestDispatcher("reportresult.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}