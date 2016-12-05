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
    <th>Patron Name</th>
    <th>Email Address</th>
    <th>Book Title</th>
    <th>Due Date</th>
    <th>Overdue</th>
  </tr>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <c:forEach var="user" items="${users}">
  <tr>
    <td>${user.firstName}</td>
    <td>${user.emailAddress}</td>
    <td>${user.bookTitle}</td>
    <td>${user.dueDate}</td>
    <td>${user.overdue}</td>
    <td><a href="library?action=delete_user&amp;email=${user.emailAddress}&amp;bookTitle=${user.bookTitle}">Check in</a></td>
  </tr>
  </c:forEach>

</table>

<p><a href="library?action=return">Return to Front Page</p></a>
 </div>
        <footer>
    <%@ include file="/includes/footer.jsp" %>       
  </footer>
</body>
</html>