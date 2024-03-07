window.onload = registrarFuncoes;

function registrarFuncoes() {
    let botao = document.getElementById('botao');
    botao.addEventListener('click', function(){
        let paragrafo = document.getElementById('paragrafo');
        definirParagrafo(paragrafo);
    });
}

function definirParagrafo(paragrafo) {
    let areaTexto, texto;

    areaTexto = document.getElementById('texto');

    texto = areaTexto.value;
    
    paragrafo.innerHTML = texto;
}
