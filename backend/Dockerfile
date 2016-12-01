FROM java:8

VOLUME /tmp

ADD lunchplace_backend-0.0.1.jar lunchplace_backend.jar

RUN sh -c 'touch /lunchplace_backend.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/lunchplace_backend.jar"]
