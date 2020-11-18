<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="StudentServlet?type=updStudent&id=${s.stu_id}" method="post">
    <table border="1" align="center">
        <tr align="center">
            <td colspan="2">修改</td>
        </tr>
        <tr align="center">
            <td>姓名</td>
            <td><input type="text" name="stu_name" value="${s.stu_name}"/></td>
        </tr>
        <tr align="center">
            <td>年龄</td>
            <td><input type="text" name="stu_age" value="${s.stu_age}"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
