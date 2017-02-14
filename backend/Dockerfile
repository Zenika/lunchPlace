FROM java:8-jre-alpine
MAINTAINER Zenika Lille <info-lille@zenika.com>

ADD ./build/libs/lunchplace_backend-*.jar /lunchplace_backend.jar
ADD ./build/version.txt /version.txt

VOLUME /tmp

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/lunchplace_backend.jar"]
