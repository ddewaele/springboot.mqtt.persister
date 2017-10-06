package com.ixortalk.sprintboot.mqtt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class SensorPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String sensorId;
    public boolean status;
    public int temp;
    public Date date;

    @Override
    public String toString() {
        return "SensorPayload{" +
                "id=" + id +
                ", sensorId='" + sensorId + '\'' +
                ", status=" + status +
                ", temp=" + temp +
                ", date=" + date +
                '}';
    }
}
