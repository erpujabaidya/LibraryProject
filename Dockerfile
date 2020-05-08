FROM openjdk:8
EXPOSE 8080
ADD target/KalingaLibrary.war KalingaLibrary.war
ENTRYPOINT ["java","-war","/KalingaLibrary.war"]
