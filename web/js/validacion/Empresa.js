/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




//var nombreAst = document.getElementById("nombreAst");
//var nitAst = document.getElementById("nitAst");
//var telefonoAst = document.getElementById("telefonoAst");
//var valorAst = document.getElementById("valorOperacion");
//var tipoAst = document.getElementById("tipoOperacion");

function validate() {
    var nombreEmpresa = document.getElementById("nombreEmp").value;
    var nit = document.getElementById("nit").value;
    var telefono = document.getElementById("telefono").value;
    var tOperacion = document.getElementById("tipoOperacion").value;

    var camposValidos = true;
    if (nombreEmpresa.length < 3) {
        camposValidos = false;
        alert(nombreEmpresa + "El nombre debe ser mayor de 3 digitos");
    }
    if (nit.length < 8) {
        camposValidos = false;
        alert("El nit debe ser de 8 u 10 digitos");

    }
    if (nit.length > 10) {
        camposValidos = false;
        alert("El nit debe ser de 8 u 10 digitos");

    }
    if (telefono.length < 10) {
        camposValidos = false;
        alert("El telefono debe ser de 10 digitos");

    }
    if (tOperacion.value == "Selecionar: ") {
        
        alert("Por favor seleccionar un tipo de operacion");
    }
    return camposValidos;

}

document.getElementById("enviarEmp").onclick = validate;