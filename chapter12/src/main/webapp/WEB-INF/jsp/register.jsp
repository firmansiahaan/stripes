<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Registration" >
	<s:layout-component name="body">
		<p>Register to create an account:</p>
		<s:errors globalErrorsOnly="true"/>
		<s:form beanclass="stripesbook.action.RegisterActionBean">
			<table class="form">
				<!-- s:text fields for first, last and user name... -->
				<tr>
					<td>First Name:</td>
					<td><s:text name="user.firstName"/></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><s:text name="user.lastName"/></td>
				</tr>
				<tr>
					<td>User:</td>
					<td><s:text name="user.username"/></td>
				</tr>
				<tr>
					<td><s:label for="user.password"/>:</td>
					<td><s:password name="user.password"/></td>
				</tr>
				<tr>
					<td><s:label for="confirmPassword"/>:</td>
					<td><s:password name="confirmPassword"/></td>
				</tr>
				<tr>
					<td><s:label for="aliases"/>:</td>
					<td>
						<s:select name="numberOfAliases">
							<s:option value="" label="How many aliases?"/>
								<c:forEach begin="${actionBean.minAliases}" var="index" end="${actionBean.maxAliases}" >
									<s:option value="${index}" label="${index}"/>
								</c:forEach>
						</s:select>
					</td>
				</tr>
				<!-- rest of the form... -->
				
				<tr>
					<td></td>
					<td>
						<s:submit name="register" value="Continue"/>
						<s:submit name="cancel" value="Cancel"/>
					</td>
				</tr>
			</table>
		</s:form>
	</s:layout-component>
</s:layout-render>