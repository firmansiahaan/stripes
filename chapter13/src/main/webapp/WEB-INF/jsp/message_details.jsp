<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_folders.jsp" title="Message Details" >
	<s:layout-component name="body">
		<table class="view">
			<tr>
				<td class="label">Date:</td>
				<td class="value"><s:format value="${actionBean.message.date}" formatPattern="yyyy-MM-dd"/>
			</tr>
			<tr>
				<td class="label">From:</td>
				<td class="value">${actionBean.message.from}</td>
			</tr>
			<tr>
				<td class="label">To:</td>
				<td class="value">${actionBean.message.to}</td>
			</tr>
			<tr>
				<td class="label">Cc:</td>
				<td class="value">${actionBean.message.cc}</td>
			</tr>
			<tr>
				<td class="label">Subject:</td>
				<td class="value">${actionBean.message.subject}</td>
			</tr>
			<tr>
				<td class="label">Message:</td>
				<td class="value">${actionBean.message.text}</td>
			</tr>
		</table>
		
		<c:if test="${not empty actionBean.message.attachments}">
		<div>Attachments:</div>
		<div>
		<c:forEach var="attachment" items="${actionBean.message.attachments}" >
			<s:link event="downloadAttachment" beanclass="stripesbook.action.MessageDetailsActionBean" >
				<s:param name="attachmentId" value="${attachment.id}"/>
				${attachment.fileName}
			</s:link>
			(${attachment.size} bytes)
			<br/>
		</c:forEach>
		</div>
		</c:if>
		
		<s:form beanclass="stripesbook.action.MessageListActionBean">
			<%@include file="/WEB-INF/jsp/common/message_action.jsp" %>
			<div>
				<s:hidden name="selectedMessages" value="${actionBean.message.id}" />
			</div>
		</s:form>

</s:layout-component>
</s:layout-render>