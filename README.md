Levantar dockers de sonar con

docker-compose up -d

(si se hace de linux puede que de problema de memoria que se soluciona con este comando)
sysctl -w vm.max_map_count=262144

Ingresar a sonar con pass admin, admin (podría solicitar el cambio)

http://localhost:9000/

Dentro de sonar ir a lo siguiente para desactivar el uso de pass

Administration, Security, Force user authentication desactivar


mvn clean install
mvn sonar:sonar

Obtiene los estilos de música y su porcentaje

http://localhost:8080/polls/

Agrega una nueva encuesta,

http://localhost:8080/polls/poll

body de ejemplo

{
    "email": "manuel.escarate.inf@gmail.com8",
    "kindMusic": "ROCK",
    "createAt": "26-05-1989"
}

En la clase package cl.it.test.testit.components.DataLoader;

Se agregan datos a la BD H2.
