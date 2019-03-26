package com.example.dna.entity;

import com.example.dna.controller.upLoadFile;

import java.sql.Date;

/**
 * @program: dna
 * @description:
 * @author: XL
 * @create: 2019-03-26 16:16
 **/

public class fileLists {
    private String fileName;
    private String fileSize;
    private Date date;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
