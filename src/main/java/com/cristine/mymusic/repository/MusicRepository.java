package com.cristine.mymusic.repository;

import com.cristine.mymusic.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {
    public void save(MultipartFile file);
    public List<Music> findAll();
}
