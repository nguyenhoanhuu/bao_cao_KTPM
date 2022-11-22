FROM openjdk:11.0.16
WORKDIR /Flight-deploy
COPY ./target/productService-0.0.1-SNAPSHOT.jar /Flight-deploy
COPY . /Flight-deploy
EXPOSE 8080
CMD ["java","-jar","productService-0.0.1-SNAPSHOT.jar"]