# Proyecto para gestión de activos.

## Ejecución local sin contenedores.
Para correr en local sin necesidad de docker, solo se debe ejecutar el proyecto y probar con cualquier
herramienta como Postman, Insomnia, Katalon, etc; y valerse de la documentación
generada con Swagger, para construir consultas, e incluso hacerlo desde el mismo Swagger.

----------------
## Ejecución local con contenedores.
Para ejecución contenerizada, se debe tener configurado docker y kubernetes en la máquina. 
Posteriormente, se deben ejecutar los siguientes comandos en la raíz del proyecto:
*     kubectl apply -f deployment.yaml
    Se utiliza para crear el deployment y el pod del proyecto. Ejecuta lo especificado en el deployment.yaml
*     kubectl get deployment
    Se usa para verificar si ya se ha hecho correctamente el deployment y para verificar las instancias definidas.
*     kubectl get pods
    Con esto se verifica que el pod se haya creado correctamente.
*     kubectl apply -f service.yaml
    Una vez creado el pod, se procede a crear el servicio que permitirá acceder a la aplicación por fuera del clúster 
    de Kubernetes, mediante la url _localhost_ y el puerto _8080_
*     kubectl get services
    Por último, se verifica que el servicio haya quedado creado correctamente.

Posteriormente a todo esto, podemos acceder a la aplicación y sus endpoints, al igual que la manera establecida por
Swagger, mediante la ruta:
+       localhost:8080
  
