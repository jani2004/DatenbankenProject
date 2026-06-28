<%@ page
        import=
                "org.example.datenbankenprojekt.model.Employee"
%>

<%
    Employee e =
            (Employee)
                    request.getAttribute(
                            "employee");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Employee</title>
</head>
<body>

<h1>Mitarbeiter</h1>

<% if(e != null){ %>

SVNR:
<%= e.getSocNum() %>
<br>

Name:
<%= e.getFirstName() %>
<%= e.getLastName() %>
<br>

Mitarbeiternummer:
<%= e.getEmpNum() %>

<% } else { %>

Nicht gefunden.

<% } %>

</body>
</html>