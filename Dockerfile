FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_jrtb_bigbrooogo_bot
ENV BOT_TOKEN=7920265075:AAFCKRvYgWeh2SxLjUYa4HiZ-UXtKYJE2fM
ENV BOT_DB_USERNAME=db_username
ENV BOT_DB_PASSWORD=db_username_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dspring.datasource.username=${BOT_DB_USERNAME}" "-jar", "/app.jar"]