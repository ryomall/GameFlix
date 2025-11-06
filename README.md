build and run container
1. Need to create a maven build with this command Mvn clean install
2. then you'll see a target folder with the .jar file created inside it.k
3. then you createa a docker file  from right clicking the gameflix main file
4. then run the docker build command: 
docker build -t gameflix-backend .
 Run the container
docker run -p 8080:8080 gameflix-backend   # adjust port if necessary


