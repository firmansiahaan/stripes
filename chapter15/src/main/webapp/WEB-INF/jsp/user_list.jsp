<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_folders.jsp" title="User List" >
	<s:layout-component name="body">
		<c:set var="index" value="0"/>
		<s:form beanclass="stripesbook.action.UserListActionBean">
			<d:table name= "${actionBean.users}" id="user" requestURI="" defaultsort="1" pagesize="10" >
				<d:column titleKey="user.lastName" sortable="true">
					${fn:escapeXml(user.lastName)}
				</d:column>
				<d:column titleKey="user.firstName" sortable="true">
					${fn:escapeXml(user.firstName)}
				</d:column>
				<d:column titleKey="user.email" sortable="true">
					${fn:escapeXml(user.username)}@stripesbook.org
				</d:column>
				<d:column titleKey="user.roles">
					<c:forEach var="role" items="${actionBean.roles}">
						<s:checkbox name="users[${index}].roles"
							value="${role}" checked="${user.roles}" />
						${role}
					</c:forEach>
					<c:set var="index" value="${index + 1}"/>
				</d:column>
			</d:table>
			<br>
			<s:submit name="save"/>
		</s:form>
	</s:layout-component>
</s:layout-render>