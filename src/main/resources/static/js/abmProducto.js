/////////////////////////////////////////////////////////////////
///////////////BOTON NUEVO PRODUCTO ANIMACIÓN///////////////////
///////////////////////////////////////////////////////////////
var $btn = document.querySelector('.btn');

$btn.addEventListener('click', e => {
    window.requestAnimationFrame(() => {
        $btn.classList.remove('is-animating');

        window.requestAnimationFrame(() => {
            $btn.classList.add('is-animating');
        });
    });
});


//////////////////////////////////////////////////////////////
//////////VENTANA MODAL BOTON NUEVO PRODUCTO/////////////////
////////////////////////////////////////////////////////////
$('.boton-mensaje').on('click', mostrarModal);
$('#bot-cerrar-modal').on('click', cerrarModal);
$(document).on('keydown', comprobarTecla);


// funcion para mostrar ventana modal
function mostrarModal() {
    $('.fondoModal').fadeIn(500, function () {
        $('.contenidoModal').fadeIn(500);
    });
}

// funcion para cerrar la ventana modal
function cerrarModal() {
    $('.fondoModal, .contenidoModal').fadeOut(300);
}

// funcion para detectar si presiono tecla escape y cuando lo hago entonces cierra la ventana 
function comprobarTecla(e) {
    var codigoTecla = e.which;
    console.log(codigoTecla);

    if (codigoTecla == 27) {
        cerrarModal();
    }
}


///////////////////////////////////////////////////////////////////////////
///////////////MOSTRAR-OCULTAR BOTON DE VENTANA MODAL/////////////////////
/////////////////////////////////////////////////////////////////////////
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



