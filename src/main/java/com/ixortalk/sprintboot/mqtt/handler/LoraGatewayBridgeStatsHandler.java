package com.ixortalk.sprintboot.mqtt.handler;

import com.ixortalk.sprintboot.mqtt.domain.LoraGatewayBridgeStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class LoraGatewayBridgeStatsHandler {

    private final Logger log = LoggerFactory.getLogger(LoraGatewayBridgeStatsHandler.class);

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void handleMessage(LoraGatewayBridgeStats loraGatewayBridgeStats)  {
        log.info("Persisting {}",loraGatewayBridgeStats);
        entityManager.persist(loraGatewayBridgeStats);
    }
}
