# spring-boot-crud-example

La aplicación se inicia, con ejecutar un spring-boot:run en el raiz del proyecto
o desde intellijIdea ubicando la clase SpringBoot.java, haciendo click derecho --> Run 

La aplicación posee una base H2 que se genera al iniciar la app,
Pueden ver la ubicación de la misma en el archivo application.properties

`BASE DATOS`

La consola de la base de datos H2 se puede visualizar en
http://localhost:8080/api/v1/h2 

JDBC URL : jdbc:h2:~/prueba_testdb
usuario : root
password : root 

*Ver application.properties por las credenciales de la consola*

`DOCUMENTACIÓN` 

En el directorio /resources/Documentación posee en Json con los casos de usos 
desarrollados, para importar en `POSTMAN`

`Create Participante`
Alimenta la base de datos de whatsapp con todos los telefonos
que poseen instalado whatsapp

`GetAll Participante` 
Obtiene la lista de participantes que estan disponibles para enviar whatsapp
(aca partimos que esto es un sistema interno y que los participantes son contactos,
sino deberiamos partir esto y dejar esta logica del lado del front end)

`Create Grupo Whatsapp` 
Crea el grupo de whatsapp a partir de un nombre ficticio y una lista de participantes


`Send Message`
Es el End-point final, que necesita el mensaje y el participante dueño del mensaje
y a que grupo desea enviarlo, terminan insertando en la tabla notifiación cada mensaje a cada
participante del grupo


Por otro lado en la carpeta Documentación poseen el DER y UML 

Toda la api esta documentada con `Swagger` en la suguiente URL 

http://localhost:8080/api/v1/swagger-ui.html


















