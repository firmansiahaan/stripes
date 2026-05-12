<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Contact Information" >
	<s:layout-component name="body">
		<s:form beanclass="stripesbook.action.ContactFormActionBean">
			<div><s:hidden name="contact.id"/></div>
			<s:errors/>
			<table class="form">
				<tr>
					<td><s:label for="contact.email"/></td>
					<td><s:text name="contact.email" class="required"/></td>
				</tr>
				<tr>
					<td><s:label for="contact.firstName"/></td>
					<td><s:text name="contact.firstName" maxlength="40" class="required"/></td>
				</tr>
				<tr>
					<td><s:label for="contact.lastName"/></td>
					<td><s:text name="contact.lastName" maxlength="40" class="required"/></td>
				</tr>
				<tr>
					<td><s:label for="contact.phoneNumber"/></td>
					<td><s:text name="contact.phoneNumber" formatType="dashes" class="required"/></td>
				</tr>
				<tr>
					<td><s:label for="contact.birthDate"/></td>
					<td><s:text name="contact.birthDate" formatPattern="yyyy-MM-dd" class="required"/></td>
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