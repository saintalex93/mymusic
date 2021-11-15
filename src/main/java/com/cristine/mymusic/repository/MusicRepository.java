package com.cristine.mymusic.repository;

import com.cristine.mymusic.model.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer> {
}
