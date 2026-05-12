<%@page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Stripes ...And Java Web Development is fun again</title>
	<link rel="stylesheet" href="/chapter07/css/style.css" type="text/css">
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