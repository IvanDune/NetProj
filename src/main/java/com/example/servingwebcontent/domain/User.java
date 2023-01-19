package com.example.servingwebcontent.domain;
import com.example.servingwebcontent.domain.dnd.characters.Character;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Table(name="user", schema = "public")
@Entity
public class User implements UserDetails, Comparable<User>{

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

    @Column(name="description")
    private String description;

//    @Column(name="numVote") // Number of vote
//    private Integer numVote;

    @Column(name="grade") // Final grade
    private Integer grade;

    @Column(name="characterId")
    @OneToMany
    @CollectionTable(name = "user_character", joinColumns = @JoinColumn(name = "character_id"))
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

    public void setGrade(Integer grade){
        if (roles.contains("MASTER"))
            this.grade = grade;
    }

    public Integer getGrade(){
        return grade;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }


    public void changeVote(Review review){ // Plus new vote
        if (roles.contains(Role.MASTER)){
            int allVotes = grade * reviews.size()  + review.getGrade();
            reviews.add(review);
            grade = (allVotes)/(reviews.size());

        }
    }

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

    public Boolean getActive() {
        return active;
    }

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    @Override
    public int compareTo(User user) {
        return id.compareTo(user.getId());
    }
}