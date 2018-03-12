
<%-- 
    Document   : index.jsp
    Created on : 13-Dec-2017, 5:29:22 PM
    Author     : Parteek Dheri 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="dummy_ID.apps.googleusercontent.com">
        <meta charset="utf-8">



    </head>
    <body class ="subpage">
        <!-- Header -->
        <header id="header">

        </header>


        <!-- One -->
        <section id="One" class="wrapper style3">
            <div class="inner">
                <header class="align-center">
                    <p>By Parteek And Ishan</p>
                    <h2>FeedMe</h2>
                </header>
            </div>
        </section>
        <div id ="welcome" align="center">

        </div>


        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        <script>
            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                console.log('Name: ' + profile.getName());
                var params = {'source': 'google', 'id': profile.getId(), 'name': profile.getName(), 'email': profile.getEmail()};
                console.log(params);
                post("Login", params, "post");
            }

        </script>

        <script>
            function post(path, params, method) {
                method = method || "post";
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
    </body>
</html>