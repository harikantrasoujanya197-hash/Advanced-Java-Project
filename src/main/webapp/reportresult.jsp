<%@ page import="java.util.*, com.model.StudentMark" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<title>Report Result</title>
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="card">

<h2>Report Result</h2>

<table class="table">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Subject</th>
    <th>Marks</th>
</tr>

<%
List<StudentMark> list = (List<StudentMark>) request.getAttribute("list");

if(list != null && !list.isEmpty()){
    for(StudentMark s : list){
%>

<tr>
    <td><%= s.getStudentID() %></td>
    <td><%= s.getStudentName() %></td>
    <td><%= s.getSubject() %></td>
    <td><%= s.getMarks() %></td>
</tr>

<%
    }
} else {
%>
<tr>
    <td colspan="4">No records found</td>
</tr>
<%
}
%>

</table>

</div>

</body>
</html>