Backbone.ajax = function () {
    var args = Array.prototype.slice.call(arguments, 0);
    _.extend(args[0], {
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json'
    });
    return Backbone.$.ajax.apply(Backbone.$, args);
};

window.Asistente = window.Asistente || {};
window.Asistente.vistaPrincipal = Backbone.View.extend({
    el: "#contenedor-aplicacion",
    templatePruebas: _.template($("#templatePruebas").html()),
    templateEquipos: _.template($("#templateEquipos").html()),
    templateEntrenamientos: _.template($("#templateEntrenamientos").html()),
    events: {
        "click .nav-tabs a": "cargarEntrenamientos",
        "click .entrenamientos a": "cargarPruebas",
        "click #boton-volver-entrenamientos": "mostrarEntrenamientos",
        "click .entrenamientos .boton-borrar-entrenamiento": "borrarFilaEntrenamientos",
        "click .pruebas .boton-borrar-prueba": "borrarFilaPruebas",
        "click .entrenamientos .boton-agregar-entrenamiento": "agregarFilaEntrenamientos",
        "click .pruebas .boton-agregar-prueba": "agregarFilaPruebas",
        "click .entrenamientos .boton-guardar-entrenamiento": "guardarFilaEntrenamientos",
        "click .pruebas .boton-guardar-prueba": "guardarFilaPruebas"
    },
    render: function () {
        this.cargarTabs();
        return this;
    },
    guardarFilaEntrenamientos: function (e) {
        e.preventDefault();
        var tmp = $(e.target).parent().find('input').val();
        $(e.target).parent().html('<a href="#">'+tmp+'</a><button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-entrenamiento">&times;</button>');
    },
    guardarFilaPruebas: function (e) {
        e.preventDefault();
        $(e.target).html('<button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-prueba">&times;</button>');
    },
    borrarFilaEntrenamientos: function(e) {
        e.preventDefault();
        $(e.target).parent().parent().remove();
    },
    borrarFilaPruebas: function(e) {
        e.preventDefault();
        $(e.target).parent().parent().parent().remove();
    },
    agregarFilaEntrenamientos: function (e) {
        e.preventDefault();
        var nuevaFila = $(e.target).parent().parent().parent().find('tr:last').clone();
        nuevaFila.find('.fechaEntrenamiento').html('<input type="text" class="entrenamientoSinGuardar" placeholder="Fecha" ><button style="color:#C00; opacity: 2;" type="button" class="close boton-borrar-entrenamiento">&times;</button>');
        nuevaFila.find('.boton-borrar-entrenamiento').addClass('boton-guardar-entrenamiento').removeClass('boton-borrar-entrenamiento');
        nuevaFila.find('.boton-guardar-entrenamiento').css({'color':'#0000FF'});
        nuevaFila.find('.boton-guardar-entrenamiento').text("\u2713");
        $(e.target).parent().parent().parent().append(nuevaFila);
    },
    agregarFilaPruebas: function (e) {
        e.preventDefault();
        var nuevaFila = $('#placeholder-prueba').clone();
        nuevaFila.find('.distancia').val(25);
        nuevaFila.find('.estilo').val(1);
        nuevaFila.find('.tipoPrueba').val("");
        nuevaFila.find('.boton-borrar-prueba').addClass('boton-guardar-prueba').removeClass('boton-borrar-prueba');
        nuevaFila.find('.boton-guardar-prueba').css({'color':'#0000FF'});
        nuevaFila.find('.boton-guardar-prueba').text("\u2713");
        $(e.target).parent().parent().parent().append(nuevaFila);
    },
    mostrarEntrenamientos: function () {
        $('.active .pruebas').fadeOut(400, function () {
            $('#boton-volver-entrenamientos').addClass('hidden')
            $('.active .entrenamientos').fadeIn(400);
        });
    },
    cargarPrimerEntrenamiento: function (idEquipo) {
        var entrenamientos = new Asistente.entrenamientos();
        var template = this.templateEntrenamientos;
        var $el = this.$el;
        var data = {
            'id_equipo': idEquipo
        };
        entrenamientos.fetch({
            data: JSON.stringify(data),
            success: function (collection, response, options) {
                var coleccionParseada = collection.toJSON();
                coleccionParseada.equipoId = idEquipo;
                $el.find('#tabs-content-container').fadeOut(400, function () {
                    $(this).html(template({
                        entrenamientos: coleccionParseada
                    })).fadeIn(400);
                });

                ;
            },
            error: function (collection, xhr, options) {
                console.log("Error: ", xhr);
            }
        });
    },
    cargarEntrenamientos: function (e) {

    },
    cargarPruebas: function (e) {
        e.preventDefault();
        var idEquipo = parseInt($(e.target).parent().parent().parent().parent().parent().parent().attr("id").split("-")[1]);
        var fechaOriginal = $(e.target).text().split("-");
        var fechaParseada = fechaOriginal[2] + "-" + fechaOriginal[1] + "-" + fechaOriginal[0];
        var template = this.templatePruebas;
        var $el = $(e.target).parent().parent().parent().parent().parent().parent();
        var pruebas = new Asistente.pruebas();
        var data = {
            'id_equipo': idEquipo,
            'fecha': fechaParseada
        };
        pruebas.fetch({
            data: JSON.stringify(data),
            success: function (collection, response, options) {
                $el.find('.pruebas').fadeOut(400, function () {
                    $(this).html(template({
                        pruebas: collection.toJSON()
                    }));
                    var that = $(this);
                    $('.active .entrenamientos').fadeOut(400, function () {
                        that.fadeIn(400);
                        $('#boton-volver-entrenamientos').removeClass('hidden');
                    });
                });
            },
            error: function (collection, xhr, options) {
                console.log("Error: ", xhr);
            }
        });
    },
    cargarTabs: function () {
        var self = this;
        var equipos = new Asistente.equipos();
        var template = this.templateEquipos;
        var $el = this.$el;
        var primerEquipo;
        var data = {
            'id_usuario': idUsuario
        };
        equipos.fetch({
            data: JSON.stringify(data),
            success: function (collection, response, options) {
                $el.find('#tabs-container').fadeOut(400, function () {
                    $(this).html(template({
                        equipos: collection.toJSON()
                    })).fadeIn(400);
                });
                self.cargarPrimerEntrenamiento(collection.models[0].id);;
            },
            error: function (collection, xhr, options) {
                console.log("Error: ", xhr);
            }
        });
    }
});