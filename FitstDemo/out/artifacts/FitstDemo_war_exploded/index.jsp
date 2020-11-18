<%@ page import="biz.petBiz" %>
<%@ page import="biz.impl.petBizImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.pet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <c:if test="${empty p}">
    <jsp:forward page="petServlet?type=getall" ></jsp:forward>
  </c:if>
    <table border="1" align="center">
      <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
      </tr>
      <c:forEach items="${p}" var="p">
        <tr>
          <td>${p.name}</td>
          <td>${p.age}</td>
          <td>删除 修改</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
