function calcularMedia(){
    let idade1, idade2, media, saida, resultado;

    idade1 = document.getElementById('idade1').value;
    idade2 = document.getElementById('idade2').value;

    resultado = document.getElementById('resultado');

    if(!isNaN(idade1) && !isNaN(idade2)){
        idade1 = parseInt(idade1);
        idade2 = parseInt(idade2);

        if(idade1>0 && idade2>0){
            media = (idade1 + idade2)/2;
            saida = "Media das idades = " + media;
        }else{
            saida = "Algum número não é positivo";
        }

    }else{
        saida = "Algum valor não é um número.";
    }

    resultado.value = saida;
}