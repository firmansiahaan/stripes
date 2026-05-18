<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Simple AJAX example" >
	<s:layout-component name="head">
		<script type="text/javascript">
			function sendMoney(control) {
				var form = control.form;
				new Ajax.Updater('result', form.action,
					{ 	method: 'post',
						parameters: form.serialize({submit: control.name})
					}
				);
				return false;
			}
		</script>
	</s:layout-component>
	<s:layout-component name="body">
		<p>Let me double your money!</p>
		<p>
			<s:form beanclass="stripesbook.action.MultipleSubmitActionBean">
				You give me $
				<s:text name="youGiveMe"/><br><br>
				<s:submit name="doubleMoney" value="Send" onclick="return sendMoney(this);" />
				<s:submit name="cancel" value="Cancel" onclick="return sendMoney(this);" />
				<br><br>
			</s:form>
		</p>
		<p id="result"></p>

	</s:layout-component>
</s:layout-render>