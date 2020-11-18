<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="EmployeeServlet?type=updEmployee&e_id=${employee.e_id}" method="post">
    <table border="1" align="center">
        <tr align="center">
            <td colspan="2">添加</td>
        </tr>
        <tr align="center">
            <td>员工姓名</td>
            <td><input type="text" name="e_name" value="${employee.e_name}"/></td>
        </tr>
        <tr align="center">
            <td>学历</td>
            <td><input type="text" name="e_edu" value="${employee.e_edu}"/></td>
        </tr>
        <tr align="center">
            <td>职位</td>
            <td>
                <select name="e_r_id" >
                    <option value="1" <c:if test="${employee.e_r_id==1}">selected="selected" </c:if>>Boos</option>
                    <option value="2"<c:if test="${employee.e_r_id==2}">selected="selected" </c:if>>员工</option>
                    <option value="3"<c:if test="${employee.e_r_id==3}">selected="selected" </c:if>>扫地的</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td>月薪</td>
            <td><input type="text" name="e_money" value="${employee.e_money}"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
