<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="UserServlet?type=addFriend&id1=${u.u_id}">
    好友账号：<input type="text" name="id2">
    <input type="text" name="remarks">
    <input type="submit" value="添加">
</form>
</body>
</html>
