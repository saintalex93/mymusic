package com.cristine.mymusic.services;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    public User find(String user);
    public User save(User user);
    public void saveFile(MultipartFile file);
    public User update(User user);
    public List<Music> findAllMusic(String username);
}
