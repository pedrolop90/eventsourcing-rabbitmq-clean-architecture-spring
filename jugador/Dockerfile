FROM openjdk:11-jdk-alpine
LABEL Pedro Jose Lopez Suarez <pedrolop90@gmail.com>
RUN mkdir /app
COPY ./target/jugador-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
CMD ["java","-jar","app.jar"]