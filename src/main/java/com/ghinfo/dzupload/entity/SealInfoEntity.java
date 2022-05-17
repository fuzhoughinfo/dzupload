package com.ghinfo.dzupload.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealInfo")
public class SealInfoEntity {
    @Id
    @Column(name = "SealId")
    private String sealid;

    @Column(name = "SealName")
    private String sealname;

    @Column(name = "SealStatusId")
    private String sealstatusid;

    @Column(name = "SealUnitId")
    private String sealunitid;

    @Column(name = "SealSPUnitId")
    private String sealspunitid;

    @Column(name = "SealMKUnitId")
    private String sealmkunitid;

    @Column(name = "SealTypeId")
    private String sealtypeid;

    @Column(name = "SealMaterialId")
    private String sealmaterialid;

    @Column(name = "SealYinYou")
    private String sealyinyou;

    @Column(name = "SealJBR")
    private String sealjbr;

    @Column(name = "SealJBRID")
    private String sealjbrid;

    @Column(name = "SealSP")
    private String sealsp;

    @Column(name = "SealSPDate")
    private String sealspdate;

    @Column(name = "SealCJDate")
    private String sealcjdate;

    @Column(name = "SealMKDate")
    private String sealmkdate;

    @Column(name = "SealJFDate")
    private String sealjfdate;

    @Column(name = "SealBFDate")
    private String sealbfdate;

    @Column(name = "SealJXDate")
    private String sealjxdate;

    @Column(name = "SealGSDate")
    private String sealgsdate;

    @Column(name = "SealNJDate")
    private String sealnjdate;

    @Column(name = "SealImageWidth")
    private String sealimagewidth;

    @Column(name = "SealImageHeight")
    private String sealimageheight;

    @Column(name = "SealImpress")
    private String sealimpress;

    @Column(name = "SealMemo1")
    private String sealmemo1;

    @Column(name = "SealMemo2")
    private String sealmemo2;

    @Column(name = "UpdateDate")
    private String updatedate;

    @Column(name = "SealCJUnitID")
    private String sealcjunitid;

    @Column(name = "CenterImageId")
    private String centerimageid;

    @Column(name = "SealShape")
    private String sealshape;

    @Column(name = "SealSize")
    private String sealsize;

    @Column(name = "JiaJiFlag")
    private String jiajiflag;

    private Integer ctrl;

    @Column(name = "SealMKSendFlag")
    private Integer sealmksendflag;

    @Column(name = "SealJFSendFlag")
    private Integer sealjfsendflag;

    @Column(name = "Source")
    private String source;

    @Column(name = "SealOrderId")
    private String sealorderid;

    @Column(name = "DataFlag")
    private String dataflag;

    @Column(name = "SealChipId")
    private String sealchipid;

    @Column(name = "SealLock")
    private String seallock;

    @Column(name = "SealSampleName")
    private String sealsamplename;

    @Column(name = "SealSpTypeId")
    private String sealsptypeid;
    
    @Column(name = "SealImageData")
    private byte[] sealimagedata;
    
    @Column(name = "SealOriginal")
    private byte[] sealoriginal;

    @Column(name = "SyncProvince")
    private String  syncProvince;


    @Column(name = "SignetId")
    private String  signetId;

    @Column(name = "SyncFile")
    private String  syncFile;

    //补传印模字段
    @Column(name = "SyncImageData")
    private String  Syncimagedata;


    public String getSyncimagedata() {
        return Syncimagedata;
    }

    public void setSyncimagedata(String syncimagedata) {
        Syncimagedata = syncimagedata;
    }

    public String getSyncFile() {
        return syncFile;
    }

    public void setSyncFile(String syncFile) {
        this.syncFile = syncFile;
    }

    public String getSignetId() {
        return signetId;
    }

    public void setSignetId(String signetId) {
        this.signetId = signetId;
    }

    public String getSyncProvince() {
        return syncProvince;
    }

    public void setSyncProvince(String syncProvince) {
        this.syncProvince = syncProvince;
    }



    /**
     * @return SealId
     */
    public String getSealid() {
        return sealid;
    }

    /**
     * @param sealid
     */
    public void setSealid(String sealid) {
        this.sealid = sealid == null ? null : sealid.trim();
    }

    /**
     * @return SealName
     */
    public String getSealname() {
        return sealname;
    }

    /**
     * @param sealname
     */
    public void setSealname(String sealname) {
        this.sealname = sealname == null ? null : sealname.trim();
    }

    /**
     * @return SealStatusId
     */
    public String getSealstatusid() {
        return sealstatusid;
    }

    /**
     * @param sealstatusid
     */
    public void setSealstatusid(String sealstatusid) {
        this.sealstatusid = sealstatusid == null ? null : sealstatusid.trim();
    }

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
     * @return SealSPUnitId
     */
    public String getSealspunitid() {
        return sealspunitid;
    }

