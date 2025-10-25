FROM tomcat:10.1-jdk17-temurin

# Copia tu WAR dentro del Tomcat
COPY target/proyectoW.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
