<%-- 
    Document   : some
    Created on : 19-Dec-2017, 4:54:39 AM
    Author     : Parteek Dheri 
--%>

<%@page import="in.parteek.feedme.logic.Client"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="assets/css/demo.css">
	<link rel="stylesheet" href="assets/css/header-basic-light.css">
	<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="commonHeader.jsp">
            
        </c:import>
        <h1>Welcome page</h1>
        <ul>
            <li>
                ${client.name}
            </li>
        </ul>
        <hr>

    </body>
</html>
