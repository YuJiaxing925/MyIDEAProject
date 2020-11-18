<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center" width="500px">
    <tr>
        <td>标题</td>
        <td>${information.i_title}</td>
    </tr>
    <tr>
        <td>发送内容：</td>
        <td>${information.i_content}</td>
    </tr>
</table>
</body>
</html>
