function validate() {
    var nombreEmpresa = document.getElementById("nombreEmp").value;
    var nit = document.getElementById("nit").value;
    var telefono = document.getElementById("telefono").value;
    var tOperacion = $("select option:selected").val();
    
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
   if (tOperacion == "0" ){
        camposValidos = false;
        alert("Seleccionar empresa");
    }
    return camposValidos;

}

document.getElementById("enviarEmp").onclick = validate;