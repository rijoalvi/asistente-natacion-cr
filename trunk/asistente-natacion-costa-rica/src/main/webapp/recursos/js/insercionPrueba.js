var data = {
    'id_entrenamiento': 1,
    'distancia': 100,
    'estilo': 1,
    'consecutivo': 3,
    'tipo': 'a'
};
this.datos = {};
$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/gestion/entrenamiento/prueba',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});


