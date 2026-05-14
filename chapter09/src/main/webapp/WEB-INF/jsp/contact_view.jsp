<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Contact Information" >
	<s:layout-component name="body">
		
		<table class="view">
			<tr>
				<td class="label"><s:label for="contact.firstName"/>:</td>
				<td class="value">${actionBean.contact.firstName}</td>
			</tr>
			<tr>
				<td class="label"><s:label for="contact.lastName"/>:</td>
				<td class="value">${actionBean.contact.lastName}</td>
			</tr>
			<tr>
				<td class="label"><s:label for="contact.email"/>:</td>
				<td class="value">${actionBean.contact.email}</td>
			</tr>
			<tr>
				<td class="label"><s:label for="contact.phoneNumber"/>:</td>
				<td class="value">${actionBean.contact.phoneNumber}</td>
			</tr>
			<tr>
				<td class="label"><s:label for="contact.birthDate"/>:</td>
				<td class="value"><s:format formatType="dashes" value="${actionBean.contact.birthDate}" formatPattern="yyyy-MM-dd"/> </td>
			</tr>
		</table>
		<p>
			<s:link beanclass="stripesbook.action.ContactListActionBean">
				Back to List
			</s:link>
		</p>
	</s:layout-component>
</s:layout-render>