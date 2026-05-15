<%@page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-render name="/reusable_layout/web/attributes/layout.jsp" title="My Title" objects="${pageContext.request.parameterMap}">
	<s:layout-component name="body">
		Hello, reusable Layout
	</s:layout-component>
</s:layout-render>