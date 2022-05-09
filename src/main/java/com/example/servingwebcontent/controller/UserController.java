package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.Game;
import com.example.servingwebcontent.domain.Role;
import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.domain.dnd.characters.ChaClass;
import com.example.servingwebcontent.domain.dnd.characters.Character;
import com.example.servingwebcontent.domain.dnd.characters.Race;
import com.example.servingwebcontent.repos.GameRepos;
import com.example.servingwebcontent.repos.UserRepos;
import com.example.servingwebcontent.repos.dnd.ChaClassRepos;
import com.example.servingwebcontent.repos.dnd.CharacterRepos;
import com.example.servingwebcontent.repos.dnd.RaceRepos;
import com.example.servingwebcontent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepos userRepos;

    @Autowired
    private GameRepos gameRepos;

    @Autowired
    private RaceRepos raceRepos;

    @Autowired
    private ChaClassRepos chaClassRepos;

    @Autowired
    private CharacterRepos characterRepos;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user")
    public String main(Model model){
        model.addAttribute("users", userService.findAll());
            return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/user/{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @GetMapping("{user}/{character}")
    public String characterDescription(@PathVariable User user, @PathVariable Character character,
                                       Model model){
        Optional<Race> r = raceRepos.findById(character.getRaceId());
        Race race = r.get();
        Optional<ChaClass> c = chaClassRepos.findById(character.getClassId());
        ChaClass chaClass = c.get();

        model.addAttribute("character", character);
        model.addAttribute("race", race);
        model.addAttribute("clazz", chaClass);
        return "characterDescription";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/user")
    public String filter(
        @RequestParam(defaultValue = "") String filter,
        Model model){

            if (filter != null && !filter.isEmpty()){
                if (userService.loadUserByUsername(filter)==null){
                    model.addAttribute("message", "This user does not exist.");
                    model.addAttribute("users", userService.findAll());
                } else{
                    List<UserDetails> userDetailsList = new ArrayList<>();
                    userDetailsList.add(userService.loadUserByUsername(filter));
                    model.addAttribute("users", userDetailsList);
                }
            } else{
                model.addAttribute("users", userService.findAll());
            }
            model.addAttribute("roles", Role.values());
            model.addAttribute("filter", filter);

            return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/user/{user}")
    public String userSave(
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user,
            Model model){

        userService.saveChangedUser(user, form);
        return "redirect:/user";
    }

    @GetMapping("/user/profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        User user1 = userRepos.findByLogin(user.getLogin());
        Iterable<Character> characters = user1.getCharacters();
        model.addAttribute("games", user1.getSubscriptions());
        model.addAttribute("user", user1);
        model.addAttribute("nickname", user1.getNickname());
        model.addAttribute("email", user1.getEmail());
        model.addAttribute("characters",characters);

        return "profile";
    }

    @PostMapping("/unsub")
    public String userUnsubscribe(@AuthenticationPrincipal User user,
                                  @RequestParam String game,
                                  Model model) {
        Game game1 = gameRepos.findByName(game);

        User user1 = userRepos.findByLogin(user.getLogin());
        for (Game gm : user1.getSubscriptions()) {
            if (gm.getName().equals(game)) {
                user1.getSubscriptions().remove(gm);
                break;

            }
        }
        userService.saveUser(user1);

        model.addAttribute("games", user.getSubscriptions());

        return "redirect:/user/profile";

    }

    @PostMapping("/deleteCharacter")
    public String deleteCharacter(@AuthenticationPrincipal User user,
            @RequestParam Long characterId){
        Optional<Character> ch = characterRepos.findById(characterId);
        Character character = ch.get();

        User userHelp = userRepos.findByLogin(user.getLogin());
        userHelp.getCharacters().remove(character);
        characterRepos.delete(character);
        userRepos.save(userHelp);

        return "redirect:/user/profile";
    }

    @PostMapping("/user/profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String nickname,
            @RequestParam String email,
            Model model
    ){
        if (nickname==""||email==""){
            model.addAttribute("message","Fields cannot be empty");
            User user1 = userRepos.findByLogin(user.getLogin());
            model.addAttribute("games", user1.getSubscriptions());
            model.addAttribute("user", user1);
            model.addAttribute("nickname", user.getNickname());
            model.addAttribute("email", user.getEmail());
            return "profile";
        }
        userService.updateProfile(user, nickname, email);
        return "redirect:/";
    }

}
