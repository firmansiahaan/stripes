<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<fmt:message var="title" key="exception.title"/>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp"	title="${title}" >
	<s:layout-component name="body">
		<p>
			<fmt:message key="exception.message"/>
		</p>
		<s:link href="/">
			<fmt:message key="exception.startOver"/>
		</s:link>
	</s:layout-component>
</s:layout-render>