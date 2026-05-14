<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-definition>
	<table>
		<tr>
			<td>Ads Left</td>
			<td><s:layout-render name="/reusable_layout/web/ads_and_menu_component/layout.jsp">
					<s:layout-component name="body">
						<table>
							<tr>
								<td>Menu</td>
								<td>${body}</td>
							</tr>
						</table>
					</s:layout-component>
				</s:layout-render></td>
			<td>Ads Right</td>
		</tr>
	</table>
</s:layout-definition>