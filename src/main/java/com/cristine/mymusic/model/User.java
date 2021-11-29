package com.cristine.mymusic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

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
    private String email;
    private String password;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.PERSIST)
//    private List<Music> music;

    public User() {
    }

    public User(Integer id, String username, String mail, String password/* , List<Music> music*/) {
        this.id = id;
        this.username = username;
        this.email = mail;
        this.password = password;
//        this.music = music;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Music> getMusic() {
//        return music;
//    }
}
