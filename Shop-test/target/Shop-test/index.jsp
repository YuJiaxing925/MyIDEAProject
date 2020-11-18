<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page isELIgnored="false"%>
<html>
<body>
    <c:if test="${empty pageUtil}">
        <jsp:forward page="GoodsServlet?type=getGoods"></jsp:forward>
    </c:if>
    <table border="1" cellspacing="0" align="center" height="300px" width="500px">
        <tr align="center">
            <th>编号</th>
            <th>名称</th>
            <th>类别</th>
            <th>颜色</th>
            <th>价格</th>
            <th>操作</th>

        </tr>

        <c:forEach varStatus="status" var="goods" items="${pageUtil.lists}">

            <tr align="center">
                <td>${goods.id}</td>
                <td>${goods.name}</td>
                <td>${goods.sort.s_name}</td>
                <td>${goods.color}</td>
                <td>${goods.money}</td>
                <td><a href="GoodsServlet?type=delGoodsById&id=${goods.id}">删除</a><a href="GoodsServlet?type=selGoods&id=${goods.id}">修改</a> </td>
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
                    <a href="GoodsServlet?type=getGoods">首页</a>
                    <a href="GoodsServlet?type=getGoods&pageindex=${pageUtil.pageindex-1 }">上一页</a>
                </c:if>
                <c:if test="${pageUtil.pageindex<pageUtil.pagecount }">
                    <a href="GoodsServlet?type=getGoods&pageindex=${pageUtil.pageindex+1 }">下一页</a>
                    <a href="GoodsServlet?type=getGoods&pageindex=${pageUtil.pagecount }">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</body>
</html>
