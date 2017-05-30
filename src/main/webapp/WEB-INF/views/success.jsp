<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: pengzhihao
  Date: 2017/5/29
  Time: 下午2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
success

<table border="1">
    <tr>
        <td>姓名</td>
        <td>年龄</td>
    </tr>

    <c:forEach var="item" items="${requestScope.list}">
        <tr>
            <td>${item.name}</td>
            <td>${item.age}</td>
        </tr>
    </c:forEach>

</table>



</body>
</html>
