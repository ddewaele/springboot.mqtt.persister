package com.ixortalk.sprintboot.mqtt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Date;

import static com.ixortalk.sprintboot.mqtt.util.Utils.bytesToHex;

@Entity
public class MultiTechPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private int chan;  //2
    private int cls; //0,
    private String codr; //"4/5",
    private String datr; //"SF10BW125",
    private String freq; //"868.5",
    private String lsnr; //"7.8",
    private String mhdr; //"40fb0f0000004500",
    private String modu; //"LORA",
    private String opts; //"",
    private int port; //0,
    private int rfch; //0,
    private int rssi; //-40,
    private int seqn; //69,
    private int size; //20,
    private Date timestamp; //"2017-10-08T20:10:20.509469Z",
    private long tmst; //768330892,
    private byte[] payload; //[1,1,71,13,196,193,81,0,99,11,2,4,187,0],
    private String eui; //"88-00-00-00-00-00-00-00",
    private String _msgid; //"35155dc8.caeaa2"

    public int getChan() {
        return chan;
    }

    public void setChan(int chan) {
        this.chan = chan;
    }

    public int getCls() {
        return cls;
    }

    public void setCls(int cls) {
        this.cls = cls;
    }

    public String getCodr() {
        return codr;
    }

    public void setCodr(String codr) {
        this.codr = codr;
    }

    public String getDatr() {
        return datr;
    }

    public void setDatr(String datr) {
        this.datr = datr;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }

    public String getLsnr() {
        return lsnr;
    }

    public void setLsnr(String lsnr) {
        this.lsnr = lsnr;
    }

    public String getMhdr() {
        return mhdr;
    }

    public void setMhdr(String mhdr) {
        this.mhdr = mhdr;
    }

    public String getModu() {
        return modu;
    }

    public void setModu(String modu) {
        this.modu = modu;
    }

    public String getOpts() {
        return opts;
    }

    public void setOpts(String opts) {
        this.opts = opts;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getRfch() {
        return rfch;
    }

    public void setRfch(int rfch) {
        this.rfch = rfch;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getSeqn() {
        return seqn;
    }

    public void setSeqn(int seqn) {
        this.seqn = seqn;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public long getTmst() {
        return tmst;
    }

    public void setTmst(long tmst) {
        this.tmst = tmst;
    }

    public byte[] getPayload() {
        return payload;
    }

    public void setPayload(byte[] payload) {
        this.payload = payload;
    }

    public String getEui() {
        return eui;
    }

    public void setEui(String eui) {
        this.eui = eui;
    }

    public String get_msgid() {
        return _msgid;
    }

    public void set_msgid(String _msgid) {
        this._msgid = _msgid;
    }

    public String getPayloadAsHex() {
        return bytesToHex(this.payload);
    }

    @Override
    public String toString() {
        return "MultiTechPayload{" +
                "id=" + id +
                ", chan=" + chan +
                ", cls=" + cls +
                ", codr='" + codr + '\'' +
                ", datr='" + datr + '\'' +
                ", freq='" + freq + '\'' +
                ", lsnr='" + lsnr + '\'' +
                ", mhdr='" + mhdr + '\'' +
                ", modu='" + modu + '\'' +
                ", opts='" + opts + '\'' +
                ", port=" + port +
                ", rfch=" + rfch +
                ", rssi=" + rssi +
                ", seqn=" + seqn +
                ", size=" + size +
                ", timestamp=" + timestamp +
                ", tmst=" + tmst +
                ", payload=" + Arrays.toString(payload) +
                ", payloadAsHex=" + getPayloadAsHex() +
                ", eui='" + eui + '\'' +
                ", _msgid='" + _msgid + '\'' +
                '}';
    }



}
