package com.add.apptsh;

public class ZhiShuBean {

    public String stationnum;
    public String stationname;
    public String jyzslevel;
    public String jyzs;
    public String cyzslevel;
    public String cyzs;
    public String slhxlevel;
    public String slhx;
    public String observtime;

    public String getStationnum() {
        return stationnum;
    }

    public void setStationnum(String stationnum) {
        this.stationnum = stationnum;
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname;
    }

    public String getJyzslevel() {
        return jyzslevel.replace(",","").replace(" ","");
    }

    public void setJyzslevel(String jyzslevel) {
        this.jyzslevel = jyzslevel;
    }

    public String getJyzs() {
        return jyzs;
    }

    public void setJyzs(String jyzs) {
        this.jyzs = jyzs;
    }

    public String getCyzslevel() {
        return cyzslevel.replace(",","").replace(" ","");
    }

    public void setCyzslevel(String cyzslevel) {
        this.cyzslevel = cyzslevel;
    }

    public String getCyzs() {
        return cyzs;
    }

    public void setCyzs(String cyzs) {
        this.cyzs = cyzs;
    }

    public String getSlhxlevel() {
        return slhxlevel;
    }

    public void setSlhxlevel(String slhxlevel) {
        this.slhxlevel = slhxlevel;
    }

    public String getSlhx() {
        return slhx;
    }

    public void setSlhx(String slhx) {
        this.slhx = slhx;
    }

    public String getObservtime() {
        return observtime;
    }

    public void setObservtime(String observtime) {
        this.observtime = observtime;
    }
}
