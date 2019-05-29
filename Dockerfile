FROM maven:3.6-jdk-8-alpine AS build
COPY . /stock-handling
WORKDIR /stock-handling

RUN mvn clean install -U package spring-boot:repackage
#RUN mvn package spring-boot:repackage

FROM openjdk:8u191-jre-alpine3.8
WORKDIR /stock-handling
COPY --from=build /stock-handling/target/stock-handling-0.0.1.jar /stock-handling
EXPOSE 8432
CMD ["java","-jar","stock-handling-0.0.1.jar"]
