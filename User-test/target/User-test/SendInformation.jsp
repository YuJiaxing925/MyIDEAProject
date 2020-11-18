<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="InformationServlet?type=sendMail&receiveId=${param.id}&sendId=${u.u_id}">
        <table align="center" width="300px">
            <tr>
                <td>标题</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>发送内容：</td>
                <td><textarea name="content" id="" cols="30" rows="10"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
