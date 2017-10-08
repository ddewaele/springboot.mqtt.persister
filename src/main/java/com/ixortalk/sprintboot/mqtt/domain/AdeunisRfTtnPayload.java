package com.ixortalk.sprintboot.mqtt.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AdeunisRfTtnPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @Embedded
    @JsonProperty("payload_fields")
    private PayloadFields payloadFields;

    public PayloadFields getPayloadFields() {
        return payloadFields;
    }

    public void setPayloadFields(PayloadFields payloadFields) {
        this.payloadFields = payloadFields;
    }

    @Override
    public String toString() {
        return "AdeunisRfTtnPayload{" +
                "id=" + id +
                ", payloadFields=" + payloadFields +
                '}';
    }

    @Embeddable
    public static class PayloadFields {

        private int btn1; //32,
        private String device_id; //"adeunis-rf-tester",
        private int down; //55,
        private boolean gps; //true,
        private double lat; //"50.961950",
        private double lon; //"3.516833",
        private String raw; //"vxhQV3FwADMQEDo3GAu5bQE=",
        private int rssi; //-185,
        private int snr; //109,
        private int temp; //24,
        private Date time; //"2017-10-08T16:38:40.888063386Z",
        private int uplink; //58,
        private double vbat; //6.155


        public int getBtn1() {
            return btn1;
        }

        public void setBtn1(int btn1) {
            this.btn1 = btn1;
        }

        public String getDevice_id() {
            return device_id;
        }

        public void setDevice_id(String device_id) {
            this.device_id = device_id;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public boolean isGps() {
            return gps;
        }

        public void setGps(boolean gps) {
            this.gps = gps;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public int getRssi() {
            return rssi;
        }

        public void setRssi(int rssi) {
            this.rssi = rssi;
        }

        public int getSnr() {
            return snr;
        }

        public void setSnr(int snr) {
            this.snr = snr;
        }

        public int getTemp() {
            return temp;
        }

        public void setTemp(int temp) {
            this.temp = temp;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public int getUplink() {
            return uplink;
        }

        public void setUplink(int uplink) {
            this.uplink = uplink;
        }

        public double getVbat() {
            return vbat;
        }

        public void setVbat(double vbat) {
            this.vbat = vbat;
        }


        @Override
        public String toString() {
            return "AdeunisRfTtnPayload{" +
                    "btn1=" + btn1 +
                    ", device_id='" + device_id + '\'' +
                    ", down=" + down +
                    ", gps=" + gps +
                    ", lat=" + lat +
                    ", lon=" + lon +
                    ", raw='" + raw + '\'' +
                    ", rssi=" + rssi +
                    ", snr=" + snr +
                    ", temp=" + temp +
                    ", time=" + time +
                    ", uplink=" + uplink +
                    ", vbat=" + vbat +
                    '}';
        }

    }
}
