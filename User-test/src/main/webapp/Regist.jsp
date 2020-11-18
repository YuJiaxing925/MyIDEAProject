<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2020/10/28
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="UserServlet?type=addUser" enctype="multipart/form-data" method="post">
        <input name="u_username" type="text">
        <input name="u_password" type="password">
        <input name="file" type="file">
        <input type="submit" value="提交">
    </form>
</body>
</html>
