function calcularMedia(){
    let idade1, idade2, media, saida, resultado;

    idade1 = document.getElementById('idade1').value;
    idade2 = document.getElementById('idade2').value;

    resultado = document.getElementById('resultado');

    if(!isNaN(idade1) && !isNaN(idade2)){


    }else{
        saida = "Algum valor não é um número.";
    }

    resultado.value = saida;
}