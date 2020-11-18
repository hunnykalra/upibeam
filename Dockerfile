FROM adoptopenjdk/openjdk8

WORKDIR /opt/unibeam
COPY conf .
CMD ["java", "-jar","-Xms256m","-Xmx2048m","-Dspring.config.location=/opt/unibeam/application.properties","-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8008","/opt/upibeam/UniBeam-0.0.1.jar","--server.port=9099"]
