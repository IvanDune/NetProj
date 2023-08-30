package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Character;
import com.example.servingwebcontent.dto.dnd.characters.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface CharacterRepos extends JpaRepository<Character, Long> {
    Character findByName(String name);

    Race findById(Event.ID id);

}
