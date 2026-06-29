<!DOCTYPE html>
<html>
<head>
    <title>Employee Search</title>
</head>
<body>
<%@ include file="navbar.jsp" %>

<h1>Employee Search</h1>

<form action="searchEmployee" method="post">

    Social Security Number:

    <input type="number" name="socnum">

    <button type="submit">search</button>

</form>