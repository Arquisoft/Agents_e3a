[![Codacy Badge](https://api.codacy.com/project/badge/Grade/6f1eae5c3b7749a3ba299ae6c548e3a9)](https://www.codacy.com/app/jelabra/Agents_e3a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/Agents_e3a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/Agents_e3a.svg?branch=master)](https://travis-ci.org/Arquisoft/Agents_e3a)
[![codecov](https://codecov.io/gh/Arquisoft/Agents_e3a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/Agents_e3a)


# Agents e3a

Agents

# Authors

- Herminio García González (@herminiogg)
- Jose Emilio Labra Gayo (@labra)
- Sergio Flórez Vallina (@zerolfer)
- Rubén García Ruiz (@RubenGarciaR)
- Sonia Gestal Huelga (@sonia94)
- Luis Irazusta Lorenzo (@Fuegon)
_____________________________________________
- Saúl Castillo Valdés (@saulcasti)
- Pelayo Díaz Soto (@PelayoDiaz)
- Amelia Fernández Braña (@ameliafb)
- Francisco Javier Riedemann Wistuba (@FJss23)

# Funcionamiento:
## Ejecución del código
1. Para el código utilizar la orden: mvn compile
2. Para ejecutarlo utilizamos: mvn spring-boot:run
3. Para comprobar el funcionamiento de los test: mvn test

## Interfaz HTML
1. Escribir en el navegador: http://localhost:8080/
2. Proporcionar los datos de login para los usuarios disponibles:
 * Login: juan, pedro, raul
 * Password: 1234
3. Aparecerá la pantalla que muestra los datos del usuario
 * Se puede modificar el email (se comprueba si el email es valido)
 * Se puede ir a la pantalla de cambio de contraseña
4. Cambio de contraseña:
 * Escribir la contreseña antigua
 * Escribir la nueva contraseña

## Servicio REST
   El punto de entrada se encuentra en http://localhost:8080/user.
   
   Acepta peticiones POST en formato JSON con el contenido:
   ``{"login":"usuario", "password":"password", "kind": tipo de agente}``
   (Se puede probar en el Advanced REST Client de Google)
   
   Devuelve la informacion del usuario si las credenciales en formato 
   JSON o XML segun se indique en la cabecera de la petición.
   
   Si los datos no son correctos se devuelve un error HTTP 404.
   Si los parametros no son correctos se devuelve un codigo de error HTTP 406.
   
   
### Formato de retorn JSON
   ```json
   {
     "firstName": "nombre",
     "lastName": "apellidos",
     "edad": edad(int),
     "id": id_usuario(long),
     "email": "email",
     "address": "direccion",
     "nationality": "nacionalidad"
   }
   ```
### Formato retorno XML
   ```xml
   <CitizenMin>
       <firstName>nombre</firstName>
       <lastName>apellidos</lastName>
       <edad>edad</edad>
       <id>id_usuario</id>
       <email>email</email>
       <address>direccion</address>
       <nationality>nacionalidad</nationality>
   </CitizenMin>
   ```
   


