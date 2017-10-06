package com.ixortalk.sprintboot.mqtt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ixortalk.mqtt")
public class MqttConfig {

    private String connectionUrl;
    private String username;
    private String password;
    private String receiveMqttTopic;

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReceiveMqttTopic() {
        return receiveMqttTopic;
    }

    public void setReceiveMqttTopic(String receiveMqttTopic) {
        this.receiveMqttTopic = receiveMqttTopic;
    }
}
