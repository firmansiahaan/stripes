<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Contact Information" >
<s:layout-component name="body">
<s:form beanclass="stripesbook.action.ContactFormActionBean">
	<div><s:hidden name="contact.id"/></div>
	<table class="form">
		<s:errors/>
		<tr>
			<td>Email:</td>
			<td><s:text name="contact.email" class="required"/></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><s:text name="contact.firstName" class="required"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><s:text name="contact.lastName" class="required"/></td>
		</tr>
		<tr>
			<td><s:label for="contact.phoneNumber"/>:</td>
			<td><s:text formatType="dashes" name="contact.phoneNumber"/></td>
			<td><s:errors field="contact.phoneNumber"/></td>
		</tr>
		<tr>
			<td>Birth Date:</td>
			<td><s:text name="contact.birthDate" formatPattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>
				<c:forEach var="gender" items="${actionBean.genders}">
					<s:radio name="contact.gender" value="${gender}"/>
						<fmt:message key="${stripesbook.action.ContactFormActionBean}.${gender}"/>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
				<s:submit name="save" value="Save"/>
				<s:submit name="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</s:form>
</s:layout-component>
</s:layout-render>