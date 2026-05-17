<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

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
			function receiveResponse(data) {
				var result = eval(data.responseText);
				$('youGaveMe').update(result.youGaveMe);
				$('andIGiveYou').update(result.andIGiveYou);
			}
		</script>
	</s:layout-component>
	<s:layout-component name="body">
		<p>Let me double your money!</p>
		<p>
			<s:form beanclass="stripesbook.action.JavaScriptResolutionActionBean">
				You give me $
				<s:text name="youGiveMe" onkeyup="sendMoney(this);"/>
				<s:submit name="doubleMoney"/>
				<br><br>
				You gave me $ <span id="youGaveMe"></span>,
				and I give you $ <span id="andIGiveYou"></span> back!
			</s:form>
		</p>

	</s:layout-component>
</s:layout-render>