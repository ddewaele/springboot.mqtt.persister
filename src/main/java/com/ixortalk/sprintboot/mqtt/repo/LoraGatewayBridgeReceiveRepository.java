package com.ixortalk.sprintboot.mqtt.repo;

import com.ixortalk.sprintboot.mqtt.domain.LoraGatewayBridgeReceive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoraGatewayBridgeReceiveRepository  extends CrudRepository<LoraGatewayBridgeReceive, Long> {
}
