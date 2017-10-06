#Spring Boot MQTT Persister

Spring Boot / Integration project that listens on an MQTT topic, processes incoming messages (sensor payloads), logs them and persists them into a DB.
Exposes a REST API to query the sensor payloads.

## Dependencies

MQTT broker needs to be running (configured in application.yml)

## Sample messages

Messages can be injected using MQTT: 

```
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-77" -m "{\"temp\":23,\"status\":true,\"date\":\"2010-01-01T13:47:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}"
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-77" -m "{\"temp\":17,\"status\":false,\"date\":\"2010-01-01T13:45:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}"
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-77" -m "{\"temp\":34,\"status\":false,\"date\":\"2010-01-01T13:40:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}"
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-77" -m "{\"temp\":10,\"status\":false,\"date\":\"2010-01-01T13:30:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-77" -m "{\"temp\":11,\"status\":false,\"date\":\"2010-01-01T13:10:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-77" -m "{\"temp\":12,\"status\":false,\"date\":\"2010-01-01T13:20:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-78" -m "{\"temp\":13,\"status\":false,\"date\":\"2010-01-01T13:10:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-78" -m "{\"temp\":14,\"status\":false,\"date\":\"2010-01-01T13:30:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-78" -m "{\"temp\":15,\"status\":false,\"date\":\"2010-01-01T13:20:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
mosquitto_pub -h localhost -t "ixortalk/msg/88-11-22-33-44-55-66-79" -m "{\"temp\":16,\"status\":false,\"date\":\"2010-01-01T13:40:00+01:00\",\"raw\":\"0101470dd3c16e00640b0209d100\"}" 
```

We also provide a `generate.sh` script that inserts some random data every second.


## REST API

The application exposes REST APIs to fetch the sensor data. 

```
http://localhost:8080/api/sensor/88-11-22-33-44-55-66-79  ---> shows the most recent sensor value
http://localhost:8080/api/sensor/88-11-22-33-44-55-66-79/history   ----> shows the historical values
curl http://localhost:8080/api/aggregate ---> aggregates all recent sensor values for distinct sensor IDs.
```

## Spring Boot as docker

Can be run as a docker container.
```
docker run --name springboot.mqtt.persister -p 8080:8080 -d ddewaele/springboot.mqtt.persister
```