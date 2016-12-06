FROM java:8

MAINTAINER Zenika Lille <info-lille@zenika.com>

ADD ./build/libs/lunchplace_backend-*.jar /lunchplace_backend.jar

VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/lunchplace_backend.jar"]
