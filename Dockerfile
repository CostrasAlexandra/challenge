FROM openjdk:8
ADD build/libs/challenge-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8080

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app2.jar" ]