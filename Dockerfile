FROM openjdk:14-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/giphy-search-take-home*.jar
COPY ${JAR_FILE} giphy-search-take-home.jar
ENTRYPOINT ["java","-jar","/giphy-search-take-home.jar"]