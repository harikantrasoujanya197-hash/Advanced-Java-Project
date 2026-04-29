<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <title>Add Marks</title>
</head>
<body>

<jsp:include page="navbar.jsp" />

<div class="card">
    <h2>Add Student Marks</h2>

    <% 
    String error = (String) request.getAttribute("error"); 
    if(error != null){ 
    %>
        <p style="color:red; font-weight:bold;"><%= error %></p>
    <% 
    } 
    %>
<form action="add" method="post">

    <input type="text" name="name" placeholder="Name" required><br>

    <input type="text" name="subject" placeholder="Subject" required><br>

    <input type="number" name="marks" placeholder="Marks" required><br>

    <input type="date" name="date" required><br>

    <button type="submit">Add</button>

</form>
    </form>
</div>

</body>
</html>