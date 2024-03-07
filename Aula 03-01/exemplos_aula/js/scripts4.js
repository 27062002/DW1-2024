"use strict";

function gerarNumero(min, max){
    let numero = Math.floor(Math.random() * (max + 1 - min) + min);
    return numero;
}

function gerarNumeros(){
    let min, max;
    let numeros = [];
    let resultado;
    const TOTAL = 10;

    min = document.getElementById('min').value;
    max = document.getElementById('max').value;
    resultado = document.getElementById('resultado');

    if(!isNaN(min) && !isNaN(max)){
        min = parseInt(min);
        max = parseInt(max);
        if(min <= max){
            for(let i = 0; i < TOTAL; i++){
                numeros[i] = gerarNumero(min, max);
            }
            resultado.value = numeros.join(' ');
        }else{
            resultado.value = "Erro: valor min tem que ser menor que max";
        }
    }else{
        saida = "Erro: Algum valor não é um número.";
    }
}