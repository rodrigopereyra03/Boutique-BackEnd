# Documentación Boutique Automotor REST API
API Rest para operaciones CRUD sobre servicios.

## Tecnologias:
- **Lenguaje Java**
- **Framework : Spring Boot**
- **Base de datos : MySQL y H2.**
- Se desarrollo usando MySQL pero tambien se configuro H2 ya que es una base de datos en memoria
  y facilita las pruebas, con solo ejecutar el proyecto ya se puede consumir los endpoints.
- En el caso de querer utilizar MySQL hay que modificar el application.properties con los datos de conexion.
- Documentacion REST API: se implemento Swagger, se puede acceder mediante la url: http://localhost:8080/swagger-ui.html despues de levantar el proyecto
- Para los Test se utilizo JUnit con Mockito.
- Documentacion de Postman para importar Automotor.postman_collections.json