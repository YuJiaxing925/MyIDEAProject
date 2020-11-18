<%@ page import="com.yuntu.biz.PositionBiz" %>
<%@ page import="com.yuntu.biz.PositionBizImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yuntu.pojo.Position" %>
<%@ page import="com.yuntu.pojo.Teacher" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="TeacherServlet?type=updTeacher&id=${teacher.id}">
    <table border="1" align="center">
        <tr>
            <td colspan="2"><h2>添加教师</h2></td>
        </tr>
        <tr>
            <td>编号</td>
            <td><input type="text" name="t_no" value="${teacher.t_no}"/></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><input type="text" name="t_name" value="${teacher.t_name}"/></td>
        </tr>
        <tr>
            <td>职位</td>
            <td>
                <select name="position_id">
                    <%
                        PositionBiz positionBiz = new PositionBizImpl();
                        List<Position> positionList = positionBiz.getAll();
                        Teacher t = (Teacher) request.getAttribute("teacher");
                        for ( Position p: positionList) {
                            %>
                                <option value="<%=p.getId()%>" <% if (p.getId()==t.getPosition_id()){%>selected="selected" <%}%>><%=p.getT_pos_name()%></option>
                            <%
                        }
                    %>
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
