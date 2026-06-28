<%@ page import="org.example.datenbankenprojekt.model.BankAccount"%>

<%BankAccount a = (BankAccount) request.getAttribute("account");%>

<html>
<body>

<h1>Bank Account</h1>

<% if(a != null){ %>

Bank:
<%= a.getBankNum() %>
<br>

Account:
<%= a.getAccountNum() %>
<br>

Balance:
<%= a.getBalance() %>

<% } else { %>

Account not found

<% } %>

</body>
</html>