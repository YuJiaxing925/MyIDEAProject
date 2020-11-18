<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<body>
<c:if test="${empty pageUtil}">
    <jsp:forward page="StudentServlet?type=getPageAll"></jsp:forward>
</c:if>
<table border="1" cellspacing="0" align="center" height="300px" width="500px">
    <tr align="center">
        <th>编号</th>
        <th>名称</th>
        <th>年龄</th>
        <th>入学时间</th>
        <th>分数</th>
        <th>操作</th>
    </tr>
    <c:forEach varStatus="status" var="s" items="${pageUtil.lists}">
        <fmt:formatDate  value="${s.stu_time}" var="date" pattern="yyyy-MM-dd"></fmt:formatDate>
        <tr align="center">
            <td>${s.stu_id}</td>
            <td>${s.stu_name}</td>
            <td>${s.stu_age}</td>
            <td>${date}</td>
            <td>${s.score.sc_fen}</td>
            <td><a href="StudentServlet?type=delStudentById&id=${s.stu_id}">删除</a><a href="StudentServlet?type=getStudent&id=${s.stu_id}">修改</a> </td>
        </tr>
    </c:forEach>
    <tr align="center">
        <td colspan="7"><a href="Regist.jsp">添加</a></td>
    </tr>
    <tr align="center">
        <td align="center" colspan="6">当前页[${pageUtil.pageindex }/${pageUtil.pagecount }]</td>
    </tr>
    <tr>
        <td align="center" colspan="7">
            <c:if test="${pageUtil.pageindex>1}">
                <a href="StudentServlet?type=getPageAll">首页</a>
                <a href="StudentServlet?type=getPageAll&pageindex=${pageUtil.pageindex-1 }">上一页</a>
            </c:if>
            <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                <a href="StudentServlet?type=getPageAll&pageindex=${pageUtil.pageindex+1 }">下一页</a>
                <a href="StudentServlet?type=getPageAll&pageindex=${pageUtil.pagecount }">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
