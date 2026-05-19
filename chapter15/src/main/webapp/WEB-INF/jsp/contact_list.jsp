<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_folders.jsp" title="Contact List" >
	<s:layout-component name="body">
		<s:messages/>
		<s:link beanclass="stripesbook.action.ContactFormActionBean">
			Create a New Contact
		</s:link>
		<s:url var="url" beanclass="stripesbook.action.ContactListActionBean" />
		<fmt:message key="contactList.filter"/>:
		<input type="text" onkeyup="filterContacts(this, '${url}');"/>
		<br><br>
		<s:form beanclass="stripesbook.action.ContactListActionBean">
			<d:table name="${actionBean.contacts}" id="contact" requestURI="" defaultsort="1">
				<d:column title="Last Name" property="lastName" sortable="true"/>
				<d:column title="First Name" property="firstName" sortable="true"/>
				<d:column title="Email" property="email" sortable="true"/>
				<d:column title="Action">
					<div id="contact_table" style="float: left">
						<%@include file="/WEB-INF/jsp/parts/contact_table.jsp" %>
					</div>
				</d:column>
			</d:table>
		</s:form>		
		<div id="contact_details" style="float: left"></div>
		<div style="clear: both"></div>
		<div id="contact_form"></div>
	</s:layout-component>
</s:layout-render>