<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<jsp:useBean class="stripesbook.view.FoldersViewHelper" id="folders"/>
<div id="action">
	<s:submit name="delete" value="Delete"/>
	Move to folder:
	<s:select name="selectedFolder">
		<s:option value="">Select a folder...</s:option>
		<s:options-collection collection="${folders.folders}" value="id" label="name" />
	</s:select>
	<s:submit name="moveToFolder" value="Move"/>
	<s:errors field="selectedFolder"/>
</div>