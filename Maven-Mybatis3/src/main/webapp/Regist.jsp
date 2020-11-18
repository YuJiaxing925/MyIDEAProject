<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty positionList}">
    <jsp:forward page="TeacherServlet?type=getPosition"></jsp:forward>
</c:if>

    <form method="post" action="TeacherServlet?type=addTeacher">
        <table border="1" align="center">
            <tr>
                <td colspan="2"><h2>添加教师</h2></td>
            </tr>
            <tr>
                <td>编号</td>
                <td><input type="text" name="t_no"/></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="t_name"/></td>
            </tr>
            <tr>
                <td>职位</td>
                <td>
                    <select name="position_id">
                        <c:forEach items="${positionList}" var="position" varStatus="status">
                            <option value="${position.id}">${position.t_pos_name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>
</body>
</html>
