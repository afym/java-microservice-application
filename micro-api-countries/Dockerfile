FROM maven:3.5.0-jdk-8-alpine

WORKDIR /usr/micro-api-countries

ADD pom.xml /usr/micro-api-countries/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

ADD src /usr/micro-api-countries/src
RUN ["mvn", "package"]

ENV MICRO_DB_COUNTRY_HOSTANME="localhost"
ENV MICRO_DB_COUNTRY_USER="user"
ENV MICRO_DB_COUNTRY_PASSWORD="password"
ENV MICRO_DB_COUNTRY_DATABASE="database"

EXPOSE 4567

CMD ["/usr/bin/java", "-jar", "target/microservice-jar-with-dependencies.jar"]