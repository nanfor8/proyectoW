# Usa Tomcat 10 con Java 17 (imagen oficial)
FROM tomcat:10.1-jdk17-temurin

# Borra la aplicación por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu WAR con el nombre ROOT para que sea la app principal
COPY target/proyectoW.war /usr/local/tomcat/webapps/ROOT.war

# Expón el puerto estándar
EXPOSE 8080

# Mantén Tomcat corriendo en primer plano
CMD ["catalina.sh", "run"]
