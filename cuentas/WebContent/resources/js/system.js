function fueHecho(datosRespuesta) {
	alert("Cuenta pagada con �xito");
}
function pagarAhora(id) {
//	$.get("pagarCuenta?id=" + id, fueHecho);

	$.post("pagarCuenta", {
		'id' : id
	}, function() {
		$("#cuenta_" + id).html("Pago");
	});
}