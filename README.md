PROYECTO EMAIL MASIVOS

# Descripción #
Este proyecto es una aplicación web para la gestión y envío de correos masivos. Permite crear mensajes, seleccionar destinatarios y realizar un seguimiento de los correos enviados. Está desarrollado con una arquitectura backend en Java utilizando Spring Boot y un frontend en Vue.js. 

Características Principales 
* Gestión de Mensajes: Crear, editar y visualizar mensajes. 
* Selección de Destinatarios: Importar destinatarios desde un archivo, seleccionar de una base de datos o enviar a todos los contactos. 
* Seguimiento de Correos: Visualizar el estado de los correos enviados. 
* Dashboard: Información resumida sobre los mensajes y destinatarios. 

# Tecnologías Utilizadas #

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

# Estructura del Proyecto #

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

# Configuración # 

Requisitos Previos 
* JDK 17 
* Node.js y npm 
* MySQL 
* Docker (opcional)

# Instalación #
