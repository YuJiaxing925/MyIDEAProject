<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="UserServlet?type=updUser&id=${user.u_id}" enctype="multipart/form-data" method="post">
    <input name="u_username" type="text" value="${user.u_userName}">
    <input name="u_password" type="text" value="${user.u_password}">
    <img src="image/${user.u_imgUrl}" height="20px" width="20px" alt="">
    <input name="file" type="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
