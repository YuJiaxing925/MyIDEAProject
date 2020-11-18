<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cellspacing="0" align="center" width="500px">
    <tr>
        <td colspan="4" align="center">好友列表</td>
    </tr>
    <tr align="center">
        <th>编号</th>
        <th>账号</th>
        <th>头像</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userList}" varStatus="status" var="u1" >
        <tr align="center">
            <td>${u1.u_id}</td>
            <td>${u1.u_userName}</td>
            <td><img width="20px" height="20px" src="image/${u1.u_imgUrl}" alt=""></td>
            <td><a href="UserServlet?type=delFriend&id1=${u.u_id}&id2=${u1.u_id}">删除</a>  &nbsp;<a href="SendInformation.jsp?id=${u1.u_id}">发送消息</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4" align="center"><a href="RegistFriend.jsp">添加好友</a></td>
    </tr>
</table>
</body>
</html>
