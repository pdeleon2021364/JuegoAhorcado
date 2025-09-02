let palabraSecreta = "";
let palabraReal =  [];
let intentosfallidos = 0;
let letrasUsadas = new Set; // esto es para que tenga un buen control 
let juegoActivo = false;

const palabras = [
    { palabra: 'JAVASCRIPT', pista: 'Lenguaje de programación web' },
    { palabra: 'PROGRAMACION', pista: 'Escribir código para computadoras' },
    { palabra: 'COMPUTADORA', pista: 'Máquina que procesa datos' },
    { palabra: 'KINAL', pista: 'Institucion que se dedica al trabajo bien hecho'},
    { palabra: 'HOSPITAL', pista: 'Centro donde se ayudan a personas con enfermedades'},
    { palabra: 'RESTAURANTE', pista: 'Lugar donde se va a comer y pasar un buen momento'}
];


