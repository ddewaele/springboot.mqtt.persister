# Spring Boot Lora Persister

Spring Boot / Integration project that processes Lora messages by

- listening on an MQTT topic
- accepting payloads via REST

logs them and persists them into a DB.

Exposes a REST API to query the sensor payloads.

Currently supports 

- MultiTech Lora Network Server message format
- LoraBridge message (stats, rx)
- Adeunis RF TTN converted messages
- Custom sensor payloads

## Spring Boot as docker

Can be run as a docker container.
```
docker run --name springboot.mqtt.persister -p 8080:8080 -d ddewaele/springboot.mqtt.persister
```

## Docker compose

We also offer a docker-compose file.

# Supported payloads




## MultiTech message format


```
curl -H "Content-Type: application/json" -d@./src/test/resources/multitech-conduit-payload.json http://localhost:8086/multiTechPayloads
curl http://localhost:8086/multiTechPayloads
```

## Lora Bridge network format

Support for persisting [lora-gateway-bridge](https://hub.docker.com/r/loraserver/lora-gateway-bridge/) json payloads coming in via MQTT.

- gateway/[GATEWAY_ID]/stats
- gateway/[GATEWAY_ID]/rx

Where GATEWAY_ID is he mac hex representation of the gateway (ex: b827ebfffecbe31f)

REST endpoints are also made available :

```
curl -H "Content-Type: application/json" -d@./src/test/resources/lora-gateway-bridge-receive.json http://localhost:8086/loraGatewayBridgeReceives
curl http://localhost:8086/loraGatewayBridgeReceives
```

```
curl -H "Content-Type: application/json" -d@./src/test/resources/lora-gateway-bridge-gateway-status.json http://localhost:8086/loraGatewayBridgeStatses
curl http://localhost:8086/loraGatewayBridgeStatses
```

## Adeunis RF Field Tester

```
curl -H "Content-Type: application/json" -d@./src/test/resources/adeunis-ttn-payload.json http://localhost:8086/adeunisRfTtnPayloads
curl http://localhost:8086/adeunisRfTtnPayloads
```

## Custom sensor payloads

The application supports a custom sensor payload via MQTT.

```
{
  "sensorId": "88-00-00-00-00-00-00-00",
  "temp": 20,
  "status": true,
  "date": "2017-10-08T08:52:03.631Z",
  "raw": "xxxxxxxxxxxx"
}
```

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

or via REST

```
curl -X POST -H "Content-Type:application/json" -d @./src/test/resources/payload.json http://localhost:8085/api/sensor
```

We also provide a `generate.sh` script that inserts some random data every second.


## REST API

The application exposes REST APIs to fetch the sensor data. 

```
http://localhost:8080/api/sensor/88-11-22-33-44-55-66-79  ---> shows the most recent sensor value
http://localhost:8080/api/sensor/88-11-22-33-44-55-66-79/history   ----> shows the historical values
curl http://localhost:8080/api/aggregate ---> aggregates all recent sensor values for distinct sensor IDs.
```
