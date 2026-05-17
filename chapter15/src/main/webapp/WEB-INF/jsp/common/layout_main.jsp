<%@page pageEncoding="UTF-8" %>
<%@page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<fmt:setBundle basename="StripesResources"/>
<s:layout-definition>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" 
	"http://www.w3.org/TR/html4/strict.dtd" >
<html>
	<head>
		<title>${title}</title>
		<script src="${contextPath}/js/prototype.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css" >
		<s:layout-component name="head"/>
	</head>
	<body>
		<div id="header">
			<span class="title">${title}</span>
			<span class="menu">
				<s:layout-component name="menu">
					Welcome to Stripes Webmail
				</s:layout-component>
			</span>
		</div>
		<div id="body">
			<h3>${title}</h3>
			<s:layout-component name="body"/>
			<p>
				<fmt:message var="otherLocale" key="layout.otherLocale"/>
				<s:link href="${actionBean.lastUrl}">
					<s:param name="locale" value="${otherLocale}"/>
					<fmt:message key="layout.otherLanguage"/>
				</s:link>
			</p>
		</div>
	</body>
</html>
</s:layout-definition>