FROM maven:3.5.0-jdk-8-alpine

WORKDIR /usr/micro-state-tracker

ADD pom.xml /usr/micro-state-tracker/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

ADD src /usr/micro-state-tracker/src
RUN ["mvn", "package"]

ENV CLUSTER_VOLUME_PATH="/tmp"

EXPOSE 4567

CMD ["/usr/bin/java", "-jar", "target/microservice-jar-with-dependencies.jar"]