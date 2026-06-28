<%@ page import="java.util.List" %>
<%@ page import="org.example.datenbankenprojekt.model.Employee" %>

<%List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employees</title>
</head>
<body>

<h1>All Employees</h1>

<table border="1">

    <tr>
        <th>SocNum</th>
        <th>Name</th>
        <th>EmpNum</th>
    </tr>

    <%for(Employee e : employees){%>

    <tr>
        <td><%= e.getSocNum() %></td>

        <td>
            <%= e.getFirstName() %>
            <%= e.getLastName() %>
        </td>

        <td><%= e.getEmpNum() %></td>
    </tr>

    <%}%>

</table>

</body>
</html>