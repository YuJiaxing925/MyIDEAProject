<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="MoviesServlet?type=addMovies" method="post">
    <table border="1" align="center">
        <tr align="center">
            <td colspan="2">添加</td>
        </tr>
        <tr align="center">
            <td>名称</td>
            <td><input type="text" name="m_title"/></td>
        </tr>
        <tr align="center">
            <td>电影评分</td>
            <td><input type="text" name="m_score"/></td>
        </tr>
        <tr align="center">
            <td>电影简介</td>
            <td><input type="text" name="m_content"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>