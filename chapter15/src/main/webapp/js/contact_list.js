function filterContacts(field, url) {
	$.get(url,
		{	'filter' : $(field).val(),
			'_eventName': 'findByName'
		},
		function(data) {
			$('#contact_table').html(data);
		}
	);
}

function ajaxLink(link, update) {
	$.get(link, function(data) {
		$(update).html(data);
		$(update).show();
	});
	return false;
}