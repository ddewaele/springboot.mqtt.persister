package com.ixortalk.sprintboot.mqtt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoraGatewayBridgeStats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String mac; //"b827ebfffecbe31f",
    private String time; //"2017-10-08T16:28:05Z",
    private double latitude; //50.9625,
    private double longitude; //3.51749,
    private int altitude; //14,
    private long rxPacketsReceived; //0,
    private long rxPacketsReceivedOK; //0,
    private long txPacketsReceived; //0,
    private long txPacketsEmitted; //0,
    private String customData; //null

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public long getRxPacketsReceived() {
        return rxPacketsReceived;
    }

    public void setRxPacketsReceived(long rxPacketsReceived) {
        this.rxPacketsReceived = rxPacketsReceived;
    }

    public long getRxPacketsReceivedOK() {
        return rxPacketsReceivedOK;
    }

    public void setRxPacketsReceivedOK(long rxPacketsReceivedOK) {
        this.rxPacketsReceivedOK = rxPacketsReceivedOK;
    }

    public long getTxPacketsReceived() {
        return txPacketsReceived;
    }

    public void setTxPacketsReceived(long txPacketsReceived) {
        this.txPacketsReceived = txPacketsReceived;
    }

    public long getTxPacketsEmitted() {
        return txPacketsEmitted;
    }

    public void setTxPacketsEmitted(long txPacketsEmitted) {
        this.txPacketsEmitted = txPacketsEmitted;
    }

    public String getCustomData() {
        return customData;
    }

    public void setCustomData(String customData) {
        this.customData = customData;
    }

    @Override
    public String toString() {
        return "LoraGatewayBridgeStats{" +
                "mac='" + mac + '\'' +
                ", time='" + time + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", altitude=" + altitude +
                ", rxPacketsReceived=" + rxPacketsReceived +
                ", rxPacketsReceivedOK=" + rxPacketsReceivedOK +
                ", txPacketsReceived=" + txPacketsReceived +
                ", txPacketsEmitted=" + txPacketsEmitted +
                ", customData='" + customData + '\'' +
                '}';
    }
}
