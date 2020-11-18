<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty informationList}">
    <jsp:forward page="InformationServlet?type=getInformationList&id=${u.u_id}"></jsp:forward>
</c:if>
<table align="center" width="500px" border="1">
    <tr>
        <td colspan="5" align="center">消息列表</td>
    </tr>
    <c:forEach var="i" items="${informationList}">
        <tr>
            <td>${i.i_id}</td>
            <td><a href="InformationServlet?type=readInformation&id=${i.i_id}">${i.i_title}</a></td>
            <td>发送人：${i.i_sendOutId}</td>
            <td>${i.i_createTime}</td>
            <td><c:if test="${i.i_isRead==0}">未读</c:if><c:if test="${i.i_isRead==1}">已读</c:if></td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
