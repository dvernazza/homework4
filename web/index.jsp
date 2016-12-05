<%-- 
    Document   : index
    Created on : Nov 27, 2016, 2:54:42 PM
    Author     : dvernazza
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
        </header>
        <h1>Belk Library</h1>
        <div class="block">
            <h4><a href="library?action=check">Check out a book</h4></a>
            <h4><a href="library?action=checkoutBook">Manage checked out books</h4>
        </div>
        <footer>
    <%@ include file="/includes/footer.jsp" %>       
  </footer>
    </body>
</html>
