package com.ghinfo.dzupload.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealMKUnit")
public class SealMKUnitEntity {
    @Id
    @Column(name = "SealMKUnitId")
    private String sealmkunitid;

    @Column(name = "MKUnitName")
    private String mkunitname;

    @Column(name = "MKUnitNameSSMZ")
    private String mkunitnamessmz;

    @Column(name = "MKUnitNameEN")
    private String mkunitnameen;

    @Column(name = "MKLegalRY")
    private String mklegalry;

    @Column(name = "MKLegalRYID")
    private String mklegalryid;

    @Column(name = "MKUnitAddress")
    private String mkunitaddress;

    @Column(name = "MKUnitTel")
    private String mkunittel;

    @Column(name = "MKUnitPostalCode")
    private String mkunitpostalcode;

    @Column(name = "UpdateDate")
    private String updatedate;

    @Column(name = "SPFlag")
    private String spflag;

    @Column(name = "PayFlag")
    private String payflag;

    @Column(name = "AliPayUrl")
    private String alipayurl;

    @Column(name = "WxPayUrl")
    private String wxpayurl;

    @Column(name = "MKUntis")
    private String mkuntis;

    @Column(name = "LockMachine")
    private String lockmachine;

    @Column(name = "MachineID")
    private String machineid;

//    @Column(name = "AreaName")
//    private String areaName;
//
//    @Column(name = "AreaCode")
//    private String areaCode;
//
//    @Column(name = "MKStatus")
//    private String mkStatus;
//
//    @Column(name = "CreateTime")
//    private String createTime;
//
//    @Column(name = "Regnunit")
//    private String regnunit;
//
//    @Column(name = "MKThzdm")
//    private String mkThzdm;
//
//    @Column(name = "MKUnitLicnum")
//    private String mkUnitLicnum;
//
//    @Column(name = "SyncProvince")
//    private String syncProvince;
//
//    @Column(name = "SyncAccount")
//    private String syncAccount;
//
//    @Column(name = "SyncShop")
//    private String syncShop;

//    public String getSyncAccount() {
//        return syncAccount;
//    }
//
//    public void setSyncAccount(String syncAccount) {
//        this.syncAccount = syncAccount;
//    }
//
//    public String getSyncShop() {
//        return syncShop;
//    }
//
//    public void setSyncShop(String syncShop) {
//        this.syncShop = syncShop;
//    }
//
//    public String getAreaName() {
//        return areaName;
//    }
//
//    public void setAreaName(String areaName) {
//        this.areaName = areaName;
//    }
//
//    public String getAreaCode() {
//        return areaCode;
//    }
//
//    public void setAreaCode(String areaCode) {
//        this.areaCode = areaCode;
//    }
//
//    public String getMkStatus() {
//        return mkStatus;
//    }
//
//    public void setMkStatus(String mkStatus) {
//        this.mkStatus = mkStatus;
//    }
//
//    public String getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(String createTime) {
//        this.createTime = createTime;
//    }
//
//    public String getRegnunit() {
//        return regnunit;
//    }
//
//    public void setRegnunit(String regnunit) {
//        this.regnunit = regnunit;
//    }
//
//    public String getMkThzdm() {
//        return mkThzdm;
//    }
//
//    public void setMkThzdm(String mkThzdm) {
//        this.mkThzdm = mkThzdm;
//    }
//
//    public String getMkUnitLicnum() {
//        return mkUnitLicnum;
//    }
//
//    public void setMkUnitLicnum(String mkUnitLicnum) {
//        this.mkUnitLicnum = mkUnitLicnum;
//    }
//
//    public String getSyncProvince() {
//        return syncProvince;
//    }
//
//    public void setSyncProvince(String syncProvince) {
//        this.syncProvince = syncProvince;
//    }

    /**
     * @return SealMKUnitId
     */
    public String getSealmkunitid() {
        return sealmkunitid;
    }

    /**
     * @param sealmkunitid
     */
    public void setSealmkunitid(String sealmkunitid) {
        this.sealmkunitid = sealmkunitid == null ? null : sealmkunitid.trim();
    }

    /**
     * @return MKUnitName
     */
    public String getMkunitname() {
        return mkunitname;
    }

    /**
     * @param mkunitname
     */
    public void setMkunitname(String mkunitname) {
        this.mkunitname = mkunitname == null ? null : mkunitname.trim();
    }

