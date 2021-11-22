package com.cristine.mymusic.controller;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.model.User;
import com.cristine.mymusic.services.MusicService;
import com.cristine.mymusic.services.UserService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mymusic")
@CrossOrigin("http://localhost:4200")
public class MyMusicController {

    @Autowired
    private UserService userService;
    @Autowired
    private MusicService musicService;

    @GetMapping
    public User get(@RequestParam String username) {

        return userService.find(username);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping(path = "/music", consumes = "multipart/form-data")
    public void saveMusic(@ModelAttribute Music music) {
        userService.saveFile(music);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping(path = "/musics/{username}")
    public List<Music> getAll(@PathVariable String username) {
        return userService.findAllMusic(username);
    }

    @PutMapping(path = "/musics")
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