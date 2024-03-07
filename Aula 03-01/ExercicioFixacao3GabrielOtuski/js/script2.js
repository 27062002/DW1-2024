let notaExercicios, notaTrabalhos;
let notaFinal;

notaExercicios = parseFloat(prompt("Digite a nota dos exercícios de fixação:"));
notaTrabalhos = parseFloat(prompt("Digite a nota do trabalho prático:"));

notaFinal=(notaExercicios*0.3)+(notaTrabalhos*0.7);
document.write('A nota do aluno é = ' + notaFinal);