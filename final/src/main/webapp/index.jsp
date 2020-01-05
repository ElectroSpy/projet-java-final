<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog final</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/" method="post">
            <input type="text" name="titre"/>
            <input type="text" name="auteur"/>
            <input type="text" name="description"/>
            <input type="text" name="texte"/>
            <input type="submit" value="go"/>
        </form>

</body>
</html>
