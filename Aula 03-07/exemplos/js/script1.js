function definirParagrafo() {
    let areaTexto, paragrafo, texto;

    areaTexto = document.getElementById('texto');
    paragrafo = document.getElementById('paragrafo');

    texto = areaTexto.value;
    
    paragrafo.innerHTML = texto;
}