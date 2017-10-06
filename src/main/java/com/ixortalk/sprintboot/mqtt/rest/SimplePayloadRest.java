package com.ixortalk.sprintboot.mqtt.rest;

import com.ixortalk.sprintboot.mqtt.domain.SensorPayload;
import com.ixortalk.sprintboot.mqtt.domain.SensorPayloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class SimplePayloadRest {

    @Autowired
    private SensorPayloadRepository sensorPayloadRepository;

    @RequestMapping("/api/aggregate")
    public Map<String,SensorPayload> aggregate() {
        List<String> distinctSensorIds = sensorPayloadRepository.findDistinctSensorIds();
        Map<String,SensorPayload> map = new HashMap<>();

        for (String sensorId : distinctSensorIds) {
            map.put(sensorId,sensorPayloadRepository.findFirstBySensorIdOrderByDateDesc(sensorId));
        }

        return map;
    }

    @RequestMapping("/api/sensor/{sensorId}")
    public SensorPayload getPayloadforSensorId(@PathVariable String sensorId) {
        return sensorPayloadRepository.findFirstBySensorIdOrderByDateDesc(sensorId);
    }

    @RequestMapping("/api/sensor/{sensorId}/history")
    public List<SensorPayload> getPayloadHistoryForSensorId(@PathVariable String sensorId) {
        return sensorPayloadRepository.findBySensorIdOrderByDateDesc(sensorId);
    }
}
