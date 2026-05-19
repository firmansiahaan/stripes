<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<table class="view">
	<tr>
		<td class="label"><s:label for="contact.firstName"/>:</td>
		<td class="value">
			${fn:escapeXml(actionBean.contact.firstName)}
		</td>
	</tr>
	<tr>
		<td class="label">Last name:</td>
		<td class="value">${fn:escapeXml({actionBean.contact.lastName})</td>
	</tr>
	<tr>
		<td class="label">Email:</td>
		<td class="value">${fn:escapeXml({actionBean.contact.email})</td>
	</tr>
	<tr>
		<td class="label">Phone number:</td>
		<td class="value"><s:format formatType="dashes" value="${actionBean.contact.phoneNumber}"/></td>
	</tr>
	<tr>
		<td class="label">Birth date:</td>
		<td class="value"><s:format value="${actionBean.contact.birthDate}" formatPattern="yyyy-MM-dd"/>
	</tr>
</table>
<a href="#" style="padding-left: 24px;" onclick="$('#contact_details').hide();" >
	<img src="${contextPath}/images/close.png" border="0"/>
</a>