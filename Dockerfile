FROM openjdk:14-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/giphy_search-0.0.1-SNAPSHOT*.jar
COPY ${JAR_FILE} giphy_search-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/giphy_search-0.0.1-SNAPSHOT.jar"]