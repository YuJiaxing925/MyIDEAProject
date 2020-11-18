<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<body>
<c:if test="${empty pageUtil}">
    <jsp:forward page="MoviesServlet?type=getPageAll"></jsp:forward>
</c:if>
<table border="1" cellspacing="0" align="center"  width="500px">
    <tr align="center">
        <th>编号</th>
        <th>名称</th>
        <th>电影评分</th>
        <th>电影简介</th>
        <th>上映时间</th>
        <th>操作</th>
    </tr>
    <c:forEach varStatus="status" var="m" items="${pageUtil.lists}">

        <fmt:formatDate  value="${m.m_release}" var="date" pattern="yyyy-MM-dd"></fmt:formatDate>
        <tr align="center">
            <td>${m.m_id}</td>
            <td>${m.m_title}</td>
            <td>${m.m_score}</td>
            <td>${m.m_content}</td>
            <td>${date}</td>
            <td><a href="MoviesServlet?type=delMoviesById&id=${m.m_id}">删除</a><a href="MoviesServlet?type=getMovies&id=${m.m_id}">修改</a> </td>
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
                <a href="MoviesServlet?type=getPageAll">首页</a>
                <a href="MoviesServlet?type=getPageAll&pageindex=${pageUtil.pageindex-1 }">上一页</a>
            </c:if>
            <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                <a href="MoviesServlet?type=getPageAll&pageindex=${pageUtil.pageindex+1 }">下一页</a>
                <a href="MoviesServlet?type=getPageAll&pageindex=${pageUtil.pagecount }">尾页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
