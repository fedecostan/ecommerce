/****** ESTILOS PARA MOSTRAR U OCULTAR INFORMACIÓN PÁGINA WEB TESLA *****/

$('.bot-opcion#bot-uno').on('click', function(){
	MostrarOcultar('#uno');
	cambioBoton(this);
});

$('.bot-opcion#bot-dos').on('click', function(){
	MostrarOcultar('#dos');
	cambioBoton(this);
});

$('.bot-opcion#bot-tres').on('click', function(){
	MostrarOcultar('#tres');
	cambioBoton(this);
});



function MostrarOcultar(Mostrar){
	$('.opcion').removeClass('activa');
	$(Mostrar).addClass('activa');
}

function cambioBoton(botonActivo){
	$('.opciones > span').removeClass('activa');
	$(botonActivo).addClass('activa');
}
