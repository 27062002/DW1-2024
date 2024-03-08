window.onload = confirmarPagina;

function confirmarPagina() {
    document.getElementById("form1").addEventListener("submit", function(e) { 
        let submeter = validarDados(this);
        if(!submeter) {
            e.preventDefault();
        }
    });
}

function validarDados(form1) {
    let senha, consenha;

    senha = form1.elements["senha"].value;
    consenha = form1.elements["consenha"].value;

    if(senha == consenha){
        return true;
    }else{
        alert("senhas diferentes");
        return false;
    }
}