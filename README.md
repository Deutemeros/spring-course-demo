# Fastmath

Demo application for JavaSpring + React.

The SPA frontend will be packaged with the resulting jar file.

## Build

Créé un executable avec le back et le front

`$> mvn clean install`

## Run

Mettre en place une base de donnée et configurer son acces

- Créer un dossier 'config' à côté de l'executable.
- Créer un fichier 'application.properties' dans ce dossier.
- ```
server.port=9000
spring.datasource.url=jdbc:mysql://<hostname>:<port>/<db_name>
spring.datasource.username=<db_username>
spring.datasource.password=<db_password>
spring.sql.init.mode=always
```
Les tables de la db devraient se créé automatiquement au lancement de l'application.


Lancer l'executable

`$> cd target && java -jar output.jar`
