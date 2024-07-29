document.addEventListener('DOMContentLoaded', function () {
    const dropdownButton = document.querySelector('.dropdown-button');
    const dropdownContent = document.querySelector('.dropdown-content');

    dropdownButton.addEventListener('click', function () {
        dropdownContent.style.display = dropdownContent.style.display === 'block' ? 'none' : 'block';
    });

    // Cerrar el menú si se hace clic fuera de él
    window.addEventListener('click', function (event) {
        if (!event.target.matches('.dropdown-button')) {
            if (dropdownContent.style.display === 'block') {
                dropdownContent.style.display = 'none';
            }
        }
    });

    document.addEventListener('click', (e) => {
        //verifica que el lugar en donde se dio click tenga la clase "Faq"
        if (e.target.classList.contains("Faq")) {

            //Seleccionamos todos las etiquetas que tengan la clase "Faq"
            const consultas = document.querySelectorAll(".Faq");

            //Reccorremos todas las consultas
            for (let i = 0; i < consultas.length; i++) {
                //preguntamos si tienen la clase "FaqSeleccted"
                if (consultas[i].classList.contains("FaqSeleccted")) {
                    consultas[i].classList.remove("FaqSeleccted");//Si la tiene que se la quite
                }
            }

            //verifica que el lugar en donde se dio click tenga la clase "colorBlanco"
            if (e.target.classList.contains("FaqSeleccted")) {
                e.target.classList.remove("FaqSeleccted"); //Si lo tiene lo elimina
            } else {
                e.target.classList.add("FaqSeleccted"); //Si no lo tiene lo agrega
            }

        }

    })
});
document.addEventListener('click', (e) => {
    if (e.target.classList.contains("Faq")) {
        const miDiv = document.getElementById('answerBox');
        const textoSeleccionado = e.target.textContent;

        const contenidos = {
            '¿EI servicio tiene algún costo?': 'SaludGuard no tiene ningún costo de apertura, mantenimiento o cargos extra. Nuestra misión es la deacercar la inclusión tecnológica en salud a la mayor cantidad de personas a lo largo y a lo ancho de la Argentina.',
'¿Funciona las 24 horas?': 'Tu historial clínico está siempre disponible para vos. 24/7. No más esperar a tener acceso a tu historia clínica en papel.  ',
            '¿Qué funciones posee?': 'Con SaludGuard, podés visualizar tu historia clínica en un panel centralizado, tus tratamientos, antecedentes y estado físico, todo en un mismo lugar. Toda la información que los médicos carguen sobre tu estado físico, estarán en SaludGuard desde donde quieras acceder.',
            '¿En que areas funciona?': 'El servicio actualmente se encuentra en despliegue en centros de salud designados en la Provincia de Buenos Aires y CABA. En una próxima etapa se extenderá a todas las provincias de Argentina.'
        };

        miDiv.textContent = '';
        const parrafo = document.createElement('p');
        parrafo.classList.add('texto-estilizado');
        parrafo.textContent = contenidos[textoSeleccionado] || textoSeleccionado;
        miDiv.appendChild(parrafo);

        miDiv.classList.remove("oculto");
    }
})


let scrollCounter = 0;

window.addEventListener('scroll', function () {
    scrollCounter += Math.abs(window.scrollY - scrollCounter);

    if (scrollCounter > 650) { // Ajusta el valor según lo que necesites
        var nav = document.querySelector('nav');
        nav.classList.toggle('abajo', window.scrollY > 10);
    }

    if (window.scrollY === 0) {
        scrollCounter = 0;
    }
});

window.addEventListener('scroll', function () {
    var box1 = document.querySelector('#box1');
    box1.classList.toggle('logoscroll', window.scrollY > 0);
});

const numElement = document.querySelector('.num');

// Cambia el valor de --num y desencadena la transición
function animateNum() {
    numElement.style.setProperty('--num', '3600');
}

// Llama a la función animateNum después de cierto tiempo
setTimeout(animateNum, 2000); // Ajusta el tiempo según tus necesidades
const num2Element = document.querySelector('.num2');

// Cambia el valor de --num y desencadena la transición
function animateNum2() {
    num2Element.style.setProperty('--num', '6000');
}

