<!DOCTYPE html>
<html>
<body>
<%@ include file="navbar.jsp" %>

<h1>Search for BankAccount</h1>

<form action="searchAccount"
      method="post">

    Bank Number:
    <input type="number" name="bankNum">

    <br><br>

    Account Number:
    <input type="number" name="accountNum">

    <br><br>

    <button>Search</button>

</form>

</body>
</html>