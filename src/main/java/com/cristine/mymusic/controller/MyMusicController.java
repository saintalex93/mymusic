package com.cristine.mymusic.controller;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.model.MusicDTO;
import com.cristine.mymusic.services.MusicService;
import com.cristine.mymusic.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mymusic")
public class MyMusicController {

    @Autowired
    private UserService userService;
    @Autowired
    private MusicService musicService;

    @PostMapping(path = "/music", consumes = "multipart/form-data")
    public void saveMusic(@NonNull @ModelAttribute MusicDTO musicDTO) throws IOException {
        Music music = new Music(musicDTO.getName(), musicDTO.getAuthor(), musicDTO.getFile().getBytes());
        userService.saveFile(music);
    }

    @GetMapping
    public List<Music> getMusic() throws IOException {
        return musicService.findAll();
    }

    @GetMapping(path = "/musics/{username}")
    public List<Music> getAll(@PathVariable String username) {
        return userService.findAllMusic(username);
    }

}
//        InputStream initialStream = new FileInputStream(
//                "src/main/resources/sample.txt");
//        byte[] buffer = new byte[initialStream.available()];
//        initialStream.read(buffer);
//
//        File targetFile = new File("src/main/resources/targetFile.tmp");
//        Files.write(buffer, targetFile);