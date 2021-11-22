package com.cristine.mymusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "uk_music_name", columnNames = { "name" }) })
public class Music implements Serializable {

    private static final long serialVersionUID = 23432432432424341L;

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "music_seq", sequenceName = "music_seq")
    private Integer id;
    @Column(nullable = false)
    private String name;
    private String author;
    private Date date;
    private String fileName;
    private File file;

    public Music() {
    }

    public Music(Integer id, String name, String author, Date date, String fileName, File file) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.date = date;
        this.fileName = fileName;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return file;
    }
}