// Llama a la función animateNum2 después de cierto tiempo
setTimeout(animateNum2, 2000); // Ajusta el tiempo según tus necesidades

// Selecciona el elemento que deseas animar
const animacionElement = document.querySelector('#nav',);

// Crea una instancia de la Intersection Observer API
const observer = new IntersectionObserver((entries) => {
    // Verifica si el elemento intersecta con la ventana de visualización
    entries.forEach((entry) => {
        if (entry.isIntersecting) {
            // Aplica las animaciones deseadas al elemento
            animacionElement.classList.add('animacion-activa');
        } else {
            // Restaura el estado original del elemento
            animacionElement.classList.remove('animacion-activa');
        }
    });
});

// Configura la observación del elemento
observer.observe(animacionElement);



const animacionElement2 = document.querySelector('#mainlogo',);

// Crea una instancia de la Intersection Observer API
const observer2 = new IntersectionObserver((entries) => {
    // Verifica si el elemento intersecta con la ventana de visualización
    entries.forEach((entry) => {
        if (entry.isIntersecting) {
            // Aplica las animaciones deseadas al elemento
            animacionElement2.classList.add('animacion-mainlogo');
        } else {
            // Restaura el estado original del elemento
            animacionElement2.classList.remove('animacion-mainlogo');
        }
    });
});

// Configura la observación del elemento
observer2.observe(animacionElement2);



// Selecciona todos los elementos con la clase "animacicion-str"
const animacionElement3 = document.querySelectorAll('.animacicion-str');

// Crea una instancia de la Intersection Observer API
const observer3 = new IntersectionObserver((entries) => {
    // Verifica si el elemento intersecta con la ventana de visualización
    entries.forEach((entry) => {
        if (entry.isIntersecting) {
            // Aplica las animaciones deseadas al elemento
            entry.target.classList.add('animacion-strong');
        } else {
            // Restaura el estado original del elemento
            entry.target.classList.remove('animacion-strong');
        }
    });
});

// Configura la observación de cada elemento con la clase "animacicion-str"
animacionElement3.forEach((element) => {
    observer3.observe(element);
});

// Selecciona todos los elementos con la clase "animacion-about"
const animacionElement4 = document.querySelectorAll('.view');

// Crea una instancia de la Intersection Observer API
const observer4 = new IntersectionObserver((entries) => {
    // Verifica si el elemento intersecta con la ventana de visualización
    entries.forEach((entry) => {
        if (entry.isIntersecting) {
            // Aplica las animaciones deseadas al elemento
            entry.target.classList.add('animacion-about');
        } else {
            // Restaura el estado original del elemento
            entry.target.classList.remove('animacion-about');
        }
    });
});

// Configura la observación de cada elemento con la clase "animacion-about"
animacionElement4.forEach((element) => {
    observer4.observe(element);
});


// Selecciona todos los elementos con la clase "animacion-impc"
const animacionElement5 = document.querySelectorAll('.NumerosImpc');

// Crea una instancia de la Intersection Observer API
const observer5 = new IntersectionObserver((entries) => {
    // Verifica si el elemento intersecta con la ventana de visualización
    entries.forEach((entry) => {
        if (entry.isIntersecting) {
            // Aplica las animaciones deseadas al elemento
            entry.target.classList.add('animacion-impc');
        } else {
            // Restaura el estado original del elemento
            entry.target.classList.remove('animacion-impc');
        }
    });
});

// Configura la observación de cada elemento con la clase "animacion-impc"
animacionElement5.forEach((element) => {
    observer5.observe(element);
});

const animacionElement6 = document.querySelectorAll('.txt-animacion');

// Crea una instancia de la Intersection Observer API
const observer6 = new IntersectionObserver((entries) => {
    // Verifica si el elemento intersecta con la ventana de visualización
    entries.forEach((entry) => {
        if (entry.isIntersecting) {
            // Aplica las animaciones deseadas al elemento
            entry.target.classList.add('animacion-txt');
        } else {
            // Restaura el estado original del elemento
            entry.target.classList.remove('animacion-txt');
        }
    });
});

// Configura la observación de cada elemento con la clase "animacion-impc"
animacionElement6.forEach((element) => {
    observer6.observe(element);
});