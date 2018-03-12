<%-- 
    Document   : view
    Created on : Dec 30, 2017, 6:52:33 AM
    Author     : ishan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/table.css">
        <link rel="stylesheet" href="assets/css/demo.css">
        <link rel="stylesheet" href="assets/css/header-basic-light.css">
        <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
        <title> Clients</title>
    </head>
    <body>
        <c:import url="commonHeader.jsp">

        </c:import>

        <div class="table-users">
            <div class="header">Users</div>

            <table cellspacing="0">
                <tr>
                    <th>Name</th>
                    <th>Visits</th>
                </tr>


                <c:forEach var="client" items='${topClients}'>
                    <tr>          
                        <td> ${client.name}</td>
                        <td> ${client.id}</td>
                    </tr> 

                </c:forEach>
            </table>
    </body>
</html>
