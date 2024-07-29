<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SaludGuard | Página principal</title>
    <link rel="stylesheet" href="Style_landp.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Radio+Canada+Big:ital,wght@0,400..700;1,400..700&display=swap" rel="stylesheet">
</head>

<body class="radio-canada-big-body">

    <div>
        <nav id="nav">
            <div id="box1">
                <img src="./img/logosaludguard.png" alt="logo">
            </div>
            <div id="box2">
                <div id="menu">
                    <ul>
                        <li>
                            <a href="#contIMG">Inicio</a>
                            <a href="#Separador2">Nosotros</a>
                            <a href="#contacto">Contacto</a>
                        </li>
                    </ul>
                    <button class="dropdown-button">Acceso</button>
                    <div class="dropdown-content">
                        <a id="paciente" href="/inicioSesion">Paciente</a>
                        <a id="medico" href="/inicioSesion/doc">Médico</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>

    <div id="contIMG">
        <div id="contIMGTXT">
            <div id="mainlogo">
                    <img src="img/clicklogo.png" alt="logo">
                SaludGuard
            </div>
            <h1 class="txt-animacion">    Tu historia en la palma
                de tu mano</h1>
            <h2 class="txt-animacion">      Con SaludGuard, tenés acceso a tu historia clínica desde cualquier lugar.</h2>
        </div>
    </div>

    <div id="contTXT">
        <div id="tx">
            <h1 class="animacicion-str">Bienvenido a SaludGuard</h1>
            <p>Con SaludGuard, podés acceder a tu historia clínica en cualquier momento y lugar, facilitando la
                revisión de tus registros y la gestión de tu salud.</p>
            <ul>
                <li>Permite&nbsp;<strong class="animacicion-str">registros</strong>&nbsp;más&nbsp;<strong
                        class="animacicion-str">rápidos</strong>&nbsp;en tu historia
                    clínica</li>
                <li><strong class="animacicion-str">Diagnostlcos</strong>
                    &nbsp;más&nbsp;<strong class="animacicion-str">precisos</strong>&nbsp;y&nbsp;<strong
                        class="animacicion-str">eficientes</strong></li>
                <li>En caso de&nbsp;<strong class="animacicion-str">emergencias</strong>,&nbsp;tener acceso rápido a tu
                    historial puede
                    ser&nbsp;<strong class="animacicion-str">crucial</strong>&nbsp;para recibir tratamiento.
                </li>
            </ul>
        </div>
    </div>
    <div id="Separador2"></div>
    <div id="about">
        <div id="about1" class="view">
            <h1>Sobre Nosotros</h1>
        </div>
        <div id="about2" class="view">
            <p>En Salud Guard, nos dedicamos a transformar
                la gestión de la salud a través de la tecnología.
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
            <h1 class="NumerosImpc">NUMEROS DE IMPACTO</h1>
            <div class="SeparadorTit"></div>
        </div>

        <div id="impcDat2">
            <div class="boxDat">
                <p class="num"></p>
                <p class="info">Doctores registrados</p>
            </div>
            <div class="boxDat">
                <p class="num2"></p>
                <p class="info">Historiales registrados</p>
            </div>
        </div>
        <br>
        <br>
        <div id="impcDat3">
            <h2>
                PREGUNTAS FRECUENTES
            </h2>
            <div id="Separador">
            </div>
            <div id="FaQ">
                <div id="FaqBox1">
                    <div class="Faq ">¿EI servicio tiene algún costo?</div>
                    <div class="Faq">¿En que áreas funciona?</div>
                    <div class="Faq">¿Qué funciones posee?</div>
                    <div class="Faq">¿Funciona las 24 horas?</div>
                </div>

                <div id="answerBox" class="oculto">

                </div>
            </div>
        </div>
    </div>
    <div id="contacto">
        <h2 class="NumerosImpc">    CONTACTANOS</h2>
        <div class="SeparadorTit"></div>
    </div>
    <div id="contacBox">
        <div class="contactIMG">
            <div class="contactImgtx">
                <a id="direc"
                    href="https://www.google.com.ar/maps/place/Blvd.+Austral,+Pilar,+Provincia+de+Buenos+Aires/@-34.4524661,-58.8674718,17z/data=!3m1!4b1!4m6!3m5!1s0x95bc9c5ce6ed2b55:0xda1fca18f11985f6!8m2!3d-34.4524661!4d-58.8648969!16s%2Fg%2F11j11cnjbb?entry=ttu"><i
                        class="fa fa-globe" aria-hidden="true"></i>
                    Calle Austral, 456</a>
            </div>
            <img src="./img/duotone_7.png" alt="">
        </div>
        <div class="contactIMG">
            <div class="contactImgtx">
                <a href="tel:+34678567876" id="tele"><i class="fas fa-info-circle fa-sm"></i>+54 99991111</a>
                <a id="email" href="mailto:micorreo@hotmail.com"><i class="fa fa-envelope"
                        aria-hidden="true"></i>contacto@saludguard.com</a>
            </div>
            <img src="./img/duotone_9.png" alt="">
        </div>
    </div>
</body>
<script src="Script_landp.js"></script>

</html>