FROM openjdk:8-jre
MAINTAINER Mario Hercog <mario.hercog@gmail.com>

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/admin-server/admin-server.jar

EXPOSE 9000

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/share/admin-server/admin-server.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:9000/actuator/health || exit 1
