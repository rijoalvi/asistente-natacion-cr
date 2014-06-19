var data = {
    'nombre_usuario': 'rijoalvi',
    'contrasena': '88',
    'nombre': 'Ricardo',
    'apellidos': 'Alvarado Villalobos',
    'email': 'rijoalvi@gmail.com',
    'tipo': 1,
    'id_nadador': 0
};
this.datos = {};
$(document).ready(function() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/gestion/usuario',
        success: alert('data'),
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json'
    }).done(function(data) {
        datos = data;
    });
});