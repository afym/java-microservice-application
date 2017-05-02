FROM maven:3.5.0-jdk-8

WORKDIR /usr/micro-stress-cpu

RUN cd /tmp && \
    wget http://ftp.us.debian.org/debian/pool/main/s/stress/stress_1.0.1-1+deb8u1_amd64.deb && \
    dpkg -i stress_1.0.1-1+deb8u1_amd64.deb && \
    apt-get -f install

ADD pom.xml /usr/micro-stress-cpu/pom.xml
RUN cd /tmp && curl https://people.seas.harvard.edu/~apw/stress/stress-1.0.4.tar.gz | tar xvz
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

ADD src /usr/micro-stress-cpu/src
RUN ["mvn", "package"]

EXPOSE 4567

CMD ["/usr/bin/java", "-jar", "target/microservice-jar-with-dependencies.jar"]