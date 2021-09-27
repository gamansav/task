FROM maven:3.6.0-jdk-11-slim AS build

COPY pom.xml /home/app/pom.xml

RUN mvn -f /home/app/pom.xml dependency:resolve

COPY . /home/app

RUN mvn -f /home/app/pom.xml clean install -Dmaven.test.skip=true

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /home/app/target/xml-validator-servie-0.1.jar /app/xml-validator-service.jar

EXPOSE 8080

CMD ["java","-jar","/app/xml-validator-service.jar"]