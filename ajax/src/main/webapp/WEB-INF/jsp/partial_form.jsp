<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:form partial="true" beanclass="stripesbook.action.PartialFormActionBean" >
	<s:select name="models">
		<s:option value="" label="..."/>
		<s:options-collection collection="${actionBean.models}"/>
	</s:select>
</s:form>