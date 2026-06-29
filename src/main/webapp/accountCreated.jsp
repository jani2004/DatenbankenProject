<%Boolean success = (Boolean) request.getAttribute("success");%>

<html>
<body>
<%@ include file="navbar.jsp" %>
<% if(success){ %>
<h2>Account added to the database.</h2>

<% } else { %>

<h2>
    Error. Account couldn't get added to the database.
</h2>

<% } %>

</body>
</html>