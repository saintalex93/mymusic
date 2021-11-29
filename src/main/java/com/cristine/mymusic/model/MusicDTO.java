package com.cristine.mymusic.model;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.Column;
import java.io.*;

public class MusicDTO implements Serializable {

    private String name;
    private String author;
    private MultipartFile file;

    public MusicDTO(String name, String author, MultipartFile file) {
        this.name = name;
        this.author = author;
        this.file = file;
    }

//    public MusicDTO(Music music) {
//        this.name = music.getName();
//        this.author = music.getAuthor();
//        try {
//            this.file = transferTo(File.createTempFile("", ""));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public MultipartFile transferTo(File dest) throws IOException {
        FileOutputStream f = new FileOutputStream(dest);
        f.write(this.file.getBytes());
        return this.file;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public MultipartFile getFile() {
        return file;
    }

}
