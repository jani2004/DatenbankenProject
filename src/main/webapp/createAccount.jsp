<html>
<body>
<%@ include file="navbar.jsp" %>


<h1>Konto anlegen</h1>

<form action="createAccount"
      method="post">

    Bank Number:<input name="bankNum">

    <br>

    Account Number:<input name="accountNum">

    <br>

    Balance:<input name="balance">

    <br>

    <button>Save</button>

</form>

</body>
</html>