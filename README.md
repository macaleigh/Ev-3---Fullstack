**Integrantes:**

Macarena Leighton





**QuickOrder360 - Arquitectura de Microservicios**



**Descripción:**

QuickOrder360 es un sistema de gestión de pedidos online desarrollado bajo una arquitectura de microservicios. El proyecto fue construido utilizando Spring Boot, JPA/Hibernate y MySQL, permitiendo una estructura modular, escalable y fácil de mantener. Cada microservicio cumple una función específica dentro del sistema, facilitando la organización y la comunicación entre los distintos módulos.





**Microservicios:**



**Microservicio**	    **Puerto**	**Función**

ms-clientes	    8081	Administración de clientes

ms-productos	    8082	Gestión de productos

ms-inventario	    8083	Control de stock e inventario

ms-pedidos	    8084	Registro y administración de pedidos

ms-detalle-pedido   8085	Gestión del detalle de cada pedido

ms-pagos	    8086	Procesamiento y control de pagos

ms-despachos	    8087	Administración de envíos y despachos

ms-usuarios	    8088	Gestión de usuarios y accesos

ms-reclamos	    8089	Registro y seguimiento de reclamos

ms-notificaciones   8090	Envío de notificaciones del sistema





**Programas utilizados:**

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL 8
* Laragon
* IntelliJ IDEA
* Postman





**Instrucciones de ejecución:**

* Iniciar Laragon y verificar que MySQL esté activo.
* Crear las bases de datos necesarias en HeidiSQL.
* Abrir cada microservicio en IntelliJ IDEA.
* Configurar la conexión a MySQL en el archivo application.properties.
* Ejecutar cada microservicio en su puerto correspondiente.
* Probar los endpoints utilizando Postman.





**Endpoints principales:**



**Clientes**



* GET /api/v1/clientes
* POST /api/v1/clientes



**Productos**



* GET /api/v1/productos



**Pedidos**



* GET /api/v1/pedidos
* POST /api/v1/pedidos





**Objetivo del proyecto:**

* El objetivo de QuickOrder360 es representar el funcionamiento de una plataforma de pedidos online utilizando una arquitectura basada en microservicios. Gracias a esta estructura, cada módulo funciona de manera independiente, facilitando la escalabilidad, el mantenimiento y la organización del sistema.

