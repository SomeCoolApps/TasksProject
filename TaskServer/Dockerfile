FROM tomcat

ADD target/tasks-1.0.0-BUILD-SNAPSHOT.war /usr/local/tomcat/webapps/TaskServer.war

CMD ["catalina.sh", "run"]

#docker run --rm -it -p 8080:8080 yourName
#rm removes the container as soon as you stop it
#-p forwards the port to your host (or if you use boot2docker to this IP)
#-it allows interactive mode, so you see if something get's deployed