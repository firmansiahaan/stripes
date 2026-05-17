function receiveResponse(data) {
	var result = eval(data.responseText);
	$('youGaveMe').update(result.youGaveMe);
	$('andIGiveYou').update(result.andIGiveYou);
}