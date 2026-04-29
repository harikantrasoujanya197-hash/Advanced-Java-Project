<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Update Marks</title>
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="card">

<h2>Update Marks</h2>

<form action="UpdateMarkServlet" method="post">

    <input type="number" name="studentId" placeholder="Student ID" required>
    <input type="number" name="marks" placeholder="Enter New Marks" required>

    <button class="btn btn-green">Update</button>

</form>

<%
    String msg = request.getParameter("msg");
    if ("updated".equals(msg)) {
%>
    <p class="success">✔ Marks Updated Successfully</p>
<%
    }
%>

</div>

</body>
</html>