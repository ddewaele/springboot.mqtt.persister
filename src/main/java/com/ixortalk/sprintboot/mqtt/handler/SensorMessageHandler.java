package com.ixortalk.sprintboot.mqtt.handler;

import com.ixortalk.sprintboot.mqtt.domain.SensorPayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class SensorMessageHandler {

    private final Logger log = LoggerFactory.getLogger(SensorMessageHandler.class);

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void handleMessage(SensorPayload sensorPayload)  {
        log.info("Persisting {}",sensorPayload);
        entityManager.persist(sensorPayload);
    }
}
