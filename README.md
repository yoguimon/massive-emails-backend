# PROYECTO EMAIL MASIVOS #

## Descripción ##
Este proyecto es una aplicación web para la gestión y envío de correos masivos. Permite crear mensajes, seleccionar destinatarios y realizar un seguimiento de los correos enviados. Está desarrollado con una arquitectura backend en Java utilizando Spring Boot y un frontend en Vue.js. 

Características Principales 
* Gestión de Mensajes: Crear y visualizar mensajes. 
* Selección de Destinatarios: Importar destinatarios desde un archivo, seleccionar de una base de datos o enviar a todos los contactos. 
* Dashboard: Información resumida sobre los mensajes y destinatarios. 

## Tecnologías Utilizadas ##

Backend 
* Java 17 
* Spring Boot 
* Hibernate (JPA) 
* MySQL 

Frontend 
* Vue.js 3 
* Bootstrap 5 

Otras Herramientas 
* Axios para las solicitudes HTTP. 
* SweetAlert2 para notificaciones. 
* Docker para el despliegue. 

## Estructura del Proyecto ##

Backend 
El backend está estructurado siguiendo principios de arquitectura RESTful y diseño SOLID. 
* Controladores: Manejan las solicitudes HTTP. 
* Servicios: Contienen la lógica de negocio. 
* Repositorios: Interactúan con la base de datos. 

Frontend 
El frontend está dividido en componentes reutilizables: 
* SidebarComponent: Navegación lateral. 
* HeaderComponent: Encabezado principal. 
* ContentComponent: Área principal para el contenido dinámico. 

## Configuración ## 

Requisitos Previos 
* JDK 17 
* Node.js y npm 
* MySQL 
* Docker (opcional)

## Instalación ##

Backend
1. Clona el repositorio
git clone https://github.com/yoguimon/massive-emails-backend
cd massive-emails-backend
2. Configura el archivo application.properties con los detalles de tu base de datos.
Diagrama relacional:
![dr emails](https://github.com/user-attachments/assets/298803b2-18b3-4935-99a8-5f8a5961056d)
4. Ejecuta el proyecto
./mvnw spring-boot:run

Frontent
1. Clona el repositorio
git clone https://github.com/yoguimon/massive-emails-frontend
cd massive-emails-frontend
2. npm install
3. npm run dev

## Uso ##
1.  Accede a la aplicación en el navegador: http://localhost:8080.
2. Crea un mensaje y selecciona los destinatarios.
3. Envía el mensaje y visualiza el estado en el dashboard.

## API Endpoints ##
Mensajes
* POST /api/emails/send : Enviar mensaje a destinatarios
![send email](https://github.com/user-attachments/assets/73c72438-a3a0-4cfa-8f57-139b4f73a990)
* GET /api/emails/dashboard : Obtener mensajes envios e informacion necesaria.
![dashboard](https://github.com/user-attachments/assets/24aad3c6-185d-4370-93ca-844c0364850c)

Crud contactos
* GET /api/contacts

![contacts](https://github.com/user-attachments/assets/484f26b7-09c0-49a8-89e4-c4403f9ffaea)

* POST /api/contacts
* PUT /api/contacts/{id}
* DELETE /api/contacts/{id}
