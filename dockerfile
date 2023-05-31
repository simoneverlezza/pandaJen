FROM openjdk:20
EXPOSE 8080
ADD target/codeGenerator-0.0.1-SNAPSHOT.jar codeGenerator-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/codeGenerator-0.0.1-SNAPSHOT.jar"]
