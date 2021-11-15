package com.cristine.mymusic.model;

import javax.persistence.*;
import javax.sound.sampled.AudioInputStream;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Music implements Serializable {

    private static final long serialVersionUID = 23432432432424341L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String name;
    private String author;
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    private AudioFile musicFile;

    public Music() {
    }

    public Music(Integer id, String name, String author, Date date, AudioFile musicFile) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.date = date;
        this.musicFile = musicFile;
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

    public AudioFile getMusicFile() {
        return musicFile;
    }
}
