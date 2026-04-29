<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mark Management System</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;

            /* Background Image */
            
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }

        /* Title */
        .title {
            text-align: center;
            color: blue;
            margin-top: 40px;
            font-size: 38px;
            text-shadow: 2px 2px 5px black;
        }

        /* Container */
        .container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            margin-top: 50px;
        }

        /* Box Style */
        .box {
            width: 230px;
            height: 150px;
            margin: 15px;
            border-radius: 15px;

            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;

            background: rgba(255, 255, 255, 0.2);
            backdrop-filter: blur(8px);

            box-shadow: 0px 8px 20px rgba(0,0,0,0.4);
            transition: 0.3s;
        }

        /* Image */
        .box img {
            width: 50px;
            height: 50px;
            margin-bottom: 10px;
        }

        /* Text */
        .box a {
            color: purple;
            font-size: 18px;
            text-decoration: none;
            font-weight: bold;
        }

        /* Hover Effect */
        .box:hover {
            transform: translateY(-10px) scale(1.05);
            cursor: pointer;
        }
    </style>

</head>

<body>

<h2 class="title">MARK MANAGEMENT SYSTEM</h2>

<div class="container">

    <div class="box">
        <img src="add.jpg">
        <a href="marksadd.jsp">Add Marks</a>
    </div>

    <div class="box">
        <img src="update.jpg">
        <a href="markupdate.jsp">Update Marks</a>
    </div>

    <div class="box">
        <img src="delete.png">
        <a href="markdelete.jsp">Delete Marks</a>
    </div>

    <div class="box">
        <img src="display.jpg">
        <a href="markdisplay.jsp">Display Marks</a>
    </div>

    <div class="box">
        <img src="report.jpeg">
        <a href="report_form.jsp">Reports</a>
    </div>

</div>

</body>
</html>