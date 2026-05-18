<%@include file="/WEB-INF/jsp/common/taglibs.jsp" %>

<s:layout-render name="/WEB-INF/jsp/common/layout_main.jsp" title="Simple AJAX example" >
	<s:layout-component name="head">
		<script type="text/javascript">
			function updateModels(control) {
				var form = control.form;
				var params = $H(form.serialize(true)).update({'_eventName':'updateModels'});
				new Ajax.Updater('modelChoices', form.action,
				{ 	method: 'post',
					parameters: params
				});
			}
		</script>
	</s:layout-component>
	
	<s:layout-component name="body">
	
		<s:form beanclass="stripesbook.action.PartialFormActionBean">
			Make:
			<s:select name="make" onchange="updateModels(this);">
				<s:option value="" label="..."/>
				<s:options-map map="${actionBean.cars}" label="key"/>
			</s:select>
			
			Model:
			<span id="modelChoices">
				<s:select name="models"/>
			</span>
		</s:form>
	
	</s:layout-component>
</s:layout-render>