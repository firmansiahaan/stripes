<%@page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-definition>
	Header
	<div>
		<s:layout-component name="part1">
			Default Part 1
		</s:layout-component>
	</div>
	<div>
		<s:layout-component name="part2">
			Default Part 2
		</s:layout-component>
	</div>
	<div><s:layout-component name="part3"/></div>
	Footer
</s:layout-definition>