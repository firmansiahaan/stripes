function submitForm(button) {
	var form = button.form;
	var params = $(form).serializeArray();
	params.push({name:'_eventName' , value: button.name});
	var xhr = $.post(form.action, params, function(data) {
		if (xhr.getResponseHeader('X-Stripes-Success' )) {
			$('#contact_form' ).hide();
			$('#contact_table' ).html(data);
		}
		else {
			$('#contact_form' ).html(data);
		}
	});
	return false;
}