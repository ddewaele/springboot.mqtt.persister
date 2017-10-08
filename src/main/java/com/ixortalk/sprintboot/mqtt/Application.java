/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ixortalk.sprintboot.mqtt;

import com.ixortalk.sprintboot.mqtt.config.MqttConfig;
import com.ixortalk.sprintboot.mqtt.domain.SensorPayload;
import com.ixortalk.sprintboot.mqtt.handler.SensorMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.mapping.support.JsonHeaders;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;

import static org.springframework.integration.mqtt.support.MqttHeaders.RECEIVED_TOPIC;

@SpringBootApplication
@EnableConfigurationProperties(MqttConfig.class)
public class Application {

	public static final String CONSUMER_CLIENT_ID = "mqtt-persister-client";
	public static final String LOGGER_NAME = "mqtt-logger";

	public static void main(final String... args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private SensorMessageHandler sensorMessageHandler;

	@Autowired
	private MqttConfig mqttConfig;

	@Bean
	public MqttPahoClientFactory mqttClientFactory() {
		DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
		factory.setServerURIs(mqttConfig.getConnectionUrl());
//		factory.setUserName("guest");
//		factory.setPassword("guest");
		return factory;
	}

	@Bean
	public IntegrationFlow mqttInFlow() {
		return IntegrationFlows.from(mqttInbound())

				// log the incoming message
				.wireTap(sf -> sf.handle(logger()))

				// add a json type needed for converting to pojo
				.enrichHeaders(e -> e.header(JsonHeaders.TYPE_ID,SensorPayload.class.getName()))

				// transform the string payload into a pojo (hint provided by type id). Keep the headers this way
				.transform(Transformers.fromJson())

				// add a sensorId to the payload (derived from the topic)
				.enrich(e -> e
						.requestPayload(Message::getPayload)
						.propertyFunction("sensorId", m -> extractSensorIdFromTopic(m)))


				// our handler doesn't receive meta data, only the payload.
				.handle(sensorMessageHandler)

				.get();

	}

	private String extractSensorIdFromTopic(Message<Object> m) {
		String topic = m.getHeaders().get(RECEIVED_TOPIC).toString();
		return topic.substring(topic.lastIndexOf("/")+1,topic.length());
	}

	private LoggingHandler logger() {
		LoggingHandler loggingHandler = new LoggingHandler("INFO");
		loggingHandler.setLoggerName(LOGGER_NAME);
		return loggingHandler;
	}

	@Bean
	public MessageProducerSupport mqttInbound() {
		MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(CONSUMER_CLIENT_ID,
				mqttClientFactory(), mqttConfig.getReceiveMqttTopic());
		adapter.setCompletionTimeout(5000);
		adapter.setConverter(new DefaultPahoMessageConverter());
		adapter.setQos(1);
		return adapter;
	}



}
