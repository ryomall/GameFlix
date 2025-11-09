# GameFlix
GameFlix is a subscription-based platform where users pay a monthly fee to play the games on the platform and read and write reviews of the games.

## Technologies Used
-	Java / Spring Boot 
-	Maven
-	MySQL 
-	Docker

## Instructions to Build and Run the Container
1.	Create a Maven build. 
```
mvn clean install
```
   Target folder will now have .jar file created inside it.

2. Create a Dockerfile in the root of your backend project.
```
FROM openjdk:17-jdk-slim
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```
3.	 Build the Docker image.
```
docker build -t gameflix-backend .
```
4.	Run the Docker container.
```
docker run -p 8081:8080 gameflix-backend
```   
   Adjust port if necessary.



