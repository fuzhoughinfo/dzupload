package com.ghinfo.dzupload.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealCenterImage")
public class SealCenterImageEntity {
    @Id
    @Column(name = "CenterImageId")
    private String centerimageid;

    @Column(name = "CenterImage")
    private String centerimage;

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
     * @return CenterImage
     */
    public String getCenterimage() {
        return centerimage;
    }

    /**
     * @param centerimage
     */
    public void setCenterimage(String centerimage) {
        this.centerimage = centerimage == null ? null : centerimage.trim();
    }
}