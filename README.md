# SaludGuard

SaludGuard es una aplicación de gestión de historias clínicas diseñada para facilitar la administración de datos médicos de pacientes y doctores. Este proyecto está desarrollado con Java Spring Boot, utilizando Maven como herramienta de construcción y JPA para la persistencia de datos.

## Tabla de Contenidos

- [Descripción](#descripción)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Ejecución](#ejecución)
- [Uso](#uso)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## Descripción

Este proyecto tiene como objetivo crear un sistema robusto para la gestión de historias clínicas, permitiendo a los doctores y pacientes acceder a la información médica de manera eficiente. La aplicación incluye funcionalidades como la creación, edición y visualización de perfiles médicos, así como la gestión de aspectos del historial clínico.

## Requisitos

- Java 17 (o superior)
- Maven 3.6.0 (o superior)
- MySQL 8 (o superior) o cualquier otra base de datos compatible con JPA

## Instalación

1. Cloná el repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tuusuario/SaludGuard.git

2. Navegá al directorio del proyecto:
   ```bash
   cd SaludGuard

3. Instalá las dependencias utilizando Maven:
    ```bash
    mvn clean install
## Configuración
Configurá la base de datos en el archivo 

src/main/resources/application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/saludguard
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña
    spring.jpa.hibernate.ddl-auto=update

Si querés usar otro perfil (por ejemplo, desarrollo), podés configurar application-dev.properties de manera similar.

## Ejecución

Para ejecutar la aplicación con el perfil de producción (prod):

    mvn spring-boot:run -Dspring-boot.run.profiles=prod

Para ejecutar la aplicación con el perfil de desarrollo (dev):

    mvn spring-boot:run -Dspring-boot.run.profiles=dev

## Uso
Una vez que la aplicación esté en ejecución, podés acceder a ella desde tu navegador en http://localhost:8080/home

