package com.kingtree.search.entity;


import java.util.Date;

public class TaSystemUser {
    private String uid;

    private String comid;

    private String type;

    private String sex;

    private String username;

    private String password;

    private String chname;

    private String spell;

    private String email;

    private String mobile;

    private String sphone;

    private String adress;

    private String isadmin;

    private String isuse;

    private Date createdate;

    private Date modidate;

    private String flagdeleted;

    private Integer usertype;

    private String device;

    private String userid;

    private String channelid;

    private Boolean flagbind;

    private String sid;

    private String sidtoken;

    private String subid;

    private String subtoken;

    private String butlerstyle;

    private String wxopenid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid == null ? null : comid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getChname() {
        return chname;
    }

    public void setChname(String chname) {
        this.chname = chname == null ? null : chname.trim();
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell == null ? null : spell.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone == null ? null : sphone.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin == null ? null : isadmin.trim();
    }

    public String getIsuse() {
        return isuse;
    }

    public void setIsuse(String isuse) {
        this.isuse = isuse == null ? null : isuse.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getModidate() {
        return modidate;
    }

    public void setModidate(Date modidate) {
        this.modidate = modidate;
    }

    public String getFlagdeleted() {
        return flagdeleted;
    }

    public void setFlagdeleted(String flagdeleted) {
        this.flagdeleted = flagdeleted == null ? null : flagdeleted.trim();
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid == null ? null : channelid.trim();
    }

    public Boolean getFlagbind() {
        return flagbind;
    }

    public void setFlagbind(Boolean flagbind) {
        this.flagbind = flagbind;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSidtoken() {
        return sidtoken;
    }

    public void setSidtoken(String sidtoken) {
        this.sidtoken = sidtoken == null ? null : sidtoken.trim();
    }

    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid == null ? null : subid.trim();
    }

    public String getSubtoken() {
        return subtoken;
    }

    public void setSubtoken(String subtoken) {
        this.subtoken = subtoken == null ? null : subtoken.trim();
    }

    public String getButlerstyle() {
        return butlerstyle;
    }

    public void setButlerstyle(String butlerstyle) {
        this.butlerstyle = butlerstyle == null ? null : butlerstyle.trim();
    }

    public String getWxopenid() {
        return wxopenid;
    }

    public void setWxopenid(String wxopenid) {
        this.wxopenid = wxopenid == null ? null : wxopenid.trim();
    }
}