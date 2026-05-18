Productos Service - Post Contenido 2
Descripción

Este proyecto corresponde al desarrollo de un microservicio REST utilizando Spring Boot para la gestión de productos. El sistema implementa operaciones CRUD completas y aplica pruebas unitarias, pruebas de integración, cobertura de código con JaCoCo y automatización CI/CD mediante GitHub Actions.

El objetivo principal del laboratorio fue aplicar buenas prácticas de aseguramiento de calidad de software en un entorno Java empresarial utilizando Spring Framework.

Tecnologías Utilizadas
Java 21
Spring Boot 3
Spring Data JPA
Maven
MySQL
H2 Database
JUnit 5
Mockito
MockMvc
JaCoCo
GitHub Actions
Visual Studio Code



El sistema permite:

Crear productos
Consultar productos
Buscar productos por ID
Actualizar productos
Eliminar productos
Endpoints REST
Obtener productos
GET /api/productos
Buscar producto por ID
GET /api/productos/{id}
Crear producto
POST /api/productos

Body JSON:

{
  "nombre": "Laptop",
  "precio": 2500.0,
  "stock": 10
}
Actualizar producto
PUT /api/productos/{id}
Eliminar producto
DELETE /api/productos/{id}
Pruebas Implementadas
Pruebas Unitarias

Se implementaron pruebas unitarias sobre la capa de servicio utilizando:

Mockito
JUnit 5

Validando:

listado de productos
guardado de productos
búsqueda por ID
eliminación
Pruebas de Integración

Se implementaron pruebas JPA utilizando:

@DataJpaTest

Validando:

persistencia
búsqueda
eliminación
asignación automática de ID
Pruebas Web

Se implementaron pruebas web utilizando:

@WebMvcTest

Validando:

respuestas HTTP
endpoints REST
serialización JSON
códigos 200, 201 y 404
Cobertura de Código

El proyecto utiliza JaCoCo para generar reportes de cobertura.

Comando utilizado:

mvn clean verify

Reporte generado en:

target/site/jacoco/index.html
Integración Continua (CI/CD)

Se configuró GitHub Actions mediante:

.github/workflows/ci.yml

El pipeline ejecuta automáticamente:

compilación
pruebas
verificación Maven
generación JaCoCo

en cada push al repositorio.

Ejecución del Proyecto
Compilar proyecto
mvn clean install
Ejecutar aplicación
mvn spring-boot:run

La aplicación inicia en:

http://localhost:8080
Ejecutar pruebas
mvn test
Ejecutar cobertura JaCoCo
mvn clean verify
Resultados Obtenidos

El proyecto finalizó exitosamente con:

BUILD SUCCESS

y:

Failures: 0
Errors: 0
Principios Aplicados

Durante el desarrollo se aplicaron principios relacionados con:

separación de responsabilidades
pruebas automatizadas
integración continua
cobertura de código
arquitectura por capas
mantenibilidad
testing de servicios REST
Evidencias Recomendadas

Se recomienda incluir capturas de:

BUILD SUCCESS
ejecución de pruebas


<img width="1276" height="537" alt="image" src="https://github.com/user-attachments/assets/5cca97f4-9c9d-49b3-a2cf-ec22f7b4cd9f" />
<img width="1268" height="301" alt="image" src="https://github.com/user-attachments/assets/34f051d3-b366-420c-af82-840c2558d8ef" />

reporte JaCoCo
GitHub Actions en verde
estructura del proyecto
pruebas en Postman
