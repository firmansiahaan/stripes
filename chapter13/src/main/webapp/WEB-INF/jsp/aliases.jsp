<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Registration" >
	<s:layout-component name="body">
		<p>Enter your email aliases:</p>
		<s:form beanclass="stripesbook.action.RegisterActionBean">
			<s:errors/>
			<table class="form">
				<c:forEach begin="0" end="${actionBean.numberOfAliases - 1}" var="index" >
					<tr>
						<td>
							<s:label for="user.aliases[${index}]"/> ${index + 1}:
						</td>
						<td><s:text name="user.aliases[${index}]"/></td>
						<td>@stripesbook.org</td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td>
						<s:submit name="save" value="Continue"/>
						<s:submit name="cancel" value="Cancel"/>
					</td>
				</tr>
			</table>
		</s:form>
	</s:layout-component>
</s:layout-render>