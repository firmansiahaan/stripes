<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<c:set var="menu">Default Menu</c:set>
<c:set var="body">Default Body</c:set>
<s:layout-definition>
	<table>
		<tr>
			<td>Ads Left</td>
			<td><s:layout-render name="/reusable_layout/web/default_content_in_decorators/layout.jsp">
					<s:layout-component name="body">
						<table>
							<tr>
								<td>${menu}</td>
								<td>${body}</td>
							</tr>
						</table>
					</s:layout-component>
				</s:layout-render></td>
			<td>Ads Right</td>
		</tr>
	</table>
</s:layout-definition>