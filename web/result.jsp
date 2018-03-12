<%-- 
    Document   : result
    Created on : 20-Dec-2017, 4:21:27 AM
    Author     : Parteek Dheri 
--%>

<%@page import="in.parteek.feedme.logic.*"%>
<%@ taglib uri="WEB-INF/MyTagLib.tld" prefix="av" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/demo.css">
        <link rel="stylesheet" href="assets/css/header-basic-light.css">
        <link rel="stylesheet" href="assets/css/table.css">
        <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
        <title>Results</title>
    </head>
    <style>
        #map {
            width: 100%;
            height: 400px;
            background-color: aqua;
        }
        #div1{
            position:absolute;
            border: 1px black solid;
            padding: 5px;
            left: 2%;
            font-size:20px;
        }
        #div2{
            position:absolute;
            border: 1px black solid;
            padding: 5px;
            right: 2%;
            font-size:20px;
        }
        #btn1{
            position:absolute;
            left:60%;
        }
        #btn2{
            position:absolute;
            left:110%;
        }
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 16px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            cursor: pointer;
        }
        .button3 {
            background-color: white; 
            color: black; 
            border: 2px solid #f44336;
        }

        .button3:hover {
            background-color: #f44336;
            color: white;
        }

    </style>
    <body>
        <c:import url="commonHeader.jsp">

        </c:import>
    <center><b> <span style="color:red;font-size:24px;">Hello: ${client.name}</span></b></center>
    <hr> 


    <a href="add" style="text-decoration:none; color:black">
        <div id="div1">

            <pre>    
Click here
 to see Top 50 clients</pre>


        </div> 
    </a>


    <a href="map.jsp" style="text-decoration:none; color:black"> 
        <div id="div2">
            <pre>    
Click here to
go back</pre>



        </div></a>


    <div class="table-users">
        <div class="header">Restaurants Location</div>

        <table cellspacing="0">


            <c:forEach var="r" items='${rests}'>
                <tr>          
                    <td> <av:Direction restaurant="${r}" /> </td>
                    <td> ${r.vicinity}</td>
                </tr> 

            </c:forEach>

            <tr>
                <td colspan="2">
                    <div id="map">

                    </div>

                </td>
            </tr>      
        </table>
    </body>


    <!-- Danger Zone  -->
    <!-- Just JavaScript don't mess with this  -->


    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=dummy_KEY&callback=initMap">
    </script>

    <script>

        var home;
        var lt;
        var lg;
        getLocation();

        function initMap() {
        <%
            Object ob = request.getAttribute("rests");
            Object[] obr = (Object[]) ob;
            Restaurant[] rests = (Restaurant[]) obr;
        %>


            var L1 = <%= rests[0].getGeometry().getLocation().toJson()%>;
            var L2 = <%= rests[1].getGeometry().getLocation().toJson()%>;
            var L3 = <%= rests[2].getGeometry().getLocation().toJson()%>;


            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 12,
                center: {lat: 43.6560544, lng: -79.7415324}
            });

            bounds = new google.maps.LatLngBounds();

            var marker = new google.maps.Marker({
                position: L1,
                label: 'A',
                map: map
            });
            loc = new google.maps.LatLng(L1);
            bounds.extend(loc);



            var marker2 = new google.maps.Marker({
                position: L2,
                label: 'B',
                map: map
            });

            loc = new google.maps.LatLng(L2);
            bounds.extend(loc);



            var marker3 = new google.maps.Marker({
                position: L3,
                label: 'C',
                map: map
            });

            loc = new google.maps.LatLng(L3);
            bounds.extend(loc);

//---------------Home marker, does'nt run properly  :(
//
//            var markerH = new google.maps.Marker({
//                position: {lat: lt, lng: lg},
//                icon: {
//                    path: google.maps.SymbolPath.CIRCLE,
//                    scale: 10
//                },
//                draggable: true,
//                map: map
//            });
//
//            loc = new google.maps.LatLng({lat: lt, lng: lg});
//            bounds.extend(loc);
//

            map.fitBounds(bounds);  //auto zoom
            map.panToBounds(bounds); // auto center




        }

//        function getLocation() {
//            if (navigator.geolocation) {
//                navigator.geolocation.getCurrentPosition(showPosition);
//            }
//        }
//
//        function showPosition(position) {
//            lt = position.coords.latitude;
//            lg = position.coords.longitude;
//
//        }

    </script>



</html>
