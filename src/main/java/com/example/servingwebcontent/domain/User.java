package com.example.servingwebcontent.domain;
import javax.persistence.*;

@Table(name="user", schema = "public")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    @Column(name="login")
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="nickname")
    private String nickname;
    @Column(name="email")
    private String email;

    public User() {
    }

    public User(String login, String password, String nickname, String email) {
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}