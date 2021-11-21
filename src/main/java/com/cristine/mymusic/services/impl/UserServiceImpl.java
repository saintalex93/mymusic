package com.cristine.mymusic.services.impl;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.model.User;
import com.cristine.mymusic.repository.MusicRepository;
import com.cristine.mymusic.repository.UserRepository;
import com.cristine.mymusic.services.UserService;
import com.google.common.collect.ImmutableList;
import org.hibernate.annotations.Immutable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public User find(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void saveFile(MultipartFile file) {
        musicRepository.save(file);
    }

    @Override
    public User update(User user) {
        User savedUser = userRepository.findByUsername(user.getUsername());
        if (savedUser == null) {
            save(user);
        }
        savedUser.setMail(user.getMail());
        savedUser.setPassword(user.getPassword());
        return save(savedUser);
    }

    @Override
    public List<Music> findAllMusic(String username) {
        return ImmutableList.copyOf(userRepository.findAllByUsername(username));
    }

}
