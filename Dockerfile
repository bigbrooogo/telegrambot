FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_jrtb_bigbrooogo_bot
ENV BOT_TOKEN=7920265075:AAFCKRvYgWeh2SxLjUYa4HiZ-UXtKYJE2fM
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]