    /**
     * @return MKUnitNameSSMZ
     */
    public String getMkunitnamessmz() {
        return mkunitnamessmz;
    }

    /**
     * @param mkunitnamessmz
     */
    public void setMkunitnamessmz(String mkunitnamessmz) {
        this.mkunitnamessmz = mkunitnamessmz == null ? null : mkunitnamessmz.trim();
    }

    /**
     * @return MKUnitNameEN
     */
    public String getMkunitnameen() {
        return mkunitnameen;
    }

    /**
     * @param mkunitnameen
     */
    public void setMkunitnameen(String mkunitnameen) {
        this.mkunitnameen = mkunitnameen == null ? null : mkunitnameen.trim();
    }

    /**
     * @return MKLegalRY
     */
    public String getMklegalry() {
        return mklegalry;
    }

    /**
     * @param mklegalry
     */
    public void setMklegalry(String mklegalry) {
        this.mklegalry = mklegalry == null ? null : mklegalry.trim();
    }

    /**
     * @return MKLegalRYID
     */
    public String getMklegalryid() {
        return mklegalryid;
    }

    /**
     * @param mklegalryid
     */
    public void setMklegalryid(String mklegalryid) {
        this.mklegalryid = mklegalryid == null ? null : mklegalryid.trim();
    }

    /**
     * @return MKUnitAddress
     */
    public String getMkunitaddress() {
        return mkunitaddress;
    }

    /**
     * @param mkunitaddress
     */
    public void setMkunitaddress(String mkunitaddress) {
        this.mkunitaddress = mkunitaddress == null ? null : mkunitaddress.trim();
    }

    /**
     * @return MKUnitTel
     */
    public String getMkunittel() {
        return mkunittel;
    }

    /**
     * @param mkunittel
     */
    public void setMkunittel(String mkunittel) {
        this.mkunittel = mkunittel == null ? null : mkunittel.trim();
    }

    /**
     * @return MKUnitPostalCode
     */
    public String getMkunitpostalcode() {
        return mkunitpostalcode;
    }

    /**
     * @param mkunitpostalcode
     */
    public void setMkunitpostalcode(String mkunitpostalcode) {
        this.mkunitpostalcode = mkunitpostalcode == null ? null : mkunitpostalcode.trim();
    }

    /**
     * @return UpdateDate
     */
    public String getUpdatedate() {
        return updatedate;
    }

    /**
     * @param updatedate
     */
    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }

    /**
     * @return SPFlag
     */
    public String getSpflag() {
        return spflag;
    }

    /**
     * @param spflag
     */
    public void setSpflag(String spflag) {
        this.spflag = spflag == null ? null : spflag.trim();
    }

    /**
     * @return PayFlag
     */
    public String getPayflag() {
        return payflag;
    }

    /**
     * @param payflag
     */
    public void setPayflag(String payflag) {
        this.payflag = payflag == null ? null : payflag.trim();
    }

    /**
     * @return AliPayUrl
     */
    public String getAlipayurl() {
        return alipayurl;
    }

    /**
     * @param alipayurl
     */
    public void setAlipayurl(String alipayurl) {
        this.alipayurl = alipayurl == null ? null : alipayurl.trim();
    }

    /**
     * @return WxPayUrl
     */
    public String getWxpayurl() {
        return wxpayurl;
    }

    /**
     * @param wxpayurl
     */
    public void setWxpayurl(String wxpayurl) {
        this.wxpayurl = wxpayurl == null ? null : wxpayurl.trim();
    }

    /**
     * @return MKUntis
     */
    public String getMkuntis() {
        return mkuntis;
    }

    /**
     * @param mkuntis
     */
    public void setMkuntis(String mkuntis) {
        this.mkuntis = mkuntis == null ? null : mkuntis.trim();
    }

    /**
     * @return LockMachine
     */
    public String getLockmachine() {
        return lockmachine;
    }

    /**
     * @param lockmachine
     */
    public void setLockmachine(String lockmachine) {
        this.lockmachine = lockmachine == null ? null : lockmachine.trim();
    }

    /**
     * @return MachineID
     */
    public String getMachineid() {
        return machineid;
    }

    /**
     * @param machineid
     */
    public void setMachineid(String machineid) {
        this.machineid = machineid == null ? null : machineid.trim();
    }

}