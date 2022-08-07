<%--
  Created by IntelliJ IDEA.
  User: cesar
  Date: 8/6/2022
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listado de Personas</title>
</head>
<body>
<ul>
<c:forEach items="${personas}" var="persona">
 <li>${persona.nombre} ${persona.apellido}</li>
</c:forEach>
</ul>
</body>
</html>
