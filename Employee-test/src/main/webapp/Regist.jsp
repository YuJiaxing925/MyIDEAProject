<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 2020/10/22
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="EmployeeServlet?type=addEmployee" method="post">
    <table border="1" align="center">
        <tr align="center">
            <td colspan="2">添加</td>
        </tr>
        <tr align="center">
            <td>员工姓名</td>
            <td><input type="text" name="e_name"/></td>
        </tr>
        <tr align="center">
            <td>学历</td>
            <td><input type="text" name="e_edu"/></td>
        </tr>
        <tr align="center">
            <td>职位</td>
            <td>
                <select name="e_r_id" >
                    <option value="1" selected="selected">Boos</option>
                    <option value="2">员工</option>
                    <option value="3">扫地的</option>
                    </select>
            </td>
        </tr>
        <tr align="center">
            <td>月薪</td>
            <td><input type="text" name="e_money"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
