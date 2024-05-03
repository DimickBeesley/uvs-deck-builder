<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div>
    <a href="index.jsp">
        <h1>Library Catalog</h1>
    </a>
</div>
<div>
    <a href="singuppage.jsp">
        <h1>Sign Up</h1>
    </a>
</div>
<p>${error}</p>
<div>
    <form name="loginform" method="POST" action="LoginServlet">
        <table border="0" cellpadding="5" align="center" width = "800px">
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
