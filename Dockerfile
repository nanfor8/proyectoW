# Imagen base: Tomcat 10 + JDK 17
FROM tomcat:10.1-jdk17-temurin

# Eliminar la app por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar el WAR del proyecto como ROOT
COPY target/proyectoW.war /usr/local/tomcat/webapps/ROOT.war

# Exponer el puerto 8080
EXPOSE 8080

# Mantener Tomcat corriendo en primer plano
ENTRYPOINT ["catalina.sh", "run"]
