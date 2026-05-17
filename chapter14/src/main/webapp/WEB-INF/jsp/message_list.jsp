<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<c:set var="folder" value="${actionBean.context.currentFolder}"/>
<s:layout-render name="/WEB-INF/jsp/common/layout_folders.jsp" title="Message List" currentSection="MessageList" >
	<s:layout-component name="body">
		<s:form beanclass="stripesbook.action.MessageListActionBean">
		<d:table name="${folder.messages}" requestURI="" id="message" pagesize="10" defaultsort="2" defaultorder="descending" >
			<d:column>
				<s:checkbox name="selectedMessages" value="${message.id}"/>
			</d:column>
			<d:column title="Date" sortable="true">
				<s:format value="${message.date}" formatPattern="yyyy-MM-dd HH:mm" />
			</d:column>
			<d:column property="from" sortable="true"/>
			<d:column property="to" sortable="true"/>
			<d:column title="Subject" sortable="true">
				<s:link beanclass="stripesbook.action.MessageDetailsActionBean" >
					<s:param name="message" value="${message.id}"/>
					${message.subject}
				</s:link>
			</d:column>
		</d:table>
		<c:if test="${not empty folder.messages}">
			<div><s:errors field="selectedMessages"/></div>
			<%@include file="/WEB-INF/jsp/common/message_action.jsp" %>
		</c:if>
		</s:form>
	</s:layout-component>
</s:layout-render>