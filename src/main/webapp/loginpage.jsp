<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="styles.css"%></style>

<html>
<head>
    <title>Login</title>
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
        <a class="button" href="singuppage.jsp">Sign up</a>
    </h2>
</div>
<body>
<p>${error}</p>
<div>
    <form name="loginform" method="POST" action="LoginServlet">
        <table border="0" cellpadding="5" align="center" width = "350px">
            <tr>
                <td colspan="2"><h3>Login</h3></td>
            </tr>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" required /></td>                  <!-- name: username -->
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required/></td>               <!-- name: password -->
            </tr>
            <tr>
                <td><input type="submit" value="Login" /> </td>
                <td>
                    <%
                        if(request.getParameter("c")!= null) {
                            //check the value for variable "c"
                            out.println("Username or password is incorrect.!");
                        }
                    %>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
