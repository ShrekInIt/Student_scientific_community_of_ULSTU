# Dockerfile для Spring Boot (WAR)
FROM tomcat:10-jdk17-temurin
LABEL maintainer="FestFlex Team"

# Удаляем стандартные приложения Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Копируем собранный WAR-файл
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]

