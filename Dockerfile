FROM java:8
EXPOSE 8088
ADD target/salesapp-0.0.1-SNAPSHOT.jar salesapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","salesapp-0.0.1-SNAPSHOT.jar"]