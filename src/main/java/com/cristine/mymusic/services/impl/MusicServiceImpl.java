package com.cristine.mymusic.services.impl;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.model.MusicDTO;
import com.cristine.mymusic.repository.MusicRepository;
import com.cristine.mymusic.services.MusicService;
import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public void save(Music music) throws IOException {
        musicRepository.save(music);
    }

    @Override
    public List<Music> findAll() throws IOException {
//        List<Music> musics = ImmutableList.copyOf(musicRepository.findAll());
//        List<MusicDTO> dtos = new ArrayList<>();
//        List<MusicDTO> collect = musics.stream().map(music -> new MusicDTO(music)).collect(Collectors.toList());

        return ImmutableList.copyOf(musicRepository.findAll());
    }
}
