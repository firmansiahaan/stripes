<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<c:forEach var="section" items="${actionBean.sections}">
	<fmt:message var="text" key="${section.textKey}"/>
	<c:choose>
		<c:when test="${section eq actionBean.currentSection}">
			<span class="currentSection">${text}</span>
		</c:when>
		<c:otherwise>
			<s:link beanclass="${section.beanclass}" class="sectionLink">
				${text}	
			</s:link>
		</c:otherwise>
	</c:choose>
</c:forEach>