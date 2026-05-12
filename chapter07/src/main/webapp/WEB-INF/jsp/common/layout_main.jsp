<%@page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-definition>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" 
	"http://www.w3.org/TR/html4/strict.dtd" >
<html>
<head>
	<title>${title}</title>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css" >
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
		<s:layout-component name="body"/>
	</div>
	<fmt:message var="otherLocale" key="layout.otherLocale"/>
<%-- 	<s:link href="${actionBean.lastUrl}"> --%>
<%-- 		<s:param name="locale" value="${otherLocale}"/> --%>
<%-- 		<fmt:message key="layout.otherLanguage"/> --%>
<%-- 	</s:link> --%>
</body>
</html>
</s:layout-definition>