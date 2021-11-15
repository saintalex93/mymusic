package com.cristine.mymusic.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class AudioFile implements Serializable {

    private static final long serialVersionUID = 23432432435424341L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String fileName;
    private byte[] file;

    public AudioFile() {
    }

    public AudioFile(Integer id, String fileName, byte[] file) {
        this.id = id;
        this.fileName = fileName;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public byte[] getFile() {
        return file;
    }
}
