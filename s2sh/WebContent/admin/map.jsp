<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lyh2016.cn</title>
</head>
<body>


<c:forEach items="${map }" var="m">
<hr>
key:${m.key }<br>
 
value:<br>
	<c:forEach items="${m.value }" var="list">
		
		${list.title }  // ${list.pid }<br>
	</c:forEach>

</c:forEach>

</body>
</html>