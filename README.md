# TENPO-CHALLENGE
## ejecutar el servicio el cual va a ser invocado cada media hora, pero para pruebas va a ser invocado cada 10 segundos
# GENERAR IMAGEN DOCKER:
##  docker build -t  number-random --no-cache --build-arg JAR_FILE=target/*.jar .
# LEVANTAR CONTENEDOR DOCKER
## docker run -p 8081:8080 --name number-random number-random

## El servicio queda disponible en el puerto 8081 para ser invocado mediante feing por el servicio challenger-tenpo

### Este servicio solo devuelve un número random

