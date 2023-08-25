package com.example.servingwebcontent.dto;
import com.example.servingwebcontent.dto.dnd.characters.Character;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import java.util.*;

@Table(name="user", schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements UserDetails, Comparable<User>{
    //TODO Почему используем UserDetails
    //TODO Заменить использование .xml liquibase на .yml в корректной форме
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    @Column(name="login", nullable = false,unique = true)
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="nickname")
    private String nickname;
    @Column(name="email")
    private String email;
    @Column(name="active")
    private Boolean active;
    @Column(name="description")
    private String description;
    @Column(name="grade") // Только для мастеров Final Grade
    private Integer grade;
    @Column(name="characterId")
    @OneToMany
    @CollectionTable(name = "user", joinColumns = @JoinColumn(name = "character_id"))
    Set<Character> characters;
    @Column(name="roles")
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @Column(name = "reviews")
    @OneToMany
    @CollectionTable(name = "reviews", joinColumns = @JoinColumn(name = "master"))
    private Set<Review> reviews;
    //TODO Разобраться с аннотациями над OneToMany и ManyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_sub",
            joinColumns = { @JoinColumn(name ="user_id")},
            inverseJoinColumns = { @JoinColumn(name = "game_id")}
    )
    private Set<Game> subscriptions = new HashSet<>();
    public User(String login, String password, String nickname, String email) {
        this.login = login;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.grade = 0;
    }

    public Integer gameValue(){
        return getSubscriptions().size();
    }
    public Integer characterValue(){
        return getCharacters().size();
    }
    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
    public Boolean isActive() {
        return active;
    }
    public void setGrade(Integer grade){
        if (roles.contains("MASTER"))
            this.grade = grade;
    }
      public void changeVote(Review review){ // Plus new vote
        if (roles.contains(Role.MASTER)){
            int allVotes = grade * reviews.size()  + review.getGrade();
            reviews.add(review);
            grade = (allVotes)/(reviews.size());

        }
    }
    //TODO Структура получения мастером оценки
    public void changeVote(Review oldReview, Review newReview){ // Change old vote
        if (roles.contains("MASTER")){
            int allVotes = grade * reviews.size()  + newReview.getGrade() - oldReview.getGrade();
            grade = (allVotes)/(reviews.size()+1);
        }
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
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
    @Override
    public int compareTo(User user) {
        return id.compareTo(user.getId());
    }
}