<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/reusable_layout/web/default_content_in_decorators/layout_decorator.jsp" title="My Title">
	<s:layout-component name="body">
		Hello, reusable layout
	</s:layout-component>
	<s:layout-component name="adsRight">
		My Ads Right
	</s:layout-component>
</s:layout-render>