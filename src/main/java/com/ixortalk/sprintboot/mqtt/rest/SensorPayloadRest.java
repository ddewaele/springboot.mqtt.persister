package com.ixortalk.sprintboot.mqtt.rest;

import com.ixortalk.sprintboot.mqtt.domain.SensorPayload;
import com.ixortalk.sprintboot.mqtt.repo.SensorPayloadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SensorPayloadRest {

    private final Logger log = LoggerFactory.getLogger(SensorPayloadRest.class);

    @Autowired
    private SensorPayloadRepository sensorPayloadRepository;

    @GetMapping("/api/aggregate")
    public Map<String,SensorPayload> aggregate() {
        List<String> distinctSensorIds = sensorPayloadRepository.findDistinctSensorIds();
        Map<String,SensorPayload> map = new HashMap<>();

        for (String sensorId : distinctSensorIds) {
            map.put(sensorId,sensorPayloadRepository.findFirstBySensorIdOrderByDateDesc(sensorId));
        }

        return map;
    }

    @GetMapping("/api/sensor/{sensorId}")
    public SensorPayload getPayloadforSensorId(@PathVariable String sensorId) {
        return sensorPayloadRepository.findFirstBySensorIdOrderByDateDesc(sensorId);
    }

    @PostMapping("/api/sensor")
    public SensorPayload addPayloadforSensorId(@RequestBody SensorPayload sensorPayload) {
        log.info("Saving sensorPayload {}",sensorPayload);
        return sensorPayloadRepository.save(sensorPayload);
    }

    @GetMapping("/api/sensor/{sensorId}/history")
    public List<SensorPayload> getPayloadHistoryForSensorId(@PathVariable String sensorId) {
        return sensorPayloadRepository.findBySensorIdOrderByDateDesc(sensorId);
    }
}
