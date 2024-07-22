<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SaludGuard | Página principal</title>
    <link rel="stylesheet" href="./css/stylelanding.css">
</head>

<body>
    <div>
        <nav id="nav">
            <div id="box1">
                <img src="./img/landingPage/logosaludguard.png" alt="logo">
            </div>
            <div id="box2">
                <div id="menu">
                    <ul>
                        <li>
                            <a href="#">Inicio</a>
                            <a href="#">Nosotros</a>
                            <a href="#">Contacto</a>
                        </li>
                    </ul>
                    <button class="dropdown-button">Acceso</button>
                    <div class="dropdown-content">
                        <a href="/inicioSesion">Paciente</a>
                        <a href="/inicioSesion/doc">Medico</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
    <div id="contIMG">
        <div id="contImgtx">
        <h1>Tu historia en la palma
            de tu mano</h1>
            <h2>Con SaludGuard, tenés acceso a tu historia clínica desde cualquier lugar.</h2>
        </div>
        <img src="./img/landingPage/fondo1.jpg" alt="">
    </div>

    <div id="contTXT">
        <div id="tx">
            <h1>Bienvenido a SaludGuard</h1>
            <p>Con SaludGuard, podés acceder a tu historia clínica en cualquier momento y
                lugar, 10 que facilita la revisión de tus registros y la gestión de tu salud.</p>
            <ul>
                <li>Permite registros más rápidos en tu historia clínica</li>
                <li>Dlagnostlcos mas precisos y eficientes</li>
                <li>En caso de emergencias, tener acceso rápido a tu historial puede ser
                    crucial para recibir el tratamiento adecuado.</li>
            </ul>
        </div>
    </div>
    <div id="about">
        <div id="about1">
            <h1>Sobre Nosotros</h1>
        </div>
        <div id="about2">
            <p>En Salud Guard, nos dedicamos a transformar
                la gestión de la salud a través de la tecnología
                Nuestra aplicación está diseñada para
                proporcionar a los usuarios acceso fácil y
                seguro a su historial médico completo,
                permitiendo una mejor gestión de su salud y
                una comunicación más efectiva con los
                profesionales de la salud. Trabajamos
                incansablemente para ofrecer soluciones
                innovadoras que mejoren la calidad de vida de
                nuestros usuarios.</p>
        </div>
    </div>
    <div id="impcDat">
        <div id="impcDat1">
            <h1>NUMEROS DE IMPACTO</h1>
            <div class="SeparadorTit"></div>
        </div>
        
        <div id="impcDat2">
            <div class="boxDat">
                <p class="num">3.321</p>
                <p class="info">Doctores registrados</p>
            </div>
            <div class="boxDat">
                <p class="num">41.252</p>
                <p class="info">Historiales registrados</p>
            </div>
        </div>
        <div id="impcDat3">
            <h2>
                PREGUNTAS FRECUENTES
            </h2>
            <div id="Separador">
            </div>
            <div id="FaQ">
                <div id="FaqBox1">
                    <div class="Faq FaqSeleccted">¿EI servicio tiene algún costo?</div>
                    <div class="Faq">¿EI servicio tiene algún costo?</div>
                    <div class="Faq">¿EI servicio tiene algún costo?</div>
                    <div class="Faq">¿EI servicio tiene algún costo?</div>
                </div>
                <div id="FaqBox2">
                    Contenido de preguntas
                    HACER FUNCIONALIDAD JS
                </div>
            </div>
        </div>
    </div>
    <div id="contacto">
        <h2>CONTACTANOS</h2>
        <div class="SeparadorTit"></div>
    </div>
    <div id="contacBox">
        <div class="contactIMG">
            <div class="contactImgtx">
                <img src="./img/landingPage/ubicacion.png" alt="">
            <p id="direc">Calle Austral, 456</p>
            </div>
            <img src="./img/landingPage/duotone_7.png" alt="">
        </div>
        <div class="contactIMG">
            <div class="contactImgtx">
                <img id="teleimg" src="./img/landingPage/telefono-inteligente.png" alt="telefono">
            <p id="tele">+54 34846060</p>
            <img id ="EmailImg" src="./img/landingPage/email.png" alt="">
            <p id="email">kNk2J@example.com</p>
            </div>
            <img src="./img/landingPage/duotone_9.png" alt="">
        </div>
    </div>
</body>
<script src="./js/scriptlanding.js"></script>

</html>