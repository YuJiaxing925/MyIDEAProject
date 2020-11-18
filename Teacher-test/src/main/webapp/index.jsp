<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<body>
<c:if test="${empty pageUtil}">
    <jsp:forward page="TeacherServlet?type=getPageAll"></jsp:forward>
</c:if>
<table border="1" cellspacing="0" align="center" height="300px" width="500px">
    <tr align="center">
        <th>编号</th>
        <th>姓名</th>
        <th>生日</th>
        <th>科目</th>
        <th>性别</th>
        <th>操作</th>
    </tr>
    <c:forEach varStatus="status" var="t" items="${pageUtil.lists}">
        <fmt:formatDate  value="${t.t_birthday}" var="date" pattern="yyyy-MM-dd"></fmt:formatDate>
        <tr align="center">
            <td>${t.t_Id}</td>
            <td>${t.t_name}</td>
            <td>${date}</td>
            <td>${t.t_subject}</td>
            <td>${t.t_sex}</td>
            <td><a href="TeacherServlet?type=delTeacher&id=${t.t_Id}">删除</a><a href="TeacherServlet?type=getTeacher&id=${t.t_Id}">修改</a> </td>
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
                <a href="TeacherServlet?type=getPageAll">首页</a>
                <a href="TeacherServlet?type=getPageAll&pageindex=${pageUtil.pageindex-1 }">上一页</a>
            </c:if>
            <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                <a href="TeacherServlet?type=getPageAll&pageindex=${pageUtil.pageindex+1 }">下一页</a>
                <a href="TeacherServlet?type=getPageAll&pageindex=${pageUtil.pagecount }">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
