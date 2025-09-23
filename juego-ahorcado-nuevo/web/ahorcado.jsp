<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Ahorcado — Proyecto JSP</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
    <main>
        <div class="cuadricula">
            <section class="panel" aria-labelledby="titulo-juego">
                <h2 id="titulo-juego" class="titulo-seccion">Juego del Ahorcado</h2>

                <div class="estado" role="status" aria-live="polite">
                    <span class="insignia" id="insigniaIntentos">
                        Errores: <strong id="valorIntentos">0</strong>
                    </span>
                    <span class="insignia exito">Máximo: 6 errores</span>
                    <span class="insignia">Tiempo: <span id="mostrarCronometro">00:00</span></span>
                </div>

                <div class="mostrar-palabra" id="espaciosPalabra"></div>

                <div class="imagen-ahorcado">
                    <img src="img/2.png" id="imagen0" style="display:none">
                    <img src="img/3.png" id="imagen1" style="display:none">
                    <img src="img/4.png" id="imagen2" style="display:none">
                    <img src="img/5.png" id="imagen3" style="display:none">
                    <img src="img/6.png" id="imagen4" style="display:none">
                    <img src="img/7.png" id="imagen5" style="display:none">
                    <img src="img/1.png" id="imagen6" style="display:none">
                </div>

                <div class="mensaje" id="mensaje">
                    ¡Bienvenido al juego del ahorcado! Adivina la palabra haciendo clic en las letras.
                </div>
                <div id="contenedorPista" class="contenedor-pista" style="display:none; text-align:center; margin-top:15px;">
                <p id="textoPista"></p>
                <img id="imagenPista" src="" alt="Imagen pista" style="max-width:150px; margin-top:10px; border-radius:12px; display:none;">
              </div>


                <div>
                    <h3 class="titulo-seccion">Teclado Virtual</h3>
                    <div class="teclado" id="teclado">
                        <button class="tecla" data-key="A">A</button>
                        <button class="tecla" data-key="B">B</button>
                        <button class="tecla" data-key="C">C</button>
                        <button class="tecla" data-key="D">D</button>
                        <button class="tecla" data-key="E">E</button>
                        <button class="tecla" data-key="F">F</button>
                        <button class="tecla" data-key="G">G</button>
                        <button class="tecla" data-key="H">H</button>
                        <button class="tecla" data-key="I">I</button>
                        <button class="tecla" data-key="J">J</button>
                        <button class="tecla" data-key="K">K</button>
                        <button class="tecla" data-key="L">L</button>
                        <button class="tecla" data-key="M">M</button>
                        <button class="tecla" data-key="N">N</button>
                        <button class="tecla" data-key="Ñ">Ñ</button>
                        <button class="tecla" data-key="O">O</button>
                        <button class="tecla" data-key="P">P</button>
                        <button class="tecla" data-key="Q">Q</button>
                        <button class="tecla" data-key="R">R</button>
                        <button class="tecla" data-key="S">S</button>
                        <button class="tecla" data-key="T">T</button>
                        <button class="tecla" data-key="U">U</button>
                        <button class="tecla" data-key="V">V</button>
                        <button class="tecla" data-key="W">W</button>
                        <button class="tecla" data-key="X">X</button>
                        <button class="tecla" data-key="Y">Y</button>
                        <button class="tecla" data-key="Z">Z</button>
                    </div>
                </div>

                <div style="text-align: center; margin-top: 20px;">
                    <button id="botonNuevoJuego" class="btn-primario">
                        Nuevo Juego (•﹏•;)
                    </button>
                    <button id="botonPista" class="btn-acento">
                        Pista ◉_◉
                    </button>
                </div>
            </section>
        </div>
    </main>
   <script>
    let palabras = [];
    <c:forEach var="palabra" items="${palabras}">
        palabras.push({
            nombrePalabra: "${palabra.nombre}",
            pista1: "${palabra.pista1}",
            pista2: "${palabra.pista2}",
            pista3: "${palabra.pista3}"
        });
    </c:forEach>
</script>


    <script src="js/script.js"></script>
</body>
</html>