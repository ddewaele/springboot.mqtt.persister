#!/bin/sh

# Exit on non-zero return values
set -e

echo "Starting springboot.mqtt.persister..."
java $JAVA_OPTS -Dlogging.file=/var/log/springboot.mqtt.persister.log -Djava.security.egd=file:/dev/./urandom -jar /app.jar