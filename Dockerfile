From tomcat:8-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/KalingaLibrary-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]
