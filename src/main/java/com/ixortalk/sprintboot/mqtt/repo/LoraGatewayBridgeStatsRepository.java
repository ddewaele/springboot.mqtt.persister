package com.ixortalk.sprintboot.mqtt.repo;

import com.ixortalk.sprintboot.mqtt.domain.LoraGatewayBridgeStats;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoraGatewayBridgeStatsRepository extends CrudRepository<LoraGatewayBridgeStats, Long> {

}