    /**
     * @param sealspunitid
     */
    public void setSealspunitid(String sealspunitid) {
        this.sealspunitid = sealspunitid == null ? null : sealspunitid.trim();
    }

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
     * @return SealTypeId
     */
    public String getSealtypeid() {
        return sealtypeid;
    }

    /**
     * @param sealtypeid
     */
    public void setSealtypeid(String sealtypeid) {
        this.sealtypeid = sealtypeid == null ? null : sealtypeid.trim();
    }

    /**
     * @return SealMaterialId
     */
    public String getSealmaterialid() {
        return sealmaterialid;
    }

    /**
     * @param sealmaterialid
     */
    public void setSealmaterialid(String sealmaterialid) {
        this.sealmaterialid = sealmaterialid == null ? null : sealmaterialid.trim();
    }

    /**
     * @return SealYinYou
     */
    public String getSealyinyou() {
        return sealyinyou;
    }

    /**
     * @param sealyinyou
     */
    public void setSealyinyou(String sealyinyou) {
        this.sealyinyou = sealyinyou == null ? null : sealyinyou.trim();
    }

    /**
     * @return SealJBR
     */
    public String getSealjbr() {
        return sealjbr;
    }

    /**
     * @param sealjbr
     */
    public void setSealjbr(String sealjbr) {
        this.sealjbr = sealjbr == null ? null : sealjbr.trim();
    }

    /**
     * @return SealJBRID
     */
    public String getSealjbrid() {
        return sealjbrid;
    }

    /**
     * @param sealjbrid
     */
    public void setSealjbrid(String sealjbrid) {
        this.sealjbrid = sealjbrid == null ? null : sealjbrid.trim();
    }

    /**
     * @return SealSP
     */
    public String getSealsp() {
        return sealsp;
    }

    /**
     * @param sealsp
     */
    public void setSealsp(String sealsp) {
        this.sealsp = sealsp == null ? null : sealsp.trim();
    }

    /**
     * @return SealSPDate
     */
    public String getSealspdate() {
        return sealspdate;
    }

    /**
     * @param sealspdate
     */
    public void setSealspdate(String sealspdate) {
        this.sealspdate = sealspdate == null ? null : sealspdate.trim();
    }

    /**
     * @return SealCJDate
     */
    public String getSealcjdate() {
        return sealcjdate;
    }

    /**
     * @param sealcjdate
     */
    public void setSealcjdate(String sealcjdate) {
        this.sealcjdate = sealcjdate == null ? null : sealcjdate.trim();
    }

    /**
     * @return SealMKDate
     */
    public String getSealmkdate() {
        return sealmkdate;
    }

    /**
     * @param sealmkdate
     */
    public void setSealmkdate(String sealmkdate) {
        this.sealmkdate = sealmkdate == null ? null : sealmkdate.trim();
    }

    /**
     * @return SealJFDate
     */
    public String getSealjfdate() {
        return sealjfdate;
    }

    /**
     * @param sealjfdate
     */
    public void setSealjfdate(String sealjfdate) {
        this.sealjfdate = sealjfdate == null ? null : sealjfdate.trim();
    }

    /**
     * @return SealBFDate
     */
    public String getSealbfdate() {
        return sealbfdate;
    }

    /**
     * @param sealbfdate
     */
    public void setSealbfdate(String sealbfdate) {
        this.sealbfdate = sealbfdate == null ? null : sealbfdate.trim();
    }

    /**
     * @return SealJXDate
     */
    public String getSealjxdate() {
        return sealjxdate;
    }

    /**
     * @param sealjxdate
     */
    public void setSealjxdate(String sealjxdate) {
        this.sealjxdate = sealjxdate == null ? null : sealjxdate.trim();
    }

    /**
     * @return SealGSDate
     */
    public String getSealgsdate() {
        return sealgsdate;
    }

    /**
     * @param sealgsdate
     */
    public void setSealgsdate(String sealgsdate) {
        this.sealgsdate = sealgsdate == null ? null : sealgsdate.trim();
    }

    /**
     * @return SealNJDate
     */
    public String getSealnjdate() {
        return sealnjdate;
    }

    /**
     * @param sealnjdate
     */
    public void setSealnjdate(String sealnjdate) {
        this.sealnjdate = sealnjdate == null ? null : sealnjdate.trim();
    }

    /**
     * @return SealImageWidth
     */
    public String getSealimagewidth() {
        return sealimagewidth;
    }

    /**
     * @param sealimagewidth
     */
    public void setSealimagewidth(String sealimagewidth) {
        this.sealimagewidth = sealimagewidth == null ? null : sealimagewidth.trim();
    }

    /**
     * @return SealImageHeight
     */
    public String getSealimageheight() {
        return sealimageheight;
    }

    /**
     * @param sealimageheight
     */
    public void setSealimageheight(String sealimageheight) {
        this.sealimageheight = sealimageheight == null ? null : sealimageheight.trim();
    }

