package com.ghinfo.dzupload.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealFileRecord")
public class SealFileRecordEntity {
    @Id
    @Column(name = "SealFileRecordId")
    private int sealFileRecordId;

    @Column(name = "SealUnitId")
    private String sealUnitId;

    @Column(name = "SealUnitName")
    private String sealUnitName;

    @Column(name = "FileId")
    private String fileId;

    @Column(name = "FileName")
    private String fileName;

    @Column(name = "FilePath")
    private String filePath;

    @Column(name = "FileBase")
    private String fileBase;

    public int getSealFileRecordId() {
        return sealFileRecordId;
    }

    public void setSealFileRecordId(int sealFileRecordId) {
        this.sealFileRecordId = sealFileRecordId;
    }

    public String getSealUnitId() {
        return sealUnitId;
    }

    public void setSealUnitId(String sealUnitId) {
        this.sealUnitId = sealUnitId;
    }

    public String getSealUnitName() {
        return sealUnitName;
    }

    public void setSealUnitName(String sealUnitName) {
        this.sealUnitName = sealUnitName;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileBase() {
        return fileBase;
    }

    public void setFileBase(String fileBase) {
        this.fileBase = fileBase;
    }
}
