package com.ixortalk.sprintboot.mqtt.handler;

import com.ixortalk.sprintboot.mqtt.domain.LoraGatewayBridgeReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component
public class LoraGatewayBridgeReceiveHandler {

    private final Logger log = LoggerFactory.getLogger(LoraGatewayBridgeReceiveHandler.class);

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void handleMessage(LoraGatewayBridgeReceive loraGatewayBridgeReceive)  {
        log.info("Persisting {}",loraGatewayBridgeReceive);
        entityManager.persist(loraGatewayBridgeReceive);
    }
}
