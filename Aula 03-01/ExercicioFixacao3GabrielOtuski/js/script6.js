let segundos;
let tempohoras, tempominutos, temposegundos;

segundos = parseInt(prompt("Segundos:"));

tempohoras=parseInt(segundos/3600);
tempominutos=parseInt((segundos%3600)/60);
temposegundos=parseInt((segundos%3600)%60);
document.write(tempohoras + ' Horas-' + tempominutos + ' Minutos-' + temposegundos + ' Segundos.');