<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Reports</title>
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="card">

<h2>Reports</h2>

<form action="ReportServlet" method="get">
    <input type="number" name="marks" placeholder="Marks Above">
    <button class="btn btn-blue" name="type" value="above">Get</button>
</form>

<form action="ReportServlet" method="get">
    <input type="text" name="subject" placeholder="Subject">
    <button class="btn btn-green" name="type" value="subject">Get</button>
</form>

<form action="ReportServlet" method="get">
    <input type="number" name="top" placeholder="Top N Students">
    <button class="btn btn-orange" name="type" value="top">Get</button>
</form>

</div>

</body>
</html>