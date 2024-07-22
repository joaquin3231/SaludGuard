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

const divClickeable = document.getElementById('miDiv');

        // Agrega un evento de clic al div
        divClickeable.addEventListener('click', () => {
            // Crea un nuevo elemento de párrafo
            const nuevoParrafo = document.createElement('p');
            nuevoParrafo.textContent = '¡Texto agregado al hacer clic!';

            // Inserta el párrafo en el cuerpo del documento
            document.body.appendChild(nuevoParrafo);
        });