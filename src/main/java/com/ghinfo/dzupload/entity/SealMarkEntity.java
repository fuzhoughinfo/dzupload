package com.ghinfo.dzupload.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;



public class SealMarkEntity implements Serializable {



    @JSONField(name = "Timestamp")
    private Long Timestamp;

    @JSONField(name = "Sign")
    private String Sign;

    @JSONField(name = "signetId")
    private String signetId;

    @JSONField(name = "markBase64Str")
    private String markBase64Str;

    @JSONField(name = "VerifyUserID")
    private String verifyUserID;

    @JSONField(name = "VerifyPsd")
    private String verifyPsd;


    public Long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(Long timestamp) {
        Timestamp = timestamp;
    }

    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }

    public String getSignetId() {
        return signetId;
    }

    public void setSignetId(String signetId) {
        this.signetId = signetId;
    }

    public String getMarkBase64Str() {
        return markBase64Str;
    }

    public void setMarkBase64Str(String markBase64Str) {
        this.markBase64Str = markBase64Str;
    }

    public String getVerifyUserID() {
        return verifyUserID;
    }

    public void setVerifyUserID(String verifyUserID) {
        this.verifyUserID = verifyUserID;
    }

    public String getVerifyPsd() {
        return verifyPsd;
    }

    public void setVerifyPsd(String verifyPsd) {
        this.verifyPsd = verifyPsd;
    }
}
