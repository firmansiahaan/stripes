<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="stripesbook.action.LoginActionBean.title"/>	
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="${title}" >
<s:layout-component name="body">
<p><fmt:message key="stripesbook.action.LoginActionBean.pleaseLogin"/>:</p>
<s:form beanclass="stripesbook.action.LoginActionBean">
	<s:errors/>
	<table class="form">
		<tr>
			<td><s:label for="username"/>:</td>
			<td><s:text name="username"/></td>
			<td>@stripesbook.org</td>
		</tr>
		<tr>
			<td><s:label for="password"/>:</td>
			<td><s:password name="password"/></td>
		</tr>
		<tr>
			<td></td>
			<td><s:submit name="login"/></td>
		</tr>
	</table>
</s:form>
<s:link beanclass="stripesbook.action.RegisterActionBean">
<fmt:message key="stripesbook.action.LoginActionBean.register"/>
</s:link>
<fmt:message key="stripesbook.action.LoginActionBean.toCreateAnAccount"/>.
	
<!-- 	<p> -->
<%-- 	<fmt:message var="otherLocale" key="layout.otherLocale"/> --%>
<%-- 	<s:link href="Login.action"> --%>
<%-- 		<s:param name="locale" value="${otherLocale}"/> --%>
<%-- 		<fmt:message key="layout.otherLanguage"/> --%>
<%-- 	</s:link> --%>
<!-- 	</p> -->

</s:layout-component>
</s:layout-render>