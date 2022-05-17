package com.ghinfo.dzupload.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SealFile")
public class SealFileEntity {
    @Id
    @Column(name = "FileId")
    private String fileid;

    @Column(name = "FileName")
    private String filename;

    @Column(name = "FilePath")
    private String filepath;

    @Column(name = "SyncDb")
    private String syncDb;

    public String getSyncDb() {
        return syncDb;
    }

    public void setSyncDb(String syncDb) {
        this.syncDb = syncDb;
    }

    //    @Column(name = "SyncProvince")
//    private String SyncProvince;
//
//    public String getSyncProvince() {
//        return SyncProvince;
//    }
//
//    public void setSyncProvince(String syncProvince) {
//        SyncProvince = syncProvince;
//    }

    /**
     * @return FileId
     */
    public String getFileid() {
        return fileid;
    }

    /**
     * @param fileid
     */
    public void setFileid(String fileid) {
        this.fileid = fileid == null ? null : fileid.trim();
    }

    /**
     * @return FileName
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    /**
     * @return FilePath
     */
    public String getFilepath() {
        return filepath;
    }

    /**
     * @param filepath
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }
}