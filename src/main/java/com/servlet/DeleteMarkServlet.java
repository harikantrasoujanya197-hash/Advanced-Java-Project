package com.servlet;

import com.dao.MarkDAO;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/DeleteMarkServlet")
public class DeleteMarkServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String idStr = request.getParameter("studentId");

            // DEBUG (IMPORTANT)
            System.out.println("Received ID = " + idStr);

            if (idStr == null || idStr.trim().isEmpty()) {
                response.getWriter().println("ID is required!");
                return;
            }

            int id = Integer.parseInt(idStr.trim());

            MarkDAO dao = new MarkDAO();
            dao.deleteMark(id);

            response.sendRedirect("markdisplay.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}