let palabraActual = '';
let letrasAdivinadas = [];
let intentos = 6;
let juegoTerminado = false;
let segundos = 0;
let minutos = 0;
let cronometro = null;
let contadorPista = 0;

document.addEventListener('DOMContentLoaded', () => {
    inicializarEventos();
    nuevoJuego();
});

const inicializarEventos = () => {
    document.addEventListener('keydown', manejarEntrada);

    const teclas = document.querySelectorAll('.tecla');
    teclas.forEach(boton => {
        boton.addEventListener('click', () => {
            manejarLetra(boton.dataset.key);
        });
    });

    const btnNuevo = document.getElementById('botonNuevoJuego');
    if (btnNuevo) btnNuevo.addEventListener('click', nuevoJuego);

    const btnPista = document.getElementById('botonPista');
    if (btnPista) btnPista.addEventListener('click', mostrarPista);
};

const manejarEntrada = (event) => {
    const key = event.key ? event.key.toUpperCase() : '';
    manejarLetra(key);
};

const manejarLetra = (letra) => {
    if (juegoTerminado) return;
    if (!letra || !/^[A-ZÑ]$/.test(letra)) return;

    const boton = document.querySelector(`.tecla[data-key="${letra}"]`);
    if (boton) boton.disabled = true;

    // Evita penalizar si ya fue adivinada (correcta o incorrecta)
    if (letrasAdivinadas.includes(letra)) return;

    if (palabraActual.includes(letra)) {
        letrasAdivinadas.push(letra);
        actualizarEspacios();
        verificarVictoria();
    } else {
        // guardo la letra equivocada para que no penalice dos veces
        letrasAdivinadas.push(letra);
        intentos--;
        actualizarIntentos();
        verificarDerrota();
    }
};

const nuevoJuego = () => {
    if (!palabras || palabras.length === 0) {
        actualizarMensaje("⚠️ No hay palabras disponibles en la BD.");
        return;
    }

    const indiceAleatorio = Math.floor(Math.random() * palabras.length);
    const palabraSeleccionada = palabras[indiceAleatorio];

    palabraActual = (palabraSeleccionada.nombrePalabra || '').toUpperCase().trim();
    letrasAdivinadas = [];
    intentos = 6;
    juegoTerminado = false;
    contadorPista = 0;

    document.querySelectorAll('.tecla').forEach(boton => {
        boton.disabled = false;
    });

    const espacios = document.getElementById('espaciosPalabra');
    if (espacios) espacios.textContent = '';

    const mensaje = document.getElementById('mensaje');
    if (mensaje) mensaje.textContent = '';

    // AGREGAR ESTAS LÍNEAS PARA LIMPIAR LA PISTA
    const contenedorPista = document.getElementById('contenedorPista');
    const textoPista = document.getElementById('textoPista');
    const imagenPista = document.getElementById('imagenPista');
    
    if (contenedorPista) contenedorPista.style.display = 'none';
    if (textoPista) textoPista.textContent = '';
    if (imagenPista) {
        imagenPista.src = '';
        imagenPista.style.display = 'none';
    }
    // FIN DE LAS LÍNEAS AGREGADAS

    actualizarEspacios();
    actualizarIntentos();
    actualizarMensaje('Nuevo juego iniciado. ¡Suerte!');
    reiniciarCronometro();
};

const actualizarEspacios = () => {
    const espacios = palabraActual
        .split('')
        .map(letra => letra === ' ' ? ' ' : (letrasAdivinadas.includes(letra) ? letra : '_'))
        .join(' ');

    const cont = document.getElementById('espaciosPalabra');
    if (cont) cont.textContent = espacios;
};

const actualizarIntentos = () => {
    const el = document.getElementById('valorIntentos');
    if (el) el.textContent = intentos;

    for (let i = 0; i <= 6; i++) {
        const img = document.getElementById(`imagen${i}`);
        if (img) img.style.display = 'none';
    }

    const errores = 6 - intentos;
    const imgMostrar = document.getElementById(`imagen${errores}`);
    if (imgMostrar) imgMostrar.style.display = 'block';
};

const actualizarMensaje = (mensaje) => {
    const el = document.getElementById('mensaje');
    if (el) el.textContent = mensaje;
};

const verificarVictoria = () => {
    const palabraMostrada = palabraActual
        .split('')
        .map(letra => (letra === ' ' ? ' ' : (letrasAdivinadas.includes(letra) ? letra : '_')))
        .join('');

    if (palabraMostrada === palabraActual) {
        actualizarMensaje('🎉 ¡Ganaste! La palabra era: ' + palabraActual);
        juegoTerminado = true;
        detenerCronometro();
        document.querySelectorAll('.tecla').forEach(b => b.disabled = true);
    }
};

const verificarDerrota = () => {
    if (intentos <= 0) {
        actualizarMensaje('💀 Perdiste. La palabra era: ' + palabraActual);
        juegoTerminado = true;
        detenerCronometro();
        document.querySelectorAll('.tecla').forEach(b => b.disabled = true);
    }
};

const mostrarPista = () => {
  if (juegoTerminado) {
    actualizarMensaje('Inicia un nuevo juego para usar la pista.');
    return;
  }

  const palabraSeleccionada = palabras.find(p => (p.nombrePalabra || '').toUpperCase() === palabraActual);
  if (!palabraSeleccionada) {
    actualizarMensaje('⚠️ No hay pistas disponibles.');
    return;
  }

  const pistas = [palabraSeleccionada.pista1, palabraSeleccionada.pista2, palabraSeleccionada.pista3].filter(Boolean);
  const contenedorPista = document.getElementById('contenedorPista');
  const textoPista = document.getElementById('textoPista');
  const imagenPista = document.getElementById('imagenPista');

  if (contadorPista < pistas.length) {
    // Mostrar la pista de texto
    textoPista.textContent = '💡 Pista: ' + pistas[contadorPista];
    
    // Mostrar la imagen correspondiente a la palabra
    const nombreImg = palabraSeleccionada.nombrePalabra.toLowerCase() + '.png';
    imagenPista.src = 'img/' + nombreImg;
    imagenPista.style.display = 'block';
    
    // Mostrar el contenedor completo
    contenedorPista.style.display = 'block';
    
    contadorPista++;
  } else {
    textoPista.textContent = 'Ya no hay más pistas disponibles.';
    // Mantener la imagen visible aunque no haya más pistas de texto
    if (imagenPista.src) {
      imagenPista.style.display = 'block';
    }
  }
};

const iniciarCronometro = () => {
    cronometro = setInterval(() => {
        segundos++;
        if (segundos === 60) {
            segundos = 0;
            minutos++;
        }
        const el = document.getElementById('mostrarCronometro');
        if (el) el.textContent = (minutos < 10 ? '0' : '') + minutos + ':' + (segundos < 10 ? '0' : '') + segundos;
    }, 1000);
};

const detenerCronometro = () => {
    if (cronometro) {
        clearInterval(cronometro);
        cronometro = null;
    }
};

const reiniciarCronometro = () => {
    detenerCronometro();
    segundos = 0;
    minutos = 0;
    const el = document.getElementById('mostrarCronometro');
    if (el) el.textContent = '00:00';
    iniciarCronometro();
};