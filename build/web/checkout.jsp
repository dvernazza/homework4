<%-- 
    Document   : checkout
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
            <h2>Check out a book</h2>
            <form action="libraryCheckout" method="post" >  
                <input type="hidden" name="action" value="add">
                <label class="pad_top">First name:</label>
                <input name="firstName" type="text" id="firstname" required ><br>
                <label class="pad_top">Last name:</label>
                <input name="lastName" type="text" id="lastname" required ><br>
                <label class="pad_top">Email:</label>
                <input name="emailAddress" type="email" class="text" id="email" required><br>
                <label class="pad_top" id="length">Book Title:</label>
                <input class="length" name="bookTitle" type="text" id="title" required><br>
              <input type="submit" value="Checkout" class="margin_left">
            </form>
        </div>
  <footer>
    <%@ include file="/includes/footer.jsp" %>       
  </footer>
    </body>
</html>
