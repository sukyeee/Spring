<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Error jsp</title>
</head>
<body>
<h1>
	Global Error 오류가 발생했습니다(╯‵□′)╯︵┻━┻
</h1>


<p> url : ${url } </p>
<p> exception : ${exception} </p>
</body>
</html>

