let horas, minutos, segundos;
let temposegundos;

horas = parseInt(prompt("Horas:"));
minutos = parseInt(prompt("Minutos:"));
segundos = parseInt(prompt("Segundos:"));

temposegundos=(horas*3600)+(minutos*60)+(segundos);
document.write('Tempo em segundos = ' + temposegundos);