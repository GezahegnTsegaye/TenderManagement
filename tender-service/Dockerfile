FROM openjdk:17-alpine
ENV APP_FILE tenderee-1.1-SNAPSHOT.jar
ENV APP_HOME /app
EXPOSE 8081
COPY target/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE"]