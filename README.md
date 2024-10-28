# lighthouse
Technical test 

El proyecto lighthouse corresponde a un programa desarrollado por la resistencia rebelde con la finalidad de triangular la 
posicion de la nave al otro lado del cinturon de asteroides, y asi mismo interceptar los mensajes que desde ella emergen.

## Tabla de Contenidos

- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Prerrequisitos](#prerrequisitos)
- [Instalación](#instalación)
- [Configuración](#configuración)
- [Ejecutar la Aplicación](#ejecutar-la-aplicación)
- [Endpoints de la API](#endpoints-de-la-api)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Características

- Triangulacion de posicion mediante el uso de la funcion trilateracion
- Armado del mensaje con la información obtenida de nuestros 3 satelites

## Tecnologías Utilizadas

- **Java**: Versión 17
- **Spring Boot**: Versión 3.1.4
- **Maven**: Para la gestión de dependencias

## Prerrequisitos

Antes de comenzar, asegúrate de tener lo siguiente instalado:

- [Java JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (versión 17 o superior)
- [Maven](https://maven.apache.org/download.cgi)

## Instalación

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/anlopez95/lighthouse.git
   cd lighthouse
   ```

2. **Construir el proyecto**:

   Para Maven:

   ```bash
   mvn clean install
   ```

## Ejecutar la Aplicación

Ejecuta el siguiente comando para iniciar la aplicación:

```bash
java -jar target/lighthouse.jar
```
No obstante si presenta problemas puede realizar la ejecución de la aplicación desde un IDE (Eclipse/STS) importando el proyecto maven
 y ejecutando la aplicacion en spring

## Endpoints de la API

A continuación se detallan algunos de los endpoints disponibles:


- `POST /topsecret/`: Servicio encargado de obtener el mensaje y posicion de la nave al otro lado de los asteroides
- `POST /topsecret_split/{satellite_name}`: (SIN FINALIZAR) - Servicio encargado de modificar parametros de satelite
- `GET /topsecret_split/details`: (SIN FINALIZAR) - Servicio que opera de manera similar al post de topsecret

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

