package com.cristine.mymusic.services.impl;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.repository.MusicRepository;
import com.cristine.mymusic.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public void save(Music music) throws IOException {
        musicRepository.save(music);

    }
}
