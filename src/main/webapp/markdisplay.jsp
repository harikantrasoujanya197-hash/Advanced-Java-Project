
<%@ page import="java.util.*, com.dao.MarkDAO, com.model.StudentMark" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Display Marks</title>
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="card wide">

<h2>All Student Marks</h2>

<%
    MarkDAO dao = new MarkDAO();
    List<StudentMark> list = dao.getAllMarks();
%>

<table class="table">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
    <th>Date</th>
</tr>

<%
    for(StudentMark s : list){
%>
<tr>
    <td><%= s.getStudentID() %></td>
    <td><%= s.getStudentName() %></td>
    <td><%= s.getSubject() %></td>
    <td><%= s.getMarks() %></td>
    <td><%= s.getExamDate() %></td>
</tr>
<%
    }
%>

</table>

</div>

</body>
</html>