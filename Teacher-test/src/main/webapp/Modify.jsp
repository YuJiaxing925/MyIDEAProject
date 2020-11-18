<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="TeacherServlet?type=updTeacher&id=${t.t_Id}" method="post">
    <table border="1" align="center">
        <tr align="center">
            <td colspan="2">修改</td>
        </tr>
        <tr align="center">
            <td>姓名</td>
            <td><input type="text" name="t_name" value="${t.t_name}"/></td>
        </tr>
        <tr align="center">
            <td>科目</td>
            <td><input type="text" name="t_subject" value="${t.t_subject}"/></td>
        </tr>
        <tr align="center">
            <td>性别</td>
            <td>
                <select name="t_sex">
                    <option value="男" selected="selected" >男</option>
                    <option value="女"> 女</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
