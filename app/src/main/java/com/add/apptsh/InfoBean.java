package com.add.apptsh;

import org.json.JSONException;
import org.json.JSONObject;

public class InfoBean {
        /*"site_item":"K3037",
"site_name":"南浦溪景区",
"title_name":"泰顺气象局",
"updatetime":"28日11时00分",
"wea_wendu":"18℃",
"wea_Maxwendu":"18℃",
"wea_Minwendu":"15.8℃",
"wea_shidu":"88%",
"wea_Maxshidu":"98%",
"wea_Minshidu":"88%",
"wea_fengsu":"0.9m/s",
"wea_Maxfengsu":"0.9m/s",
"wea_Minfengsu":"0m/s",
"wea_fengxiang":"偏北风",
"wea_yuliang":"8.3mm",
"wea_houryuling":"0.4mm",
"wea_qiya":"996.7hPa",
"wea_vis":"m"*/
        public String site_item;
    public String site_name;
    public String title_name;
    public String updatetime;
    public String wea_wendu;
    public String wea_Maxwendu;
    public String wea_Minwendu;
    public String wea_shidu;
    public String wea_Maxshidu;
    public String wea_Minshidu;
    public String wea_fengsu;
    public String wea_Maxfengsu;
    public String wea_Minfengsu;
    public String wea_fengxiang;
    public String wea_yuliang;
    public String wea_houryuling;
    public String wea_qiya;
    public String wea_vis;
    public InfoBean(){

    }

    public InfoBean(String site_item, String site_name, String title_name, String updatetime, String wea_wendu, String wea_Maxwendu, String wea_Minwendu, String wea_shidu, String wea_Maxshidu, String wea_Minshidu, String wea_fengsu, String wea_Maxfengsu, String wea_Minfengsu, String wea_fengxiang, String wea_yuliang, String wea_houryuling, String wea_qiya, String wea_vis) {
        this.site_item = site_item;
        this.site_name = site_name;
        this.title_name = title_name;
        this.updatetime = updatetime;
        this.wea_wendu = wea_wendu;
        this.wea_Maxwendu = wea_Maxwendu;
        this.wea_Minwendu = wea_Minwendu;
        this.wea_shidu = wea_shidu;
        this.wea_Maxshidu = wea_Maxshidu;
        this.wea_Minshidu = wea_Minshidu;
        this.wea_fengsu = wea_fengsu;
        this.wea_Maxfengsu = wea_Maxfengsu;
        this.wea_Minfengsu = wea_Minfengsu;
        this.wea_fengxiang = wea_fengxiang;
        this.wea_yuliang = wea_yuliang;
        this.wea_houryuling = wea_houryuling;
        this.wea_qiya = wea_qiya;
        this.wea_vis = wea_vis;
    }
/* public InfoBean(String data) {
        try {
            JSONObject obj = new JSONObject(data);
            obj.getString()
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }*/

    public String getSite_item() {
        return site_item;
    }

    public void setSite_item(String site_item) {
        this.site_item = site_item;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getWea_wendu() {
        return wea_wendu;
    }

    public void setWea_wendu(String wea_wendu) {
        this.wea_wendu = wea_wendu;
    }

    public String getWea_Maxwendu() {
        return wea_Maxwendu;
    }

    public void setWea_Maxwendu(String wea_Maxwendu) {
        this.wea_Maxwendu = wea_Maxwendu;
    }

    public String getWea_Minwendu() {
        return wea_Minwendu;
    }

    public void setWea_Minwendu(String wea_Minwendu) {
        this.wea_Minwendu = wea_Minwendu;
    }

    public String getWea_shidu() {
        return wea_shidu;
    }

    public void setWea_shidu(String wea_shidu) {
        this.wea_shidu = wea_shidu;
    }

    public String getWea_Maxshidu() {
        return wea_Maxshidu;
    }

    public void setWea_Maxshidu(String wea_Maxshidu) {
        this.wea_Maxshidu = wea_Maxshidu;
    }

    public String getWea_Minshidu() {
        return wea_Minshidu;
    }

    public void setWea_Minshidu(String wea_Minshidu) {
        this.wea_Minshidu = wea_Minshidu;
    }

    public String getWea_fengsu() {
        return wea_fengsu;
    }

    public void setWea_fengsu(String wea_fengsu) {
        this.wea_fengsu = wea_fengsu;
    }

    public String getWea_Maxfengsu() {
        return wea_Maxfengsu;
    }

    public void setWea_Maxfengsu(String wea_Maxfengsu) {
        this.wea_Maxfengsu = wea_Maxfengsu;
    }

    public String getWea_Minfengsu() {
        return wea_Minfengsu;
    }

    public void setWea_Minfengsu(String wea_Minfengsu) {
        this.wea_Minfengsu = wea_Minfengsu;
    }

    public String getWea_fengxiang() {
        return wea_fengxiang;
    }

    public void setWea_fengxiang(String wea_fengxiang) {
        this.wea_fengxiang = wea_fengxiang;
    }

    public String getWea_yuliang() {
        return wea_yuliang;
    }

    public void setWea_yuliang(String wea_yuliang) {
        this.wea_yuliang = wea_yuliang;
    }

    public String getWea_houryuling() {
        return wea_houryuling;
    }

    public void setWea_houryuling(String wea_houryuling) {
        this.wea_houryuling = wea_houryuling;
    }

    public String getWea_qiya() {
        return wea_qiya;
    }

    public void setWea_qiya(String wea_qiya) {
        this.wea_qiya = wea_qiya;
    }

    public String getWea_vis() {
        return wea_vis;
    }

    public void setWea_vis(String wea_vis) {
        this.wea_vis = wea_vis;
    }
}
