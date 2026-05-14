<%@page contentType="text/html;charset=ISO-8859-1" language="java" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<s:layout-definition>
	Header: ${title}
	<div>
		Objects:
		<ul>
			<c:forEach var="object" items="${objects}">
				<li>${object}</li>
			</c:forEach>
		</ul>
	</div>
	Footer
</s:layout-definition>