# TENPO-CHALLENGE


## CREAR IMAGENES DEL SERVICIO DE LA BASE DE DATOS POSTGRES Y DEL ADMIN ADMINER
### Ubicarse donde se encuentran los archivos del poryecto(DockerFile, docker-compose)
### ejecutar el siguiente comando para crear las imagenes de los servicios
### docker-compose pull
### verificar que las imágenes se han creado
## EJECUTAR LOS CONTENEDORES
### docker-compose up -d
##PROBAR EL SERVICIO
   
##jwt
### crear un usuario
http://localhost:8080/auth/signup
{
    "userName": "rosa",
    "password": "12345678",
    "email": "rosa@gmail.com",
    "name": "rosa"
}

###LOGIN USUARIO

localhost:8080/auth/signin

{"userName":"pedro",
"password":"12345678"}

###COPIAR EL TOKEN Y COLOCAR EN EL BEARER PARA PEGARLE A OTROS ENDPOINT

##ENDPOINT CALCULA PERCENTAJE
http://localhost:8080/api/v1/percentage?num1=2&num2=3

##ENDPOINT DEVUELVE HISTORIAL DE LLAMADOS A LOS SERVICIOS
http://localhost:8080/api/V1/history?numpagina=1&size=5


##EL SERVICIO TIENE IMPLEMENTADO EL CIRCUIT BREAK 
