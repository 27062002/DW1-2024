window.onload = registrarFuncoes;

function registrarFuncoes() {
    let botao = document.getElementById('botao');
    botao.onclick = definirParagrafo;
}

function definirParagrafo() {
    let areaTexto, paragrafo, texto;

    areaTexto = document.getElementById('texto');
    paragrafo = document.getElementById('paragrafo');

    texto = areaTexto.value;
    
    paragrafo.innerHTML = texto;
}
