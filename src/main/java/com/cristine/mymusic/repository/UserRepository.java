package com.cristine.mymusic.repository;

import com.cristine.mymusic.model.Music;
import com.cristine.mymusic.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByUsername(String username);
    public List<Music> findAllByUsername(String username);
}
