//SELECTORES

const formLocation = document.querySelector("#formLocation");



// primer input de direccion
const direccion = document.querySelector("#address");

// segundo input de direccion
const direccion2 = document.querySelector("#address2");

// primer select de provincias
// selectLocation --- No hace falta crear una variable porque ya estan en el otro js
// segundo select de municipios
// selectMunicipios

// input de localidad
const localidad = document.querySelector("#town");

// input del codigo postal
const codigoPostal = document.querySelector("#postalCode");

//input hidden para obtener el id del usuario solo serviria para verificacion
const user = document.querySelector("#user");

//variable para el boton de enviar
const submit = document.querySelector("#enviar");

//creamos una variable de tipo objeto para guardar la info de location
let locationSave = {
    address: "",
    address2: "",
    city: "",
    state: "",
    town: "",
    postalCode: ""
};

//EVENTOS

document.addEventListener("DOMContentLoaded", () => {


    locationGet = JSON.parse(localStorage.getItem(`location${user.value}`));
    console.log(locationGet);

    if (locationGet !== null) {
        locationSave = JSON.parse(localStorage.getItem(`location${user.value}`))

        direccion.value = locationGet.address;
        direccion2.value = locationGet.address2;
        selectLocation.value = locationGet.city;
        selectMunicipios.value = locationGet.state;
        localidad.value = locationGet.town;
        codigoPostal.value = locationGet.postalCode;
    }


    locationSave.city =  selectLocation.value;

    let options = selectLocation.children;
    for (let i = 0; i < options.length; i++) {
        if (locationGet !== null && options[i].value == locationGet.city) {
            locationSearch(options[i].id, locationGet.state);
        }
        if(i == options.length - 1){
            locationSearch(2);
        }
    }
})

//evento para cuando cambie la direccion
direccion.addEventListener("keyup", (e) => {
    locationSave.address = e.target.value; //guarda el valor del input en la variable locationSave
    saveLocation();
}) //Basicamente todos los eventos van a hacer lo mismo

direccion2.addEventListener("keyup", (e) => {
    locationSave.address2 = e.target.value;
    saveLocation();
})


selectLocation.addEventListener("change", (e) => {
    locationSave.city = e.target.value;
    saveLocation();
})

selectMunicipios.addEventListener("change", (e) => {
    locationSave.state = e.target.value;
    saveLocation();
})

localidad.addEventListener("keyup", (e) => {
    locationSave.town = e.target.value;
    saveLocation();
})

codigoPostal.addEventListener("keyup", (e) => {
    locationSave.postalCode = e.target.value;
    saveLocation();
})

submit.addEventListener("click", () => {

    const {address, address2, city, state, town,postalCode} = locationSave

    if(address != "" && address2 != "" && city != "" && state != "" && town != "" && postalCode != ""){
        localStorage.removeItem(`location${user.value}`);
    }
})

//FUNCIONES
function saveLocation() {
    localStorage.setItem(`location${user.value}`, JSON.stringify(locationSave));
}