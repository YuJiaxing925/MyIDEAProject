<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<body>
<h2>Hello World!</h2>
<table border="1" align="center">
    <c:if test="${empty teacherList}">
        <jsp:forward page="TeacherServlet"></jsp:forward>
    </c:if>
    <tr>
        <th><a href="Regist.jsp">添加</a></th>
    </tr>
    <tr>
        <th>id</th>
        <th>职位</th>
        <th>姓名</th>
        <th>编号</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${teacherList}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.p.t_pos_name}</td>
            <td>${teacher.t_name}</td>
            <td>${teacher.t_no}</td>
            <td><a href="TeacherServlet?type=delTeacher&id=${teacher.id}">删除</a><a href="TeacherServlet?type=getTeacher&id=${teacher.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