    /**
     * @return SealImpress
     */
    public String getSealimpress() {
        return sealimpress;
    }

    /**
     * @param sealimpress
     */
    public void setSealimpress(String sealimpress) {
        this.sealimpress = sealimpress == null ? null : sealimpress.trim();
    }

    /**
     * @return SealMemo1
     */
    public String getSealmemo1() {
        return sealmemo1;
    }

    /**
     * @param sealmemo1
     */
    public void setSealmemo1(String sealmemo1) {
        this.sealmemo1 = sealmemo1 == null ? null : sealmemo1.trim();
    }

    /**
     * @return SealMemo2
     */
    public String getSealmemo2() {
        return sealmemo2;
    }

    /**
     * @param sealmemo2
     */
    public void setSealmemo2(String sealmemo2) {
        this.sealmemo2 = sealmemo2 == null ? null : sealmemo2.trim();
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
     * @return SealCJUnitID
     */
    public String getSealcjunitid() {
        return sealcjunitid;
    }

    /**
     * @param sealcjunitid
     */
    public void setSealcjunitid(String sealcjunitid) {
        this.sealcjunitid = sealcjunitid == null ? null : sealcjunitid.trim();
    }

    /**
     * @return CenterImageId
     */
    public String getCenterimageid() {
        return centerimageid;
    }

    /**
     * @param centerimageid
     */
    public void setCenterimageid(String centerimageid) {
        this.centerimageid = centerimageid == null ? null : centerimageid.trim();
    }

    /**
     * @return SealShape
     */
    public String getSealshape() {
        return sealshape;
    }

    /**
     * @param sealshape
     */
    public void setSealshape(String sealshape) {
        this.sealshape = sealshape == null ? null : sealshape.trim();
    }

    /**
     * @return SealSize
     */
    public String getSealsize() {
        return sealsize;
    }

    /**
     * @param sealsize
     */
    public void setSealsize(String sealsize) {
        this.sealsize = sealsize == null ? null : sealsize.trim();
    }

    /**
     * @return JiaJiFlag
     */
    public String getJiajiflag() {
        return jiajiflag;
    }

    /**
     * @param jiajiflag
     */
    public void setJiajiflag(String jiajiflag) {
        this.jiajiflag = jiajiflag == null ? null : jiajiflag.trim();
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
     * @return SealMKSendFlag
     */
    public Integer getSealmksendflag() {
        return sealmksendflag;
    }

    /**
     * @param sealmksendflag
     */
    public void setSealmksendflag(Integer sealmksendflag) {
        this.sealmksendflag = sealmksendflag;
    }

    /**
     * @return SealJFSendFlag
     */
    public Integer getSealjfsendflag() {
        return sealjfsendflag;
    }

    /**
     * @param sealjfsendflag
     */
    public void setSealjfsendflag(Integer sealjfsendflag) {
        this.sealjfsendflag = sealjfsendflag;
    }

    /**
     * @return Source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * @return SealOrderId
     */
    public String getSealorderid() {
        return sealorderid;
    }

    /**
     * @param sealorderid
     */
    public void setSealorderid(String sealorderid) {
        this.sealorderid = sealorderid == null ? null : sealorderid.trim();
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
     * @return SealChipId
     */
    public String getSealchipid() {
        return sealchipid;
    }

    /**
     * @param sealchipid
     */
    public void setSealchipid(String sealchipid) {
        this.sealchipid = sealchipid == null ? null : sealchipid.trim();
    }

    /**
     * @return SealLock
     */
    public String getSeallock() {
        return seallock;
    }

    /**
     * @param seallock
     */
    public void setSeallock(String seallock) {
        this.seallock = seallock == null ? null : seallock.trim();
    }

    /**
     * @return SealSampleName
     */
    public String getSealsamplename() {
        return sealsamplename;
    }

    /**
     * @param sealsamplename
     */
    public void setSealsamplename(String sealsamplename) {
        this.sealsamplename = sealsamplename == null ? null : sealsamplename.trim();
    }

    /**
     * @return SealSpTypeId
     */
    public String getSealsptypeid() {
        return sealsptypeid;
    }

    /**
     * @param sealsptypeid
     */
    public void setSealsptypeid(String sealsptypeid) {
        this.sealsptypeid = sealsptypeid == null ? null : sealsptypeid.trim();
    }
    

    /**
     * @return SealImageData
     */
    public byte[] getSealimagedata() {
        return sealimagedata;
    }

    /**
     * @param sealimagedata
     */
    public void setSealimagedata(byte[] sealimagedata) {
        this.sealimagedata = sealimagedata;
    }


    /**
     * @return SealOriginal
     */
    public byte[] getSealoriginal() {
        return sealoriginal;
    }

    /**
     * @param sealoriginal
     */
    public void setSealoriginal(byte[] sealoriginal) {
        this.sealoriginal = sealoriginal;
    }
}