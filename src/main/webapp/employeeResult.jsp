<%@ page import="org.example.datenbankenprojekt.model.Employee"
%>

<%Employee e = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
</head>
<body>

<h1>Employee</h1>

<% if(e != null){ %>

SocNum:
<%= e.getSocNum() %>
<br>

Name:
<%= e.getFirstName() %>
<%= e.getLastName() %>
<br>

Employee Number:
<%= e.getEmpNum() %>

<% } else { %>

Not found.

<% } %>

<br><br>

<form action="createAccount.jsp" method="get">

    <button type="submit">Create Account</button>

</form>
</body>
</html>