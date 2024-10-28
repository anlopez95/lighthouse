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
java -jar target/light.jar
```

Reemplaza `tu-aplicacion.jar` con el nombre del archivo JAR generado.

## Endpoints de la API

A continuación se detallan algunos de los endpoints disponibles:

- `GET /api/endpoint1`: Descripción del endpoint 1
- `POST /api/endpoint2`: Descripción del endpoint 2
- `PUT /api/endpoint3`: Descripción del endpoint 3
- `DELETE /api/endpoint4`: Descripción del endpoint 4

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz un commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

