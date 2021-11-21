package com.cristine.mymusic.services;

import com.cristine.mymusic.model.Music;

import java.io.IOException;
import java.util.List;

public interface MusicService {
    public void save(Music music) throws IOException;

}
