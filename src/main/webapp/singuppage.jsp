
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="styles.css"%></style>

<html>
<head>
    <title>Sign up page</title>
</head>
<div class="header">
    <div>
        <a href="index.jsp">
            <h1 align="left" style="padding-left: 50px; font-family: 'Courier New',serif; font-size: 40px; color: #EFF0F3;">
                UVS-DECK-BUILDER
            </h1>
        </a>
    </div>
    <h2 style="padding-left: 50px;">Welcome ${user.getUsername()}
        <a class="button" href="loginpage.jsp">Login</a>
    </h2>
</div>

<body>
<p>${error}</p>
<form name="signupform" method="POST" action="SignupServlet" onSubmit="return validate()">
    <table border="0" cellpadding="5" align="center" width = "350px">
        <tr>
            <td colspan="2"><h3>Register</h3></td>
        </tr>

        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstname"  /></td>                 <!-- name: firstname -->
        </tr>

        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastname" /></td>                   <!-- name: lastname -->
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" /></td>                  <!-- name: username -->
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" /></td>              <!-- name: password -->
        </tr>
        <tr>
            <td>Confirm Password:</td>
            <td><input type="password" name="confirm" /></td>               <!-- name: confirm -->
        </tr>
        <tr>
            <td><input type="submit" name="signup" value="Sign up" /></td>
        </tr>
    </table>
</form>

</body>
</html>
