package com.cristine.mymusic.controller;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/mymusic")
public class MyMusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public String getAll() {
        return "Oeee";
    }


    @PutMapping
    public void save(@RequestBody Music music) throws IOException {
        musicService.save(music);
    }
}
//        InputStream initialStream = new FileInputStream(
//                "src/main/resources/sample.txt");
//        byte[] buffer = new byte[initialStream.available()];
//        initialStream.read(buffer);
//
//        File targetFile = new File("src/main/resources/targetFile.tmp");
//        Files.write(buffer, targetFile);