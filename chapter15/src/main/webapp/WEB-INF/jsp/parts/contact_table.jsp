<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<%-- <%= response.setHeader("X-Stripes-Success" ,"true" ) %> --%>

<s:link beanclass="stripesbook.action.ContactListActionBean" event="details"
	onclick="return ajaxLink(this, '#contact_details');" >
	<s:param name="contact" value="${contact}"/>
	<img src="${contextPath}/images/info.png" border="0"/>
</s:link> 

<s:link beanclass="stripesbook.action.ContactFormActionBean" 
	onclick="return ajaxLink(this, '#contact_form');" >
	<s:param name="contact" value="${contact}"/>
	<img src="${contextPath}/images/update.png" border="0"/>
</s:link>

<s:link beanclass="stripesbook.action.ContactListActionBean" event="delete"
	onclick="return ajaxLink(this, '#contact_table');" >
	<s:param name="contact" value="${contact}"/>
	<img src="${contextPath}/images/delete.png" border="0"/>
</s:link>