let palabraActual = '';
let letrasAdivinadas = [];
let intentos = 6;
let juegoTerminado = false;
let segundos = 0;
let minutos = 0;
let cronometro;
let contadorPista = 0;

document.addEventListener('DOMContentLoaded', () => {
    inicializarEventos();
    nuevoJuego();
});

const inicializarEventos = () => {
    // Teclado físico
    document.addEventListener('keydown', manejarEntrada);

    // Teclado virtual
    const teclas = document.querySelectorAll('.tecla');
    teclas.forEach(boton => {
        boton.addEventListener('click', () => {
            manejarLetra(boton.dataset.key);
        });
    });

    // Botones de control
    document.getElementById('botonNuevoJuego').addEventListener('click', nuevoJuego);
    document.getElementById('botonPista').addEventListener('click', mostrarPista);
};

const manejarEntrada = (event) => {
    manejarLetra(event.key.toUpperCase());
};

const manejarLetra = (letra) => {
    if (juegoTerminado) return;
    if (!/^[A-ZÑ]$/.test(letra)) return;

    // Deshabilitar botón en teclado virtual si existe
    const boton = document.querySelector(`.tecla[data-key="${letra}"]`);
    if (boton) boton.disabled = true;

    if (palabraActual.includes(letra)) {
        if (!letrasAdivinadas.includes(letra)) {
            letrasAdivinadas.push(letra);
            actualizarEspacios();
            verificarVictoria();
        }
    } else {
        intentos--;
        actualizarIntentos();
        verificarDerrota();
    }
};

const nuevoJuego = () => {
    if (!palabras || palabras.length === 0) {
        actualizarMensaje("No hay palabras disponibles en la BD.");
        return;
    }

    const indiceAleatorio = Math.floor(Math.random() * palabras.length);
    const palabraSeleccionada = palabras[indiceAleatorio];

    palabraActual = palabraSeleccionada.nombrePalabra.toUpperCase();
    letrasAdivinadas = [];
    intentos = 6;
    juegoTerminado = false;
    contadorPista = 0;

    // Reiniciar botones del teclado
    document.querySelectorAll('.tecla').forEach(boton => {
        boton.disabled = false;
    });

    actualizarEspacios();
    actualizarIntentos();
    actualizarMensaje('Nuevo juego iniciado. ¡Suerte!');
    reiniciarCronometro();
};

const actualizarEspacios = () => {
    const espacios = palabraActual
        .split('')
        .map(letra => (letrasAdivinadas.includes(letra) ? letra : '_'))
        .join(' ');

    document.getElementById('espaciosPalabra').textContent = espacios;
};

const actualizarIntentos = () => {
    document.getElementById('valorIntentos').textContent = intentos;

    for (let i = 0; i <= 6; i++) {
        const img = document.getElementById(`imagen${i}`);
        if (img) img.style.display = 'none';
    }

    // Mostrar la imagen correspondiente a los errores cometidos
    const errores = 6 - intentos;
    const imgMostrar = document.getElementById(`imagen${errores}`);
    if (imgMostrar) imgMostrar.style.display = 'block';
};

const actualizarMensaje = (mensaje) => {
    document.getElementById('mensaje').textContent = mensaje;
};

const verificarVictoria = () => {
    const palabraMostrada = palabraActual
        .split('')
        .map(letra => (letrasAdivinadas.includes(letra) ? letra : '_'))
        .join('');

    if (palabraMostrada === palabraActual) {
        actualizarMensaje('🎉 ¡Ganaste! La palabra era: ' + palabraActual);
        juegoTerminado = true;
        detenerCronometro();
    }
};

const verificarDerrota = () => {
    if (intentos <= 0) {
        actualizarMensaje('💀 Perdiste. La palabra era: ' + palabraActual);
        juegoTerminado = true;
        detenerCronometro();
    }
};

const mostrarPista = () => {
    if (juegoTerminado) {
        actualizarMensaje('Inicia un nuevo juego para usar la pista.');
        return;
    }

    const palabraSeleccionada = palabras.find(p => p.nombrePalabra.toUpperCase() === palabraActual);
    const pistas = [palabraSeleccionada.pista1, palabraSeleccionada.pista2, palabraSeleccionada.pista3];

    if (contadorPista < pistas.length) {
        actualizarMensaje(`💡 Pista: ${pistas[contadorPista]}`);
        contadorPista++;
    } else {
        actualizarMensaje('Ya no hay más pistas disponibles.');
    }
};

// Cronómetro
const iniciarCronometro = () => {
    cronometro = setInterval(() => {
        segundos++;
        if (segundos === 60) {
            segundos = 0;
            minutos++;
        }
        document.getElementById('mostrarCronometro').textContent =
            (minutos < 10 ? '0' : '') + minutos + ':' + (segundos < 10 ? '0' : '') + segundos;
    }, 1000);
};

const detenerCronometro = () => {
    clearInterval(cronometro);
};

const reiniciarCronometro = () => {
    clearInterval(cronometro);
    segundos = 0;
    minutos = 0;
    document.getElementById('mostrarCronometro').textContent = '00:00';
    iniciarCronometro();
};
