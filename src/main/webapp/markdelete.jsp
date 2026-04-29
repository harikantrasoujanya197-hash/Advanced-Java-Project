<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Delete Marks</title>
</head>

<body>

<jsp:include page="navbar.jsp" />

<div class="card">
    <h2>Delete Student Record</h2>

    <form action="${pageContext.request.contextPath}/DeleteMarkServlet" method="post">

        <input type="number" name="studentId" placeholder="Enter Student ID" required>

        <button class="btn btn-red" type="submit">Delete</button>

    </form>
</div>

</body>
</html>