<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@taglib prefix="s" uri="http://stripes.sourceforge.net/stripes.tld" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Stripes ...And Java Web Development is fun again</title>
</head>
<body>
	<h3>Hello, Stripes!</h3>
	<p>
		Date and time:
		<br>
		<b>
			<fmt:formatDate type="both" dateStyle="full" value= "${actionBean.date}" />
		</b>
	</p>
	<p>
		<s:link beanclass="stripesbook.action.HelloActionBean" event="currentDate">
			Show the current date and time
		</s:link> | 
		<s:link beanclass="stripesbook.action.HelloActionBean" event="randomDate">
			Show the random date and time
		</s:link>
	</p>
</body>
</html>