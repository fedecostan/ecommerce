// eventos en botones y llamada a las funciones
$('#bot-zona-1').on('click', function(e){
    e.preventDefault();
    // llamo a la función inventando un nombre y dentro meto un parametro, ('nombre del elemento donde quiero ir')
    desplazarScroll('.zona1');
});

// funcion para generar desplazamiento del scroll, llamo a la funcion e (invento la variable, es el parametro que utiliza la funcion)
function desplazarScroll(elemento){
    $('html').animate({
        scrollTop: $(elemento).offset().top
    }, 1000);
}

