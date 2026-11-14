FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
RUN mvn -q dependency:go-offline          # cached unless pom.xml changes
COPY src ./src
RUN mvn -q package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /src/target/*.jar app.jar
ENTRYPOINT ["java", "-cp", "app.jar", "com.pcgs.core.java.pocs.App"]
CMD ["--greeting=hello"]