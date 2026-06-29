<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Employee</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

<h1>Add New Employee</h1>

<%-- Display a success or error message if the Servlet sends one back --%>
<% if (request.getAttribute("message") != null) { %>
<p style="color: blue; font-weight: bold;"><%= request.getAttribute("message") %></p>
<% } %>

<form action="createEmployee" method="post">
    <h3>Personal Details</h3>
    Social Security Number (SocNum): <input type="number" name="socNum" required><br><br>
    First Name: <input type="text" name="firstName" required><br><br>
    Last Name: <input type="text" name="lastName" required><br><br>
    Post Code: <input type="text" name="postCode"><br><br>
    Place/City: <input type="text" name="place"><br><br>
    Street: <input type="text" name="street"><br><br>
    House Number: <input type="number" name="houseNum"><br><br>

    <h3>Employee Details</h3>
    Employee Number (EmpNum): <input type="number" name="empNum" required><br><br>

    <button type="submit">Save Employee</button>
</form>

</body>
</html>