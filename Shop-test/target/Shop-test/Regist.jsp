<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="GoodsServlet?type=addGoods" method="post">
    <table border="1" align="center">
        <tr align="center">
            <td colspan="2">添加</td>
        </tr>
        <tr align="center">
            <td>名字</td>
            <td><input type="text" name="name"/></td>
        </tr>

        <tr align="center">
            <td>类别</td>
            <td>
                <select name="s_id" >
                    <option value="1">a</option>
                    <option value="2">b</option>
                    <option value="3">c</option>
                </select>
            </td>
        </tr>
        <tr align="center">
            <td>价格</td>
            <td><input type="text" name="color"/></td>
        </tr>
        <tr align="center">
            <td>价格</td>
            <td><input type="text" name="money" /></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
</html>
