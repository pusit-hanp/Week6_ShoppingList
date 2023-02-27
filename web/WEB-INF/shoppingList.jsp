<%-- 
    Document   : shoppingList
    Created on : Feb 26, 2023, 9:23:27 PM
    Author     : pusit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p> Hello, ${username} ><a href="?action=logout">Logout</a></p>
        <h2>List</h2>
        
        <form action="?action=add" method="post">
            <label for="item">Add item: <input type="text" name="item">
                <input type="submit" value="add">
        </form>
        
        <form action="?action=delete" method="post">
            <c:forEach var="item" items="${items}" varStatus="itemIndex">
                <input type="radio" name="item" value="${itemIndex.index}">${item}<br>
            </c:forEach>
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
