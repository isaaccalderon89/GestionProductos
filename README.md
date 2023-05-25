# Implementación de Microservicios

**Enunciado:** Desarrollar un microservicio para un sistema de gestión de inventario de una tienda. Debe permitir agregar, actualizar, eliminar y obtener productos del inventario, así como realizar consultas por cantidad disponible.

Estoy utilizando *Arquitectura hexagonal*, también conocida como arquitectura de puertos y adaptadores. La principal idea es separar las preocupaciones
y dependencias externas del núcleo de la aplicación.

**¡IMPORTANTE!** El microservicio se ha documentado con JavaDoc para intentar dejarlo lo más claro posible.

El fin de este documento es hacer un pequeño manual de lo que nos devuelve *Postman*.

En proyecto está dividido en los siguientes módulos:
* **Domain**: Tenemos la entidad de negocio con anotaciones de *lombok* para ahorrar código. En este módulo también tenemos el repository que vamos a usar juntos con los casos de uso.
* **Application**: Aquí tenemos la implementación de los casos de uso declarado en la capa *domain*. Tenemos la anotación **@Component** para indicar que es un componente de Spring.
* **Infrastructure**: En este capa tenemos todo lo relacionado con la base de datos. Tenemos una entidad con anotaciones **JPA**, contiene también el repository que extiende de JPA, junto con la clase que lo implementa y las clases necesarias para realizar el mapeo.
* **Boot**: En este módulo tenemos la clase *main* para poder arrancar la aplicación.

***

## Base de datos tipo h2
Para visualizar los datos.

**Pasos:**
1. Arrancar la aplicación.
2. Acceder al siguiente enlace http://localhost:8080/h2-console/
3. Introducir la siguiente ruta jdbc:h2:mem:test, en User Name "root" y en Password "root" y pinchamos *Connect*.

![img.png](img/img.png)

4. Una vez conectados, selecionaremos PRODUCTOS y clickaremos en Run.

![img_1.png](img/img_1.png)

***

## Manual para arrancar la Aplicación

1. Nos dirigimos a módulo **boot**, *src* -> *main* -> *java* -> *com.neoris.peliculas* -> *App*.
   Pulsamos *Run*.

![img_2.png](img/img_2.png)

2. Vamos a *Postman* a comprobar que los métodos.

* Probamos el método *FindAllProductos*.

![img_3.png](img/img_3.png)

* Probamos el método *CreateProduct*.

![img_4.png](img/img_4.png)

* Probamos el método *UpdateProduct*. En este caso vamos a modiciar la cantidad que tenemos del producto que hemos introducido en el punto anterior.

![img_5.png](img/img_5.png)

* Probamos el método *FindByStock*. Este método devuelve una lista de los productos que tiene un stock igual o menor de la cantidad que introducimos. 

![img_6.png](img/img_6.png)

* Probamos el método *Delete*.

![img_7.png](img/img_7.png)

![img_8.png](img/img_8.png)

![img_9.png](img/img_9.png)

***

### Opinión personal sobre como se trabaja con las estructuras hexagonales
![img_10.png](img/img_10.png)

En mi experiencia, trabajar con estructuras hexagonales ha sido beneficioso. Al principio puede resultar complicado debido a la cantidad de clases e interfaces, pero una vez comprendida, se vuelve cómoda de mantener. La separación de responsabilidades y la flexibilidad que proporciona facilita la evolución de la aplicación y la adaptación a nuevos requisitos. En general, las estructuras hexagonales han sido una opción sólida para desarrollar aplicaciones robustas y adaptables.