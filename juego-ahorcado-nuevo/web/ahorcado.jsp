<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <div>
                <address class="href= login.jsp"></address>
            </div>
            <section class="panel" aria-labelledby="titulo-juego">
                <h2 id="titulo-juego" class="titulo-seccion">Juego del Ahorcado</h2>

                <div class="estado" role="status" aria-live="polite">
                    <span class="insignia" id="insigniaIntentos" data-intentos="0" title="Intentos fallidos">
                       Errores: <strong style="margin-left:6px" id="valorIntentos">0</strong>
                    </span>
                    <span class="insignia exito" id="insigniaRegla" title="Regla del juego">
                        Máximo: 6 errores
                    </span>
                    <span class="insignia" id="insigniaTiempo" title="Tiempo transcurrido">
                        Tiempo: <span id="mostrarCronometro" style="margin-left:6px">00:00</span>
                    </span>
                </div>
                
                <div class="mostrar-palabra" id="espaciosPalabra" aria-label="Letras de la palabra" data-longitud-minima="3" data-longitud-maxima="15">
                </div>
                
                <div class="imagen-ahorcado">
                    <img src="img/2.png" alt="" id="imagen0" style="display:none">
                    <img src="img/3.png" alt="" id="imagen1" style="display:none">
                    <img src="img/4.png" alt="" id="imagen2" style="display:none">
                    <img src="img/5.png" alt="" id="imagen3" style="display:none">
                    <img src="img/6.png" alt="" id="imagen4" style="display:none">
                    <img src="img/7.png" alt="" id="imagen5" style="display:none">
                    <img src="img/1.png" alt="" id="imagen6" style="display:none">
                </div>
                
                <div class="mensaje" id="mensaje" aria-live="polite">
                    ¡Bienvenido al juego del ahorcado! Adivina la palabra haciendo clic en las letras.
                </div>

                <div>
                    <h3 class="titulo-seccion">Teclado Virtual</h3>
                    <div class="teclado" id="teclado" role="group" aria-label="Teclado virtual para seleccionar letras">
                        <button class="tecla" data-key="A" title="Letra A">A</button>
                        <button class="tecla" data-key="B" title="Letra B">B</button>
                        <button class="tecla" data-key="C" title="Letra C">C</button>
                        <button class="tecla" data-key="D" title="Letra D">D</button>
                        <button class="tecla" data-key="E" title="Letra E">E</button>
                        <button class="tecla" data-key="F" title="Letra F">F</button>
                        <button class="tecla" data-key="G" title="Letra G">G</button>
                        <button class="tecla" data-key="H" title="Letra H">H</button>
                        <button class="tecla" data-key="I" title="Letra I">I</button>
                        <button class="tecla" data-key="J" title="Letra J">J</button>
                        <button class="tecla" data-key="K" title="Letra K">K</button>
                        <button class="tecla" data-key="L" title="Letra L">L</button>
                        <button class="tecla" data-key="M" title="Letra M">M</button>
                        <button class="tecla" data-key="N" title="Letra N">N</button>
                        <button class="tecla" data-key="Ñ" title="Letra Ñ">Ñ</button>
                        <button class="tecla" data-key="O" title="Letra O">O</button>
                        <button class="tecla" data-key="P" title="Letra P">P</button>
                        <button class="tecla" data-key="Q" title="Letra Q">Q</button>
                        <button class="tecla" data-key="R" title="Letra R">R</button>
                        <button class="tecla" data-key="S" title="Letra S">S</button>
                        <div></div>
                        <button class="tecla" data-key="T" title="Letra T">T</button>
                        <button class="tecla" data-key="U" title="Letra U">U</button>
                        <button class="tecla" data-key="V" title="Letra V">V</button>
                        <button class="tecla" data-key="W" title="Letra W">W</button>
                        <button class="tecla" data-key="X" title="Letra X">X</button>
                        <button class="tecla" data-key="Y" title="Letra Y">Y</button>
                        <button class="tecla" data-key="Z" title="Letra Z">Z</button>
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
        <c:forEach var="p" items="${palabras}">
            palabras.push({
                nombrePalabra: "${p.nombre}",
                pista1: "${p.pista1}",
                pista2: "${p.pista2}",
                pista3: "${p.pista3}"
            });
        </c:forEach>
    </script>
    <script src="js/script.js"></script>
</body>
</html>