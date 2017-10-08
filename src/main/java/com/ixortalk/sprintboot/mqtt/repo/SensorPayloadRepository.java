package com.ixortalk.sprintboot.mqtt.repo;

import com.ixortalk.sprintboot.mqtt.domain.SensorPayload;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SensorPayloadRepository extends CrudRepository<SensorPayload, Long> {

    SensorPayload findFirstBySensorIdOrderByDateDesc(String sensorId);

    List<SensorPayload> findBySensorIdOrderByDateDesc(String sensorId);

    @Query("SELECT DISTINCT s.sensorId FROM SensorPayload s")
    List<String> findDistinctSensorIds();

}