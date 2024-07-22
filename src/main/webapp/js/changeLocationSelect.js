// VARIABLES
// Seleccionamos el primer "select" este se encarga de editar el segundo
const selectLocation = document.querySelector("#selectLocation");

// Seleccionado al segundo "select" este va a ser editado por el primero
const selectMunicipios = document.querySelector("#selectMunicipios");

// Le agregamos un evento "change" que se ejecuta cada que el primer select cambia
selectLocation.addEventListener("change", (e) => {

    // Seleccionamos todos los "options" del "select"
    let options = e.target.children;

    for (let i = 0; i < options.length; i++) { //recorremos los options
        if (options[i].selected) { // verificamos si uno de los options esta activado
            locationSave.city = options[i].value
            locationSearch(options[i].id); //Si lo esta llamamos a la funcion "locationSearch" con el id del option seleccionado
            return;
        }
    }
})

//funcion asincronica que consulta una api
async function locationSearch(id, state){

    // consultamos a la api para que traiga los municipio segun el "id" cargado
    let response = await fetch(`https://apis.datos.gob.ar/georef/api/municipios?orden=nombre&provincia=${id}&max=1000`)
    let data = await response.json();

    // Seleccionamos los "municipios" del "data"
    let municipios = await data.municipios;

    resetSelect(); //funcion para borrar todos los options del select

    //Recorremos los municipios
    for (let i = 0; i < municipios.length; i++) {

        if(i == 0 && municipios[0] !== state){
            locationSave.state = municipios[i].nombre;
            saveLocation()
        }

        

        //Creamos una etiqueta del tipo option
        const option = document.createElement("option");
        option.value = municipios[i].nombre; //Agregamos el valor
        option.textContent = municipios[i].nombre; //y el contenido que se muestra

        if(option.value == state){
            option.selected = true;
            locationSave.state = municipios[i].nombre;
            saveLocation()
        }

        selectMunicipios.appendChild(option);
    }

}

function resetSelect(){
    while (selectMunicipios.firstChild) {
        selectMunicipios.removeChild(selectMunicipios.firstChild);
    }
}