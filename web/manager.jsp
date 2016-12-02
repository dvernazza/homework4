<%-- 
    Document   : manager
    Created on : Nov 27, 2016, 2:54:42 PM
    Author     : dvernazza
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>CSC330 Homework 4</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<header>
            <img src="./images/belk-02.jpg" alt="Belk Library" class="belk">
        </header>
<h1>Belk Library</h1>
        <div class="block">

<table>

  <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th colspan="3">Email</th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="user" items="${users}">
  <tr>
    <td>${user.firstName}</td>
    <td>${user.lastName}</td>
    <td>${user.emailAddress}</td>
    <td><a href="libraryCheckout?action=display_user&amp;email=${user.emailAddress}">Update</a></td>
    <td><a href="libraryCheckout?action=delete_user&amp;email=${user.emailAddress}">Delete</a></td>
  </tr>
  </c:forEach>

</table>

<p><a href="libraryCheckout">Refresh</a></p>
 </div>
        <footer>
    <%@ include file="/includes/footer.jsp" %>       
  </footer>
</body>
</html>