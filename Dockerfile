FROM openjdk:11
ENV JAVA_OPTS=""
ARG JAR_FILE
ADD ${JAR_FILE} app.jar
COPY appshell.sh appshell.sh
EXPOSE 8080
ENTRYPOINT ["sh", "/appshell.sh"]