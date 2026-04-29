package com.servlet;



	import java.io.IOException;
	import java.util.*;
	import javax.servlet.*;
	import javax.servlet.http.*;
	import javax.servlet.annotation.WebServlet;

	import com.dao.MarkDAO;
	import com.model.StudentMark;

	@WebServlet("/ReportCriteria")
	public class ReportCriteriaServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {

	        try {
	            String subject = req.getParameter("subject");

	            MarkDAO dao = new MarkDAO();
	            List<StudentMark> all = dao.getAllMarks();

	            List<StudentMark> result = new ArrayList<>();

	            for (StudentMark s : all) {
	                if (s.getSubject().equalsIgnoreCase(subject)) {
	                    result.add(s);
	                }
	            }

	            req.setAttribute("data", result);

	            RequestDispatcher rd = req.getRequestDispatcher("report_result.jsp");
	            rd.forward(req, res);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

