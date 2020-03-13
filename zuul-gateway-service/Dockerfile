FROM openjdk:8-jre
MAINTAINER Mario Hercog <mario.hercog@gmail.com>

ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/zuul-gateway-service/zuul-gateway-service.jar

EXPOSE 8765

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/usr/share/zuul-gateway-service/zuul-gateway-service.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8765/actuator/health || exit 1
