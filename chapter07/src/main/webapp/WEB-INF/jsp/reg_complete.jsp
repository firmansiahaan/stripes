<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Registration" >
	<s:layout-component name="body">
		<p>Registration complete!</p>
		You may now
		<s:link beanclass="stripesbook.action.LoginActionBean">
			login
		</s:link>.
	</s:layout-component>
</s:layout-render>