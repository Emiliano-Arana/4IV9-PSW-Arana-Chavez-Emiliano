/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validarNum(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[0-9]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validar(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[A-Za-zñáéíóú]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarMail(e){
    var teclado = (document.all)?e.keyCode:e.which;
    var patron = /[@a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]/;
    var prueba = String.fromCharCode(teclado);
    return patron.test(prueba);
}

function validarDatosR(){

    var verif = true;
    var nom = document.FormularioReg.nombre.value;
    var appat = document.FormularioReg.appat.value;
    var apmat = document.FormularioReg.apmat.value;
    var mail = document.FormularioReg.correo.value;
    var edad = document.FormularioReg.edad.value;

    var patNoms = /[A-Za-zñáéíóú]/;
    var patNum = /[0-9]/;

    if(nom.length<1){
        verif = false;
        alert("*El nombre es obligatorio");
    }

    if(nom.length>20){
        verif = false;
        alert("*Ingreso demasiados caracteres en nombre");
    }

    if(appat.length<1){
        verif = false;
        alert("*El apellido paterno es obligatorio");
    }

    if(appat.length>20){
        verif = false;
        alert("*Ingreso demasiados caracteres en apellido paterno");
    }

    if(apmat.length<1){
        verif = false;
        alert("*El apellido materno es obligatorio");
    }

    if(apmat.length>20){
        verif = false;
        alert("*Ingreso demasiados caracteres en apellido materno");
    }

    if(mail.length<1){
        verif = false;
        alert("*El email es obligatorio");
    }

    if(mail.length>30){
        alert("*Ingreso demasiados caracteres en email");
        verif = false;
    }

    if(edad.length<1){
        verif = false;
        alert("*La edad es obligatoria");
    }

    if(edad.length>2){
        alert("*Ingreso demasiados caracteres en edad");
        verif = false;
    }

    for(var i=0;i<nom.length;i++){
        if(patNoms.test(nom[i])){

        }else{
            alert("*Ingreso algun caracter invalido en nombre");
            verif = false;
        }
    }

    for(var i=0;i<appat.length;i++){
        if(patNoms.test(appat[i])){

        }else{
            alert("*Ingreso algun caracter invalido en apellido paterno");
            verif = false;
        }
    }

    for(var i=0;i<apmat.length;i++){
        if(patNoms.test(apmat[i])){

        }else{
            alert("*Ingreso algun caracter invalido en apellido materno");
            verif = false;
        }
    }

    for(var i=0;i<edad.length;i++){
        if(patNum.test(edad[i])){

        }else{
            alert("*Ingreso algun caracter invalido en edad");
            verif = false;
        }
    }

    return verif;
}

function validarDatosA(){

    var verif = true;
    var nom = document.FormularioAct.nombre.value;
    var appat = document.FormularioAct.appat.value;
    var apmat = document.FormularioAct.apmat.value;
    var mail = document.FormularioAct.correo.value;
    var edad = document.FormularioAct.edad.value;
    var id = document.FormularioAct.idact.value;

    var patNoms = /[A-Za-zñáéíóú]/;
    var patNum = /[0-9]/;
    
    if(id.length<1){
        verif = false;
        alert("*El id es obligatorio");
    }

    if(id.length>8){
        verif = false;
        alert("*Ingreso demasiados caracteres en id");
    }

    if(nom.length<1){
        verif = false;
        alert("*El nombre es obligatorio");
    }

    if(nom.length>20){
        verif = false;
        alert("*Ingreso demasiados caracteres en nombre");
    }

    if(appat.length<1){
        verif = false;
        alert("*El apellido paterno es obligatorio");
    }

    if(appat.length>20){
        verif = false;
        alert("*Ingreso demasiados caracteres en apellido paterno");
    }

    if(apmat.length<1){
        verif = false;
        alert("*El apellido materno es obligatorio");
    }

    if(apmat.length>20){
        verif = false;
        alert("*Ingreso demasiados caracteres en apellido materno");
    }

    if(mail.length<1){
        verif = false;
        alert("*El email es obligatorio");
    }

    if(mail.length>30){
        alert("*Ingreso demasiados caracteres en email");
        verif = false;
    }

    if(edad.length<1){
        verif = false;
        alert("*La edad es obligatoria");
    }

    if(edad.length>2){
        alert("*Ingreso demasiados caracteres en edad");
        verif = false;
    }
    
    for(var i=0;i<id.length;i++){
        if(patNum.test(id[i])){

        }else{
            alert("*Ingreso algun caracter invalido en id");
            verif = false;
        }
    }

    for(var i=0;i<nom.length;i++){
        if(patNoms.test(nom[i])){

        }else{
            alert("*Ingreso algun caracter invalido en nombre");
            verif = false;
        }
    }

    for(var i=0;i<appat.length;i++){
        if(patNoms.test(appat[i])){

        }else{
            alert("*Ingreso algun caracter invalido en apellido paterno");
            verif = false;
        }
    }

    for(var i=0;i<apmat.length;i++){
        if(patNoms.test(apmat[i])){

        }else{
            alert("*Ingreso algun caracter invalido en apellido materno");
            verif = false;
        }
    }

    for(var i=0;i<edad.length;i++){
        if(patNum.test(edad[i])){

        }else{
            alert("*Ingreso algun caracter invalido en edad");
            verif = false;
        }
    }

    return verif;
}