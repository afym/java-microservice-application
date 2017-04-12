FROM maven:3.5.0-jdk-8-alpine

WORKDIR /usr/micro-api-countries

ADD pom.xml /usr/micro-api-countries/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

ADD src /usr/micro-api-countries/src
RUN ["mvn", "package"]

EXPOSE 3000

CMD ["/usr/bin/java", "-jar", "target/micro-api-countries-final.jar"]