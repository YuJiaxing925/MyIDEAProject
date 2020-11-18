<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<body>
<c:if test="${empty pageUtil}">
    <jsp:forward page="UserServlet?type=getPage&role=${u.u_role}"></jsp:forward>
</c:if>
<table border="1" cellspacing="0" align="center" width="500px">
    <tr align="center">
        <th>编号</th>
        <th>账号</th>
        <th>密码</th>
        <th>头像</th>
        <th>创建时间</th>
        <th>修改时间</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${pageUtil.lists}" varStatus="status" var="u1" >
        <tr align="center">
            <td>${u1.u_id}</td>
            <td>${u1.u_userName}</td>
            <td>${u1.u_password}</td>
            <td><img width="20px" height="20px" src="image/${u1.u_imgUrl}" alt=""></td>
            <td>${u1.u_createTime}</td>
            <td>${u1.u_updateTime}</td>
            <td><a href="UserServlet?type=selUser&id=${u1.u_id}">修改</a></td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td align="center" colspan="7">当前页[${pageUtil.pageindex }/${pageUtil.pagecount }]</td>
    </tr>
    <tr>
        <td align="center" colspan="7">
            <c:if test="${pageUtil.pageindex>1}">
                <a href="UserServlet?type=getPage&role=${u.u_role}">首页</a>
                <a href="UserServlet?type=getPage&pageindex=${pageUtil.pageindex-1 }&role=${u.u_role}">上一页</a>
            </c:if>
            <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                <a href="UserServlet?type=getPage&pageindex=${pageUtil.pageindex+1 }&role=${u.u_role}">下一页</a>
                <a href="UserServlet?type=getPage&pageindex=${pageUtil.pagecount }&role=${u.u_role}">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
