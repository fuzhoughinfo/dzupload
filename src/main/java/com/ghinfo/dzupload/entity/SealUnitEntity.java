package com.ghinfo.dzupload.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealUnit")
public class SealUnitEntity {
    @Id
    @Column(name = "SealUnitId")
    private String sealunitid;

    @Column(name = "UnitName")
    private String unitname;

    @Column(name = "UnitNameSSMZ")
    private String unitnamessmz;

    @Column(name = "UnitNameEN")
    private String unitnameen;

    @Column(name = "SealUnitTypeID")
    private String sealunittypeid;

    @Column(name = "VoicePAS")
    private String voicepas;

    @Column(name = "LegalRY")
    private String legalry;

    @Column(name = "LegalRYID")
    private String legalryid;

    @Column(name = "UnitAddress")
    private String unitaddress;

    @Column(name = "UnitTel")
    private String unittel;

    @Column(name = "UnitPostalCode")
    private String unitpostalcode;

    @Column(name = "UpdateDate")
    private String updatedate;

    private Integer ctrl;

    @Column(name = "SealUnitTypeDetail")
    private String sealunittypedetail;

    @Column(name = "UnitCode")
    private String unitcode;

    @Column(name = "UnitPwd")
    private String unitpwd;

    @Column(name = "MessagePhone")
    private String messagephone;

    @Column(name = "JBR")
    private String jbr;

    @Column(name = "JBRId")
    private String jbrid;

    @Column(name = "JBRTel")
    private String jbrtel;

    @Column(name = "LegalRYTel")
    private String legalrytel;

    @Column(name = "LicenseFileId")
    private String licensefileid;

    @Column(name = "JBRFileId")
    private String jbrfileid;

    @Column(name = "OtherFileId")
    private String otherfileid;

    @Column(name = "UnitStatus")
    private String unitstatus;

    @Column(name = "FailReason")
    private String failreason;

    @Column(name = "AppealStatus")
    private String appealstatus;

    @Column(name = "AppealFailReason")
    private String appealfailreason;

    @Column(name = "DataFlag")
    private String dataflag;

    @Column(name = "MessagePhoneTemp")
    private String messagephonetemp;

    /**
     * @return SealUnitId
     */
    public String getSealunitid() {
        return sealunitid;
    }

    /**
     * @param sealunitid
     */
    public void setSealunitid(String sealunitid) {
        this.sealunitid = sealunitid == null ? null : sealunitid.trim();
    }

    /**
     * @return UnitName
     */
    public String getUnitname() {
        return unitname;
    }

    /**
     * @param unitname
     */
    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    /**
     * @return UnitNameSSMZ
     */
    public String getUnitnamessmz() {
        return unitnamessmz;
    }

    /**
     * @param unitnamessmz
     */
    public void setUnitnamessmz(String unitnamessmz) {
        this.unitnamessmz = unitnamessmz == null ? null : unitnamessmz.trim();
    }

    /**
     * @return UnitNameEN
     */
    public String getUnitnameen() {
        return unitnameen;
    }

    /**
     * @param unitnameen
     */
    public void setUnitnameen(String unitnameen) {
        this.unitnameen = unitnameen == null ? null : unitnameen.trim();
    }

    /**
     * @return SealUnitTypeID
     */
    public String getSealunittypeid() {
        return sealunittypeid;
    }

    /**
     * @param sealunittypeid
     */
    public void setSealunittypeid(String sealunittypeid) {
        this.sealunittypeid = sealunittypeid == null ? null : sealunittypeid.trim();
    }

    /**
     * @return VoicePAS
     */
    public String getVoicepas() {
        return voicepas;
    }

    /**
     * @param voicepas
     */
    public void setVoicepas(String voicepas) {
        this.voicepas = voicepas == null ? null : voicepas.trim();
    }

    /**
     * @return LegalRY
     */
    public String getLegalry() {
        return legalry;
    }

    /**
     * @param legalry
     */
    public void setLegalry(String legalry) {
        this.legalry = legalry == null ? null : legalry.trim();
    }

    /**
     * @return LegalRYID
     */
    public String getLegalryid() {
        return legalryid;
    }

    /**
     * @param legalryid
     */
    public void setLegalryid(String legalryid) {
        this.legalryid = legalryid == null ? null : legalryid.trim();
    }

    /**
     * @return UnitAddress
     */
    public String getUnitaddress() {
        return unitaddress;
    }

    /**
     * @param unitaddress
     */
    public void setUnitaddress(String unitaddress) {
        this.unitaddress = unitaddress == null ? null : unitaddress.trim();
    }

    /**
     * @return UnitTel
     */
    public String getUnittel() {
        return unittel;
    }

    /**
     * @param unittel
     */
    public void setUnittel(String unittel) {
        this.unittel = unittel == null ? null : unittel.trim();
    }

    /**
     * @return UnitPostalCode
     */
    public String getUnitpostalcode() {
        return unitpostalcode;
    }

