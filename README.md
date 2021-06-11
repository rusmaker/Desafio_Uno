### Desafío 1: Periodos perdidos
#### Nivel 3

Este proyecto expone un API REST que entrega la siguiente información:

- id: identificador
- fechaCreacion: Fecha de inicio de la secuencia
- fechaFin: Fecha de fin de la secuencia
- fechas: Lista de fechas que están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin”
- fechasFaltantes: Lista de fechas que no están en el rango de la fecha que se encuentra en “fechaCreacion” hasta la fecha “fechaFin” 

Ejemplo.
```json
{
    "id": 6,
    "fechaCreacion": "1969-03-01",
    "fechaFin": "1970-01-01",
    "fechas": [
      "1969-03-01",
      "1969-05-01",
      "1969-09-01",
      "1970-01-01"],
    "fechasFaltantes": [
      "1969-04-01",
      "1969-06-01",
      "1969-07-01",
      "1969-08-01",
      "1969-10-01",
      "1969-11-01",
      "1969-12-01"]
}
```

Nota: Este servicio consume al servicio REST llamado Generador De Datos o GDD, por tanto debe estar ejecutándose. Una versión del GDD se encuentra en el repositorio  GitHub: https://github.com/previred/Generador_Datos_Desafio_Uno

### Detalle de los sistemas
- Swagger 2.6.1 
- Java 8 Spring-Boot 2.4.6
- Maven 3

### Compilar y ejecutar el proyecto
Para compilar el proyecto se requiere Java y Maven instalado. Ingresar al directorio 'Desafio_Uno' ejecutar el siguiente comando maven

mvn package

Luego de compilar el proyecto ingresar al directorio target ejecutar el siguiente comando java

java -jar periodosperdidos-0.0.1.jar

Nota: Debe estar disponible el puerto 8081 en el PC donde se ejecute esta API

### Visualizar Documentación y consumir la API
La documentación swagger del API (una vez que se levanta el API) queda disponible en

http://localhost:8081/swagger-ui.html#!/

Para consumir el servicio se debe invocar la siguiente URL

http://localhost:8081/periodos/faltantes
