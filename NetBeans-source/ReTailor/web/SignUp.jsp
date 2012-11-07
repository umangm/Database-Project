<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<!DOCTYPE html>
<%@page import="html.HtmlPages"%>
<html>
    <head>
        <title>Re-Tailor</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-latest.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" type="text/css" href="css/index.css" />
        <link rel="stylesheet" type="text/css" href="css/navigation.css">
        <script type="text/javascript" src="js/javas.js"> </script>
    </head>
    <body>


        <div class="navbar navbar-inverse navbar-fixed-top" >

            <div class="navbar-inner">
                <div class="container pull-left" style="padding-left:20px; padding-top:10px;" >
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Re-Tailor</a>
                </div>


                <ul class="nav pull-right" >


                    <form class="pull-right" action="HtmlPages" name="login_form" method="post">
                        <input class="input-medium" name="username" type="text" placeholder="Email" style="margin-top:15px;">
                        <input class="input-medium" name="password" type="password" placeholder="Password"style="margin-top:15px;">
                        <button class="btn" type="submit" >Login</button>
                    </form>



                </ul>
            </div>
        </div>


        <div class="container" style="margin-top: 100px; width: 450px; padding: 30px 30px 30px 30px;  border:1px solid #021a40;">
            <form name="signUpForm" class="form-signin" onsubmit="return isValid()" method="post" action="AddAccount">
                <h2 class="form-signin-heading">Please sign up</h2>
                <input name="name" class="input-block-level" type="text" placeholder="Name">
                <%
                    String emailValidaton = (String) session.getAttribute("invalidemail");
                    if (emailValidaton == null) {
                %>
                <input name="email" class="input-block-level" type="email" placeholder="Email address">
                <%                    } else {
                %>
                <input name="email" class="input-block-level" type="email" placeholder="Email address"><font color="red">* Email Exists</font><br />
                <%
                        session.setAttribute("invalidemail", null);
                    }
                %>


                <input name="number" class="input-block-level" type="text" placeholder="Phone Number">
                <input name="address" class="input-block-level" type="text" placeholder="Address">
                <input name="password" class="input-block-level" type="password" placeholder="Password">
                <input name="repassword" class="input-block-level" type="password" placeholder="Confirm Password">
                <div><p></p></div>
                <button class="btn btn-large btn-info" type="submit">Sign Up</button>

            </form>
        </div>
    </body>
</html>
