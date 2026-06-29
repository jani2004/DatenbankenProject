<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Bank Accounts</title>
</head>
<body>

<%@ include file="navbar.jsp" %>

<h1>All Bank Accounts</h1>

<% if (request.getAttribute("error") != null) { %>
<p style="color: red;"><%= request.getAttribute("error") %></p>
<% } %>

<table border="1" style="border-collapse: collapse;">
    <thead>
    <tr>
        <th>Bank Number</th>
        <th>Account Number</th>
        <th>Balance</th>
        <th>Owner (Employee)</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Map<String, String>> accounts = (List<Map<String, String>>) request.getAttribute("accounts");
        if (accounts != null && !accounts.isEmpty()) {
            for (Map<String, String> acc : accounts) {
    %>
    <tr>
        <td><%= acc.get("bankNum") %></td>
        <td><%= acc.get("accountNum") %></td>
        <td><%= acc.get("balance") %></td>
        <td><%= acc.get("owner") %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No accounts found in the database.</td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>