<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_folders.jsp" title="Message Compose" >
<s:layout-component name="body">
	<jsp:useBean class="stripesbook.action.ContactListActionBean" id="contacts" />
	<s:form beanclass="stripesbook.action.MessageComposeActionBean">
	<c:set var="arrow" value="/images/arrow.png"/>
	<table>
	<tr>
	<th align="left">
		<table>
		<tr>
			<th>To:</th>
			<td><s:text name="message.to" size="60"/></td>
			<td><s:image name="addTo" src="${arrow}"></s:image></td>
		</tr>
		<tr>
			<th>Cc:</th>
			<td><s:text name="message.cc" size="60"/></td>
			<td><s:image name="addCc" src="${arrow}"/></td>
		</tr>
		<tr>
			<th>Bcc:</th>
			<td><s:text name="message.bcc" size="60"/></td>
			<td><s:image name="addBcc" src="${arrow}"/></td>
		</tr>
		<tr>
			<th>Subject:</th>
			<td><s:text name="message.subject" size="60"/></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3"><s:textarea name="message.text" cols="87" rows="12"/></td>
		</tr>
		</table>
	</th>
	<th valign="top">
		<s:select name="contacts" multiple="true" size="7">
					<s:options-collection collection="${contacts.contacts}" value="id" sort="firstName" />
				</s:select>
	</th>
	</tr>
	</table>
	
	<div>Attachments:</div>
	<div><s:errors field="attachments"/></div>
	<div class="left">
		<c:forEach var="index" begin="0" end="3">
			<div><s:file name="attachments[${index}]"/></div>
		</c:forEach>
	</div>
	
	<div class="left">
		<s:submit name="upload" value="Upload"/>
	</div>
	
	<s:hidden id="deleteIndex" name="deleteIndex"/>
<c:forEach items="${actionBean.message.attachments}" var="attach" varStatus="loop" >
	<s:image name="deleteAttachment" src="/images/delete.png" onclick="getElementById('deleteIndex').value=${loop.index}"
		style="border: none; vertical-align: bottom" />
	${attach.fileName} (${attach.size} bytes)
	<br/>
</c:forEach>
	
	<p>
		<br><br><br><br><br><br>
		<s:link beanclass="stripesbook.action.MessageListActionBean">Back to message list</s:link>
	</p>
	
	</s:form>
	
</s:layout-component>	
</s:layout-render>