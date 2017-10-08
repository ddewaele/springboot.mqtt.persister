package com.ixortalk.sprintboot.mqtt.repo;

import com.ixortalk.sprintboot.mqtt.domain.MultiTechPayload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MultiTechPayloadRepository extends CrudRepository<MultiTechPayload, Long> {

}