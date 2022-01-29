package com.example.servingwebcontent.domain;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Table(name="user", schema = "public")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="nickname")
    private String nickname;

    @Column(name="email")
    private String email;

    @Column(name="active")
    private Boolean active;

    @Column(name="roles")
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_sub",
            joinColumns = { @JoinColumn(name ="user_id")},
            inverseJoinColumns = { @JoinColumn(name = "game_id")}
    )
    private Set<Game> subscriptions = new HashSet<>();

    public User() {
    }

    public User(String login, String password, String nickname, String email) {
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public Integer gameValue(){
        return getSubscriptions().size();
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }

    public Set<Game> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(Set<Game> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }


}