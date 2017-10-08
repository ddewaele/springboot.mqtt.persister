package com.ixortalk.sprintboot.mqtt.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LoraGatewayBridgeReceive {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private String phyPayload; // "gOMjASYADwABPOOxfCcvftbpNdype8/7tpU8rcjn"

    @Embedded
    private RxInfo rxInfo;

    public String getPhyPayload() {
        return phyPayload;
    }

    public void setPhyPayload(String phyPayload) {
        this.phyPayload = phyPayload;
    }

    public RxInfo getRxInfo() {
        return rxInfo;
    }

    public void setRxInfo(RxInfo rxInfo) {
        this.rxInfo = rxInfo;
    }

    @Override
    public String toString() {
        return "LoraGatewayBridgeReceive{" +
                "id=" + id +
                ", phyPayload='" + phyPayload + '\'' +
                ", rxInfo=" + rxInfo +
                '}';
    }

    @Embeddable
    static class RxInfo {

        private String mac; //"b827ebfffecbe31f",
        private Date time; //"2017-10-08T16:28:26.259816Z",
        private long timestamp; //3343871588,
        private long frequency; //868100000,
        private long channel; //0,
        private long rfChain; //1,
        private long crcStatus; //1,
        private String codeRate; //"4/5",
        private long rssi; //-112,
        private long loRaSNR; //-6,
        private long size; //30,

        @Embedded
        private DataRate dataRate;

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public long getFrequency() {
            return frequency;
        }

        public void setFrequency(long frequency) {
            this.frequency = frequency;
        }

        public long getChannel() {
            return channel;
        }

        public void setChannel(long channel) {
            this.channel = channel;
        }

        public long getRfChain() {
            return rfChain;
        }

        public void setRfChain(long rfChain) {
            this.rfChain = rfChain;
        }

        public long getCrcStatus() {
            return crcStatus;
        }

        public void setCrcStatus(long crcStatus) {
            this.crcStatus = crcStatus;
        }

        public String getCodeRate() {
            return codeRate;
        }

        public void setCodeRate(String codeRate) {
            this.codeRate = codeRate;
        }

        public long getRssi() {
            return rssi;
        }

        public void setRssi(long rssi) {
            this.rssi = rssi;
        }

        public long getLoRaSNR() {
            return loRaSNR;
        }

        public void setLoRaSNR(long loRaSNR) {
            this.loRaSNR = loRaSNR;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public DataRate getDataRate() {
            return dataRate;
        }

        public void setDataRate(DataRate dataRate) {
            this.dataRate = dataRate;
        }

        @Override
        public String toString() {
            return "RxInfo{" +
                    "mac='" + mac + '\'' +
                    ", time=" + time +
                    ", timestamp=" + timestamp +
                    ", frequency=" + frequency +
                    ", channel=" + channel +
                    ", rfChain=" + rfChain +
                    ", crcStatus=" + crcStatus +
                    ", codeRate='" + codeRate + '\'' +
                    ", rssi=" + rssi +
                    ", loRaSNR=" + loRaSNR +
                    ", size=" + size +
                    ", dataRate=" + dataRate +
                    '}';
        }
    }

    @Embeddable
    public static class DataRate {

        private String modulation; //"LORA",
        private int spreadFactor; //10,
        private int bandwidth; //125

        public String getModulation() {
            return modulation;
        }

        public void setModulation(String modulation) {
            this.modulation = modulation;
        }

        public int getSpreadFactor() {
            return spreadFactor;
        }

        public void setSpreadFactor(int spreadFactor) {
            this.spreadFactor = spreadFactor;
        }

        public int getBandwidth() {
            return bandwidth;
        }

        public void setBandwidth(int bandwidth) {
            this.bandwidth = bandwidth;
        }

        @Override
        public String toString() {
            return "DataRate{" +
                    "modulation='" + modulation + '\'' +
                    ", spreadFactor=" + spreadFactor +
                    ", bandwidth=" + bandwidth +
                    '}';
        }
    }

}
