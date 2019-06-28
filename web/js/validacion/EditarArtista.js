/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validate() {
    var nombreArtista = document.getElementById("nombreArt").value;
    var empresa = $("select option:selected").val();
    var telefono = document.getElementById("phoneArt").value;
    
    var camposValidos = true;
    
    if (nombreArtista.length < 2) {
        camposValidos = false;
        alert(nombreArtista + "  El nombre debe ser mayor de 3 digitos");
    }
    if (empresa == "0" ){
        camposValidos = false;
        alert("Seleccionar empresa");
    }
    
    if (telefono.length < 10) {
        camposValidos = false;
        alert(telefono + "El telefono debe ser de 10 digitos");

    }
    return camposValidos;

}

document.getElementById("enviarArt").onclick = validate;

