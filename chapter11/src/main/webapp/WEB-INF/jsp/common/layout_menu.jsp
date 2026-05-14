<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<fmt:setBundle basename="StripesResources"/>
<s:layout-definition>
	<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="${title}">
		<s:layout-component name="menu">
			<s:url var="url" beanclass="stripesbook.action.MenuViewHelper" prependContext="false" >
				<s:param name="currentSection" value="${currentSection}"/>
			</s:url>
			<jsp:include page="${url}"/>
		</s:layout-component>
		<s:layout-component name="body">${body}</s:layout-component>
	</s:layout-render>
</s:layout-definition>