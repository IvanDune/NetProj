package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.domain.User;
import com.example.servingwebcontent.domain.dnd.characters.*;
import com.example.servingwebcontent.domain.dnd.characters.Character;
import com.example.servingwebcontent.logic.Randomizer;
import com.example.servingwebcontent.repos.UserRepos;
import com.example.servingwebcontent.repos.dnd.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    UserRepos userRepos;

    @Autowired
    RaceRepos raceRepos;

    @Autowired
    CharacteristicRepos characteristicRepos;

    @Autowired
    ChaClassRepos chaClassRepos;

    @Autowired
    CharacterRepos characterRepos;

    @Autowired
    NumberRepos numberRepos;


    int[] characteristics = new int[6];
    int[] characteristicsMod = new int[6];

    @GetMapping("/create")
    public String create(@AuthenticationPrincipal User user, Model model){
        for (int i = 0; i < 6; i++){
            characteristics[i] = Randomizer.characteristic();
            characteristicsMod[i] = Randomizer.characteristicMod(characteristics[i]);
            numberRepos.save(new DHNumber(characteristics[i]));
        }
        Character ch = characterRepos.findByName("CharacterCreate");
        if (ch != null)
            characterRepos.delete(ch);

        List<String> chEn = new ArrayList<>();
        Iterable<Race> races = raceRepos.findAll();
        Iterable<ChaClass> chaClasses = chaClassRepos.findAll();

        for (CharacteristicEnum characteristicEnum : CharacteristicEnum.values()){
            chEn.add(characteristicEnum.name());
        }

        model.addAttribute("clazzes", chaClasses);
        model.addAttribute("user",user);
        model.addAttribute("races",races);
        model.addAttribute("charEns", chEn);
        model.addAttribute("characteristics",characteristics);
        model.addAttribute("characteristicsMod",characteristicsMod);
        return "charCreate";
    }

    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model){

        for (int i = 0; i < 6; i++){
            characteristics[i] = Randomizer.characteristic();
            characteristicsMod[i] = Randomizer.characteristicMod(characteristics[i]);
            numberRepos.save(new DHNumber(characteristics[i]));
        }
        Character ch = characterRepos.findByName("CharacterCreate");
        if (ch != null)
            characterRepos.delete(ch);

        Iterable<Race> races = raceRepos.findAll();

        model.addAttribute("races",races);
        model.addAttribute("user",user);
        model.addAttribute("characteristics",characteristics);
        model.addAttribute("characteristicsMod",characteristicsMod);
        return "stats";
    }

    @GetMapping("race")
    public String race(@AuthenticationPrincipal User user,
                       Model model){
        Iterable<Race> races = raceRepos.findAll();
        model.addAttribute("races",races);
        return "race";
    }

    @GetMapping("class")
    public String clazz(@AuthenticationPrincipal User user,
                        Model model){
        Iterable<ChaClass> chaClasses = chaClassRepos.findAll();
        model.addAttribute("clazzes", chaClasses);
        return "clazz";
    }


    @GetMapping("/race/{race}")
    public String raceDescription(@PathVariable Race race,
                                  Model model){
        model.addAttribute("race",race);
        model.addAttribute("raceVariety",race.getRaceVarietiesSet().size());
        return "descRace";
    }

    @GetMapping("/class/{chaClass}")
    public String classDescription(@PathVariable ChaClass chaClass,
                                       Model model){
        model.addAttribute("clazz",chaClass);
//        model.addAttribute("clazzSaves",chaClass.getPro_saves());
//        model.addAttribute("clazzArmor",chaClass.getPro_armor());
//        model.addAttribute("clazzSkills",chaClass.getPro_skills());
//        model.addAttribute("clazzWeapon",chaClass.getPro_weapon());
//        model.addAttribute("clazzAbilities",chaClass.getClassAbilitiesSet());
        return "descClass";
    }

    @GetMapping("/result")
    public String result(Model model){
        Character character = characterRepos.findByName("CharacterCreate");
        Optional<Race> r = raceRepos.findById(character.getRaceId());
        Race race = r.get();
        character.setRaceName(race.getName());

        Optional<ChaClass> c = chaClassRepos.findById(character.getClassId());
        ChaClass chaClass = c.get();
        character.setClassName(chaClass.getName());

        character.setClassName(chaClass.getName());
        character.setRaceName(race.getName());

        model.addAttribute("character", character);
        model.addAttribute("race", race);
        model.addAttribute("clazz", chaClass);
        model.addAttribute("raceVariety", race.getRaceVarietiesSet().size());

        characterRepos.save(character);
        return "characterRes";
    }

    @PostMapping
    public String regen(){
        return "redirect:/character";
    }

    @PostMapping("/goRace")
    public String goRace(Model model){
        Characteristics characteristics1 =
                new Characteristics(characteristics[0],characteristicsMod[0],characteristics[1],
                characteristicsMod[1],characteristics[2],characteristicsMod[2],
                characteristics[3],characteristicsMod[3],characteristics[4],
                characteristicsMod[4],characteristics[5],characteristicsMod[5]);
        characteristicRepos.save(characteristics1);
        Character character = new Character();
        character.setCharacteristicsId(characteristics1.getId());
        character.setName("CharacterCreate");
        character.setCharacteristicsId(characteristics1.getId());
        characterRepos.save(character);
        return "redirect:/character/race";
    }

    @PostMapping("race/goClass")
    public String goClass(@RequestParam Long raceId, @RequestParam Long goClazz, Model model){
        Race race = raceRepos.findById(raceId).orElse(new Race());
        Character character = characterRepos.findByName("CharacterCreate");
        if (race.getRaceVarietiesSet().size()!=0){
            character.setRaceVariety(goClazz);
        }
        character.setRaceId(race.getId());
        characterRepos.save(character);
        model.addAttribute("character",character);
        return "redirect:/character/class";
    }

    @PostMapping("/class/goEnd")
    public String goEnd(@RequestParam Long classId, @RequestParam int level, Model model){

        Character character = characterRepos.findByName("CharacterCreate");
        character.setClassId(classId);
        character.setLevel(level);
        characterRepos.save(character);
        return "redirect:/character/result";
    }

    @PostMapping("/saveCharacter")
    public String saveCharacter(@AuthenticationPrincipal User user,
                                @RequestParam String characterName, Model model){
        if (characterName == ""){
            model.addAttribute("mesError", "Please, enter character name");
            return "characterRes";
        }
        Character character = characterRepos.findByName("CharacterCreate");
        character.setName(characterName);

        User user1 = userRepos.findByLogin(user.getLogin());
        user1.getCharacters().add(character);
        character.setUserId(user1.getId());


        characterRepos.save(character);
        userRepos.save(user1);
        return "redirect:/user/profile";
    }
}