    /**
     * @param unitpostalcode
     */
    public void setUnitpostalcode(String unitpostalcode) {
        this.unitpostalcode = unitpostalcode == null ? null : unitpostalcode.trim();
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
     * @return ctrl
     */
    public Integer getCtrl() {
        return ctrl;
    }

    /**
     * @param ctrl
     */
    public void setCtrl(Integer ctrl) {
        this.ctrl = ctrl;
    }

    /**
     * @return SealUnitTypeDetail
     */
    public String getSealunittypedetail() {
        return sealunittypedetail;
    }

    /**
     * @param sealunittypedetail
     */
    public void setSealunittypedetail(String sealunittypedetail) {
        this.sealunittypedetail = sealunittypedetail == null ? null : sealunittypedetail.trim();
    }

    /**
     * @return UnitCode
     */
    public String getUnitcode() {
        return unitcode;
    }

    /**
     * @param unitcode
     */
    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode == null ? null : unitcode.trim();
    }

    /**
     * @return UnitPwd
     */
    public String getUnitpwd() {
        return unitpwd;
    }

    /**
     * @param unitpwd
     */
    public void setUnitpwd(String unitpwd) {
        this.unitpwd = unitpwd == null ? null : unitpwd.trim();
    }

    /**
     * @return MessagePhone
     */
    public String getMessagephone() {
        return messagephone;
    }

    /**
     * @param messagephone
     */
    public void setMessagephone(String messagephone) {
        this.messagephone = messagephone == null ? null : messagephone.trim();
    }

    /**
     * @return JBR
     */
    public String getJbr() {
        return jbr;
    }

    /**
     * @param jbr
     */
    public void setJbr(String jbr) {
        this.jbr = jbr == null ? null : jbr.trim();
    }

    /**
     * @return JBRId
     */
    public String getJbrid() {
        return jbrid;
    }

    /**
     * @param jbrid
     */
    public void setJbrid(String jbrid) {
        this.jbrid = jbrid == null ? null : jbrid.trim();
    }

    /**
     * @return JBRTel
     */
    public String getJbrtel() {
        return jbrtel;
    }

    /**
     * @param jbrtel
     */
    public void setJbrtel(String jbrtel) {
        this.jbrtel = jbrtel == null ? null : jbrtel.trim();
    }

    /**
     * @return LegalRYTel
     */
    public String getLegalrytel() {
        return legalrytel;
    }

    /**
     * @param legalrytel
     */
    public void setLegalrytel(String legalrytel) {
        this.legalrytel = legalrytel == null ? null : legalrytel.trim();
    }

    /**
     * @return LicenseFileId
     */
    public String getLicensefileid() {
        return licensefileid;
    }

    /**
     * @param licensefileid
     */
    public void setLicensefileid(String licensefileid) {
        this.licensefileid = licensefileid == null ? null : licensefileid.trim();
    }

    /**
     * @return JBRFileId
     */
    public String getJbrfileid() {
        return jbrfileid;
    }

    /**
     * @param jbrfileid
     */
    public void setJbrfileid(String jbrfileid) {
        this.jbrfileid = jbrfileid == null ? null : jbrfileid.trim();
    }

    /**
     * @return OtherFileId
     */
    public String getOtherfileid() {
        return otherfileid;
    }

    /**
     * @param otherfileid
     */
    public void setOtherfileid(String otherfileid) {
        this.otherfileid = otherfileid == null ? null : otherfileid.trim();
    }

    /**
     * @return UnitStatus
     */
    public String getUnitstatus() {
        return unitstatus;
    }

    /**
     * @param unitstatus
     */
    public void setUnitstatus(String unitstatus) {
        this.unitstatus = unitstatus == null ? null : unitstatus.trim();
    }

    /**
     * @return FailReason
     */
    public String getFailreason() {
        return failreason;
    }

    /**
     * @param failreason
     */
    public void setFailreason(String failreason) {
        this.failreason = failreason == null ? null : failreason.trim();
    }

    /**
     * @return AppealStatus
     */
    public String getAppealstatus() {
        return appealstatus;
    }

    /**
     * @param appealstatus
     */
    public void setAppealstatus(String appealstatus) {
        this.appealstatus = appealstatus == null ? null : appealstatus.trim();
    }

    /**
     * @return AppealFailReason
     */
    public String getAppealfailreason() {
        return appealfailreason;
    }

    /**
     * @param appealfailreason
     */
    public void setAppealfailreason(String appealfailreason) {
        this.appealfailreason = appealfailreason == null ? null : appealfailreason.trim();
    }

    /**
     * @return DataFlag
     */
    public String getDataflag() {
        return dataflag;
    }

    /**
     * @param dataflag
     */
    public void setDataflag(String dataflag) {
        this.dataflag = dataflag == null ? null : dataflag.trim();
    }

    /**
     * @return MessagePhoneTemp
     */
    public String getMessagephonetemp() {
        return messagephonetemp;
    }

    /**
     * @param messagephonetemp
     */
    public void setMessagephonetemp(String messagephonetemp) {
        this.messagephonetemp = messagephonetemp == null ? null : messagephonetemp.trim();
    }
}