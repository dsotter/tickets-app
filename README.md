# Ticket Management API | Double V Partnes

Prueba técnica Desarrollador Java Backend

## Descripción del proyecto
El Ticket Management API es un servicio RESTful desarrollado con Spring Boot y Java que permite la gestión de tickets con operaciones para crear, eliminar, editar y recuperar tickets con paginación. Además, se puede recuperar una lista de todos los tickets o filtrar por uno específico. Cada ticket está compuesto por un id único, el nombre del usuario, la fecha de creación, la fecha de actualización y el estado del ticket (abierto/cerrado).

## Requisitos del Sistema
- Java 8.
- Spring Boot 2.7.14
- Docker
- Postman

## Instalación y Uso

Para utilizar las API en tu entorno local, sigue los siguientes pasos:

1. Clona este repositorio en tu máquina local usando el comando: `git clone https://github.com/dsotter/tickets-app.git`
2. Accede a la carpeta donde clones el proyecto.
3. Asegúrate de estar en la rama `develop`. Si no estás en esa rama, puedes cambiar a ella utilizando el comando: `git checkout develop`
4. Una vez en la rama `develop`, tendrás el código fuente del proyecto en su última versión disponible. Ahora puedes trabajar con el código, realizar cambios, probar nuevas funcionalidades o simplemente explorar el código del proyecto.

## Instalación de Postman
1. Dirígete al sitio web oficial de Postman en [https://www.postman.com/](https://www.postman.com/) y descarga la versión adecuada para tu sistema operativo.
2. Una vez descargado, procede a instalar Postman siguiendo las instrucciones proporcionadas para tu sistema operativo.
3. Después de la instalación, abre Postman desde el menú de aplicaciones o buscándolo en el escritorio.

## Importar Colección
1. Descarga el archivo de colección desde la carpeta `Utilities` del proyecto que clonaste.
2. En Postman, haz clic en el botón "Importar" ubicado en la esquina superior izquierda de la interfaz.
3. Selecciona la opción "Subir archivos" y busca el archivo de colección descargado previamente.
4. Haz clic en el botón "Importar" para cargar la colección en Postman.

## Definir Variable `localhost:8080`
1. Una vez que la colección se haya importado correctamente, haz clic en el ícono de "Variables" en la parte superior derecha de la interfaz de Postman.
2. En la ventana emergente "Administrar variables", haz clic en el botón "Agregar" para crear una nueva variable.
3. Define el nombre de la variable como `local` y el valor como `localhost:8080`.
4. Asegúrate de marcar la casilla "Guardar en" y selecciona la opción "Colección" para que la variable se aplique solo a esta colección específica.
5. Haz clic en el botón "Guardar" para guardar la variable.

## Uso de la Colección
1. Con la colección importada y la variable `local:8080` definida, ahora puedes utilizar los endpoints de la API.
2. Abre la colección en el panel izquierdo y selecciona una de las solicitudes disponibles.
3. En cada solicitud, verifica que la URL incluya la variable `{{local}}` en lugar de la dirección IP o el nombre del dominio.
4. Cuando realices una solicitud, Postman utilizará automáticamente el valor definido para la variable `local` (es decir, `localhost:8080`) como parte de la URL.
5. Ahora puedes utilizar Postman para probar los endpoints de la API en tu proyecto, utilizando la colección importada y la variable `local:8080` para acceder a la aplicación localmente.

## Conexión a base de datos
El proyecto utiliza Docker y docker-compose para gestionar los servicios y la base de datos de forma aislada y sencilla. Para conectar a la base de datos, sigue los siguientes pasos:
1. Asegúrate de tener Docker instalado en tu sistema.
2. Abre una terminal o línea de comandos en la raíz del proyecto donde se encuentra el archivo `docker-compose.yml`.
3. Ejecuta el siguiente comando para levantar los servicios y la base de datos en modo "detached" (en segundo plano): `docker-compose up -d`
   Esto iniciará los contenedores definidos en el archivo `docker-compose.yml`, incluyendo la base de datos y cualquier otro servicio necesario para el proyecto.

## Modelo de datos
El modelo de datos utilizado para representar un ticket consta de los siguientes campos:
- Id: Identificador único del ticket.
- Usuario: Nombre del usuario que crea o actualiza el ticket.
- Fecha creación: Fecha y hora de creación del ticket.
- Fecha actualización: Fecha y hora de la última actualización del ticket.
- Estatus: Estado del ticket, que puede ser "abierto" o "cerrado".

## EndPoints

La API ofrece los siguientes endpoints para interactuar con los tickets:

- POST /api/tickets: Crea un nuevo ticket con la información proporcionada.
- DELETE /api/tickets/{id}: Elimina el ticket con el ID especificado.
- PUT /api/tickets/{id}: Actualiza la información de un ticket existente mediante su ID.
- GET /api/tickets/{id}: Recupera un ticket específico por su ID.
- GET /api/tickets: Recupera todos los tickets disponibles de forma paginada.
- GET /api/tickets?estatus={estado}: Recupera todos los tickets con el estado especificado.

## Contacto y anotaciones
Para cualquier duda o comentario relacionado con este proyecto, pueden contactarme a través de diegosotter@hotmail.com. ¡Agradezco tus sugerencias y comentarios para mejorar!
