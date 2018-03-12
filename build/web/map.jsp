<%-- 
    Document   : map
    Created on : 13-Dec-2017, 10:33:10 PM
    Author     : Parteek Dheri 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Map</title>
        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
        <link rel="stylesheet" href="assets/css/demo.css">
        <link rel="stylesheet" href="assets/css/header-basic-light.css">
        <link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>
        <meta charset="utf-8">
        <style>
            /* Always set the map height explicitly to define the size of the div
             * element that contains the map. */
            #map {

                height: 55%;
                width: 50%;
                position: relative;
                left:100px;
                border-radius: 25px;
                border: 2px solid #73AD21;


            }
            /* Optional: Makes the sample page fill the window. */
            html, body {
                height: 100%;
                margin: 0;
                border: 1px saddlebrown solid;
                padding: 5px;
                background-color:  black;
                overflow-y: hidden;
            }

            #textf{

                position: relative;
                /*                always give position with percentage*/
                left:60%;
                bottom:300px;

                height: 800px;
                width:600px;
                color:oldlace;
                font-size:20px;
            }

            #texts{

                position: static;
                /*                always give position with percentage*/
                top:200px;


                height: 20%;
                width:40%;
                color:white;
                font-size:20px;
            }



            .center-wrap {
                position: absolute;
                top: calc(50% - 100px);
                left: calc(50% - 125px);
                width: 250px;
                height: 200px;
            }

            .button {
                position: relative;
                display: block;
                background: none center center no-repeat;
                background-size: cover;
                border: 2px solid #2e2e2e;
                text-transform: uppercase;
                letter-spacing: .3rem;
                padding: 20px 15px;
                text-align: center;
                max-width: 270px;
                min-width: 200px;
                cursor: pointer;
                overflow: hidden;
                -webkit-transition: border 1s cubic-bezier(0.19,1,.22,1),color .6s cubic-bezier(0.19,1,.22,1);
                transition: border 1s cubic-bezier(0.19,1,.22,1), color .6s cubic-bezier(0.19,1,.22,1), background 5s cubic-bezier(0.19,1,.22,1);
            }

            .button a {
                color: #969696;
                font-family: 'Varela Round';
                text-decoration: none;
            }

            .button .mask {
                background: #fff;
                background: rgba(255,255,255,0.5);
            }

            .button .mask {
                position: absolute;
                display: block;
                width: 200px;
                height: 100px;
                -webkit-transform: translate3d(-120%,-50px,0) rotate3d(0,0,1,45deg);
                transform: translate3d(-120%,-50px,0) rotate3d(0,0,1,45deg);
                -webkit-transition: all 1.1s cubic-bezier(0.19,1,.22,1);
                transition: all 1.1s cubic-bezier(0.19,1,.22,1);
            }

            .button .shift {
                -webkit-transition: all 1.1s cubic-bezier(0.19,1,.22,1);
                transition: all 1.1s cubic-bezier(0.19,1,.22,1);
            }

            .button:hover {
                border-color: #fff;
                /* box-shadow: 0 0 5px rgba(255,245,245,0.8); */
                /* background-image: url('http://cuinine.com/img/codepen/savvy.jpg'); */
            }

            .button:hover a {
                color: #fff;
            }

            .button:hover .mask {
                background: #fff;
                -webkit-transform: translate3d(120%,-100px,0) rotate3d(0,0,1,90deg);
                transform: translate3d(120%,-100px,0) rotate3d(0,0,1,90deg);
            }

            .button:hover .shift {
                padding-left: 5px;
            }

            #button1pos{
                position: absolute;
                margin-top: 200px;
                margin-left: 230px;
            }
            #button2pos{
                position: absolute;
                margin-top: 0%;
                margin-left:500px;
            }

        </style>
    </head>
    <body>
        <c:import url="commonHeader.jsp">

        </c:import>
    <center><b> <span style="color:oldlace;font-size:32px;">Welcome:     ${client.name} </span></b></center>
    <hr>    
    <div id="map">
    </div>
    <div id="textf">
        <pre>               Click on the 
          "send request" button
         to see which restaurants 
            are nearby to you</pre>

        <div id="button1pos">
            <div class="center-wrap">
                <a onclick="showPosition()">
                    <div class = "button">
                        Send Request<span class="shift">›</span>
                        <div class="mask"></div>
                    </div>
                </a>
            </div>
        </div>
    </div>


    <hr>

</body>


<!-- Danger Zone  -->
<!-- Just JavaScript don't mess with this  -->
<script>
    var lt;
    var lg;

    var map, infoWindow;
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: 43.6560544, lng: -79.7415324}, //sheridan college
            zoom: 16
        });
        infoWindow = new google.maps.InfoWindow;

        // Try HTML5 geolocation.
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };

                lt = pos.lat;//
                lg = pos.lng;//

                infoWindow.setPosition(pos);
                infoWindow.setContent('You are Here');

                infoWindow.open(map);
                map.setCenter(pos);
            }, function () {
                handleLocationError(true, infoWindow, map.getCenter());
            });
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }
    }

    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
        infoWindow.setPosition(pos);
        infoWindow.setContent(browserHasGeolocation ?
                'Error: The Geolocation service failed.' :
                'Error: Your browser doesn\'t support geolocation.');
        infoWindow.open(map);
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=dummy_KEY&callback=initMap">
</script>

<script>

    function showPosition(position) {
        console.log("Latitude: " + lt +
                " Longitude: " + lg);


        var params = {'lat': lt, 'lng': lg};
        console.log(params);

        post("getLoc", params, "post");
    }


    function post(path, params, method) {
        method = method || "post"; // Set method to post by default if not specified.

        var form = document.createElement("form");
        form.setAttribute("method", method);
        form.setAttribute("action", path);

        for (var key in params) {
            if (params.hasOwnProperty(key)) {
                var hiddenField = document.createElement("input");
                hiddenField.setAttribute("type", "hidden");
                hiddenField.setAttribute("name", key);
                hiddenField.setAttribute("value", params[key]);
                form.appendChild(hiddenField);
            }
        }
        
        document.body.appendChild(form);
        form.submit();
    }
</script>

</html>
