<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserServlet?type=login" method="post">
    <input type="text" value="" name ="username"><br>
    <input type="password" value="" name="password">
    <input type="submit" value="submit">
    <a href="Regist.jsp">注册</a>
</form>

</body>
</html>
