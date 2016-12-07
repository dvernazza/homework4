<%-- 
    Document   : manager
    Created on : Nov 27, 2016, 2:54:42 PM
    Author     : dvernazza and tyoung
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CSC330 Homework 4</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="./style/main.css">
</head>
<body>
<header>
            <img src="./images/belk-02.jpg" alt="Belk Library" class="belk">
            <h1>Belk Library</h1>
</header>
  <div class="block">
    <h2>Currently checked out books</h2>
            
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
    <td><a href="library?action=delete_user&amp;email=${user.emailAddress}&amp;bookTitle=${user.bookTitle}"><input type="submit" value="Check in" class="margin_left"></a></td>
  </tr>
  </c:forEach>

</table>

  <p><a href="library?action=return">Return to Front Page</a></p>
 </div>
        <footer>
    <%@ include file="/includes/footer.jsp" %>       
  </footer>
</body>
</html>