package com.ghinfo.dzupload.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealOrder")
public class SealOrderEntity {
    @Id
    @Column(name = "SealOrderId")
    private String sealorderid;

    @Column(name = "SealUnitId")
    private String sealunitid;

    @Column(name = "OrderPrice")
    private Double orderprice;

    @Column(name = "OrderPayStatus")
    private String orderpaystatus;

    @Column(name = "CreateTime")
    private String createtime;

    @Column(name = "PayTime")
    private String paytime;

    @Column(name = "PayType")
    private String paytype;

    @Column(name = "PayOrder")
    private String payorder;

    @Column(name = "PayFileId")
    private String payfileid;

    @Column(name = "OrderStatus")
    private String orderstatus;

    @Column(name = "FailReason")
    private String failreason;

    @Column(name = "ContactName")
    private String contactname;

    @Column(name = "ContactPhone")
    private String contactphone;

    @Column(name = "ContactAddress")
    private String contactaddress;

    @Column(name = "CreateUnitId")
    private String createunitid;

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
     * @return OrderPrice
     */
    public Double getOrderprice() {
        return orderprice;
    }

    /**
     * @param orderprice
     */
    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    /**
     * @return OrderPayStatus
     */
    public String getOrderpaystatus() {
        return orderpaystatus;
    }

    /**
     * @param orderpaystatus
     */
    public void setOrderpaystatus(String orderpaystatus) {
        this.orderpaystatus = orderpaystatus == null ? null : orderpaystatus.trim();
    }

    /**
     * @return CreateTime
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    /**
     * @return PayTime
     */
    public String getPaytime() {
        return paytime;
    }

    /**
     * @param paytime
     */
    public void setPaytime(String paytime) {
        this.paytime = paytime == null ? null : paytime.trim();
    }

    /**
     * @return PayType
     */
    public String getPaytype() {
        return paytype;
    }

    /**
     * @param paytype
     */
    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    /**
     * @return PayOrder
     */
    public String getPayorder() {
        return payorder;
    }

    /**
     * @param payorder
     */
    public void setPayorder(String payorder) {
        this.payorder = payorder == null ? null : payorder.trim();
    }

    /**
     * @return PayFileId
     */
    public String getPayfileid() {
        return payfileid;
    }

    /**
     * @param payfileid
     */
    public void setPayfileid(String payfileid) {
        this.payfileid = payfileid == null ? null : payfileid.trim();
    }

    /**
     * @return OrderStatus
     */
    public String getOrderstatus() {
        return orderstatus;
    }

    /**
     * @param orderstatus
     */
    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
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
     * @return ContactName
     */
    public String getContactname() {
        return contactname;
    }

    /**
     * @param contactname
     */
    public void setContactname(String contactname) {
        this.contactname = contactname == null ? null : contactname.trim();
    }

    /**
     * @return ContactPhone
     */
    public String getContactphone() {
        return contactphone;
    }

    /**
     * @param contactphone
     */
    public void setContactphone(String contactphone) {
        this.contactphone = contactphone == null ? null : contactphone.trim();
    }

    /**
     * @return ContactAddress
     */
    public String getContactaddress() {
        return contactaddress;
    }

    /**
     * @param contactaddress
     */
    public void setContactaddress(String contactaddress) {
        this.contactaddress = contactaddress == null ? null : contactaddress.trim();
    }

    /**
     * @return CreateUnitId
     */
    public String getCreateunitid() {
        return createunitid;
    }

    /**
     * @param createunitid
     */
    public void setCreateunitid(String createunitid) {
        this.createunitid = createunitid == null ? null : createunitid.trim();
    }

}