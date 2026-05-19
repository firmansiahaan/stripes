<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

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
						${gender}
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>
				<s:submit name="save" onclick="return submitForm(this);"/>
				<s:button name="cancel" onclick="$('#contact_form').hide();"/>
			</td>
		</tr>
	</table>
</s:form>