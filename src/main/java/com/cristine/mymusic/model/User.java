package com.cristine.mymusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(name = "uk_username", columnNames = { "username" }) })
public class User implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    private Integer id;
    @Column(nullable = false)
    private String username;
    private String mail;
    private String password;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.PERSIST)
    private List<Music> music;

    public User() {
    }

    public User(Integer id, String username, String mail, String password, List<Music> music) {
        this.id = id;
        this.username = username;
        this.mail = mail;
        this.password = password;
        this.music = music;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Music> getMusic() {
        return music;
    }
}
