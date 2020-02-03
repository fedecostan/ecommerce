//////////////////////////////////////////////////
///////////////MENU RESPONSIVE///////////////////
////////////////////////////////////////////////
$('.boton-responsive').on('click', function () {
    $('.menu').toggleClass('abierto');
});


/////////////////////////////////////////////
///////////////MENU RETRACTIL///////////////
///////////////////////////////////////////
$(window).on('scroll', retraerMenu);

var ultimoValorScroll=0;

function retraerMenu(){

    var scrollActual = $(window).scrollTop()
    console.log(scrollActual);

    // chequear posicion del escroll y reducir menu
    if(scrollActual>ultimoValorScroll){
        $('.menu1').addClass('oculto');
    }else{
        $('.menu1').removeClass('oculto');			
    }

    // despues de chequear si estoy bajando, actualizo el valor de la variable ultimaValorScroll para que asi, cuando vuelva a general la llamada a la funcion y se genere un nuevo valor de scroll actual tenga datos actualizados.
    ultimoValorScroll=scrollActual;
}