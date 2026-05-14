<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<s:layout-render name="/reusable_layout/web/ads_and_menu_component/layout_decorator.jsp" title="My Title">
	<s:layout-component name="body">
		Hello, reusable layout
	</s:layout-component>
	<s:layout-component name="menu">
		My Menu
	</s:layout-component>
	<s:layout-component name="adsLeft">
		My Ads Left
	</s:layout-component>
	<s:layout-component name="adsRight">
		My Ads Right
	</s:layout-component>
</s:layout-render>