package com.ixortalk.sprintboot.mqtt.repo;

import com.ixortalk.sprintboot.mqtt.domain.AdeunisRfTtnPayload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdeunisRfTtnPayloadRepository extends CrudRepository<AdeunisRfTtnPayload, Long> {
}
