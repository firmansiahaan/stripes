<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>
<fmt:setBundle basename="StripesResources"/>
<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Simple AJAX example" >
	<s:layout-component name="head">
		<script type="text/javascript">
			function sendMoney(control) {
				var form = control.form;
				new Ajax.Request(form.action, 
					{
						method: 'post',
						parameters: form.serialize(),
						onSuccess: receiveResponse
					}		
				);
			}
			// xhr is the XMLHttpRequest, which is a core AJAX object
			function receiveResponse(xhr) {
				var result = eval(xhr.responseText);
				$('iGiveYou').update(result);
			}
		</script>
	</s:layout-component>
	<s:layout-component name="body">
		<p>Let me double your money!</p>
		<p>
			<s:form beanclass="stripesbook.action.HelloAjaxActionBean">
				You give me $
				<s:text name="youGiveMe" onkeyup="sendMoney(this);"/>
				<s:submit name="doubleMoney"/>
			</s:form>
		</p>
		<p>
			I give you $ <span id="iGiveYou"></span> back!
		</p>
	</s:layout-component>
</s:layout-render>