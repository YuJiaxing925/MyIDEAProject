<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<body>
    <c:if test="${empty pageUtil}">
        <jsp:forward page="EmployeeServlet?type=getEmployees"></jsp:forward>
    </c:if>
    <table bor  der="1" cellspacing="0" align="center" height="500px" width="500px">
        <tr align="center">
            <th>编号</th>
            <th>姓名</th>
            <th>学历</th>
            <th>职位</th>
            <th>入职时间</th>
            <th>薪资</th>
            <th>操作</th>

        </tr>

        <c:forEach varStatus="status" var="employee" items="${pageUtil.lists}">
            <fmt:formatDate  value="${employee.e_hiredate}" var="hiredate" pattern="yyyy-MM-dd"></fmt:formatDate>
            <tr align="center">
                <td>${employee.e_id}</td>
                <td>${employee.e_name}</td>
                <td>${employee.e_edu}</td>
                <td>${employee.role.r_name}</td>
                <td>${hiredate}</td>
                <td>${employee.e_money}</td>
                <td><a href="EmployeeServlet?type=delEmployeeById&id=${employee.e_id}">删除</a><a href="EmployeeServlet?type=selEmployee&e_id=${employee.e_id}">修改</a> </td>
            </tr>
        </c:forEach>
            <tr align="center">
                <td colspan="7"><a href="Regist.jsp">添加</a></td>
            </tr>
        <tr align="center">
            <td align="center" colspan="7">当前页[${pageUtil.pageindex }/${pageUtil.pagecount }]</td>
        </tr>
        <tr>
            <td align="center" colspan="7">
                <c:if test="${pageUtil.pageindex>1}">
                    <a href="EmployeeServlet?type=getEmployees">首页</a>
                    <a href="EmployeeServlet?type=getEmployees&pageindex=${pageUtil.pageindex-1 }">上一页</a>
                </c:if>
                <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                    <a href="EmployeeServlet?type=getEmployees&pageindex=${pageUtil.pageindex+1 }">下一页</a>
                    <a href="EmployeeServlet?type=getEmployees&pageindex=${pageUtil.pagecount }">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</body>
</html>
