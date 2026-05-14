<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<s:layout-definition>
	<jsp:useBean class="stripesbook.view.FoldersViewHelper" id="folders"/>
	<s:layout-render name="/WEB-INF/jsp/common/layout_menu.jsp" title="${title}" currentSession="${currentSession}">
		<s:layout-component name="body">
			<div id="folders">
				<d:table name="${folders.folders}" id="folder">
				<d:column title="Name">
					<s:link beanclass="stripesbook.action.MessageListActionBean" >
						<s:param name="folder" value="${folder.id}"/>
						${folder.name}
					</s:link>
					<c:if test="${actionBean.context.currentFolder eq folder}"> 
						<img src="${contextPath}/images/arrow.png" style="border: none; vertical-align: bottom" />
					</c:if>
				</d:column>
				<d:column title="Messages" style="text-align: right">
					${fn:length(folder.messages)}
				</d:column>
				</d:table>
			</div>
			<div id="main">
				${body}
			</div>
		</s:layout-component>	
	</s:layout-render>
</s:layout-definition>