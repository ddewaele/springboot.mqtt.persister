FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD springboot.mqtt.persister-*.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
VOLUME ["/var/log"]
ADD docker-entrypoint.sh /
RUN chmod +x /docker-entrypoint.sh
ENTRYPOINT ["/docker-entrypoint.sh"]
HEALTHCHECK CMD wget -q http://localhost:8080/health -O /dev/null