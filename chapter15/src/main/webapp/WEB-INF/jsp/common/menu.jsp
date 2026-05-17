<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<c:forEach var="section" items="${actionBean.sections}">
	<s:useActionBean id="bean" beanclass="${section.beanclass}"/>
	<fmt:message var="text" key="${section.textKey}"/>
	<security:allowed bean="bean">
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
	</security:allowed>
	<security:notAllowed bean="bean">
		<span class="grayedOut">${text}</span>
	</security:notAllowed>	
</c:forEach>